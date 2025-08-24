import io.gitlab.arturbosch.detekt.Detekt
import org.apache.tools.ant.filters.ReplaceTokens
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
  `java-library`
  alias(libs.plugins.kotlin.jvm)
  alias(libs.plugins.detekt)
  alias(libs.plugins.ktfmt)
}

repositories { mavenCentral() }

java { toolchain { languageVersion = JavaLanguageVersion.of(21) } }

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Integration Test

sourceSets {
  create("integrationTest") {
    compileClasspath += sourceSets.main.get().output
    runtimeClasspath += sourceSets.main.get().output
  }
}

val integrationTestSourceSet: SourceSet = sourceSets["integrationTest"]

val integrationTestImplementation: Configuration by
    configurations.getting { extendsFrom(configurations.implementation.get()) }
val integrationTestRuntimeOnly: Configuration by
    configurations.getting { extendsFrom(configurations.runtimeOnly.get()) }

val integrationTestTask =
    tasks.register<Test>("integrationTest") {
      group = LifecycleBasePlugin.VERIFICATION_GROUP
      testClassesDirs = integrationTestSourceSet.output.classesDirs
      classpath = integrationTestSourceSet.runtimeClasspath
    }

tasks.check { dependsOn(integrationTestTask) }

tasks.withType<Test>().configureEach {
  useJUnitPlatform()
  testLogging { events(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED) }
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Dependencies

dependencies {
  testImplementation(libs.bundles.test.common)
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")

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
// processResources token replacement

val mongoDriverName = libs.mongodb.driver.sync.get().name
val mongoDriverVersion = libs.versions.mongodb.driver.sync.get()

tasks.processResources {
  filesMatching("**/driver.properties") {
    filter<ReplaceTokens>(
        "tokens" to mapOf("driver.name" to mongoDriverName, "driver.version" to mongoDriverVersion))
  }
}
