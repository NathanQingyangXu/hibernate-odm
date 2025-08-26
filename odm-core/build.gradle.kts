import io.gitlab.arturbosch.detekt.Detekt
import org.apache.tools.ant.filters.ReplaceTokens
import org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED
import org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED
import org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED

plugins {
  alias(libs.plugins.kotlin.jvm)
  alias(libs.plugins.detekt)
  alias(libs.plugins.ktfmt)
}

repositories { mavenCentral() }

java { toolchain { languageVersion = JavaLanguageVersion.of(21) } }

tasks.withType<Test>().configureEach {
  useJUnitPlatform()
  testLogging { events(PASSED, SKIPPED, FAILED) }
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Integration Test

val integrationTestName = "integrationTest"

sourceSets {
  create(integrationTestName) {
    compileClasspath += sourceSets.main.get().output
    runtimeClasspath += sourceSets.main.get().output
  }
}

val integrationTestSourceSet: SourceSet = sourceSets[integrationTestName]

val integrationTestImplementation: Configuration by
    configurations.getting { extendsFrom(configurations.implementation.get()) }
val integrationTestRuntimeOnly: Configuration by
    configurations.getting { extendsFrom(configurations.runtimeOnly.get()) }

val integrationTestTask =
    tasks.register<Test>(integrationTestName) {
      group = LifecycleBasePlugin.VERIFICATION_GROUP
      testClassesDirs = integrationTestSourceSet.output.classesDirs
      classpath = integrationTestSourceSet.runtimeClasspath
    }

tasks.check { dependsOn(integrationTestTask) }

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Dependencies

dependencies {
  testImplementation(libs.bundles.test.common)
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
  testImplementation(libs.mockk)

  integrationTestImplementation(libs.bundles.test.common)
  integrationTestRuntimeOnly("org.junit.platform:junit-platform-launcher")

  integrationTestImplementation(libs.hibernate.testing) {
    exclude(group = "org.apache.logging.log4j", module = "log4j-core")
  }

  api(libs.hibernate.orm.core)
  api(libs.mongodb.driver.sync)

  implementation(libs.sl4j.api)
  implementation(libs.logback.classic)
  implementation(libs.kotlin.logging)
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Static Analysis

detekt {
  buildUponDefaultConfig = true
  allRules = false
  config.setFrom("$rootDir/config/detekt.yml")
}

tasks.withType<Detekt>().configureEach { reports { html.required = true } }

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// processResources tokens replacement

val mongoDriverName = libs.mongodb.driver.sync.get().name
val mongoDriverVersion = libs.versions.mongodb.driver.sync.get()

tasks.processResources {
  filesMatching("mongo_driver.properties") {
    filter<ReplaceTokens>(
        "tokens" to mapOf("driver.name" to mongoDriverName, "driver.version" to mongoDriverVersion))
  }
}
