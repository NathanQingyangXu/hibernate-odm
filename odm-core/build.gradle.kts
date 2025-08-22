import io.gitlab.arturbosch.detekt.Detekt

plugins {
    `java-library`
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.detekt)
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation(libs.junit.jupiter.engine)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    api(libs.hibernate.orm.core)
    api(libs.mongodb.driver.sync)
    implementation(libs.sl4j.api)
    implementation(libs.logback.classic)
    implementation(libs.kotlin.logging)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

detekt {
    buildUponDefaultConfig = true // preconfigure defaults
    allRules = true // activate all available (even unstable) rules.
    //config.setFrom("$projectDir/config/detekt.yml") // point to your custom config defining rules to run, overwriting default behavior
    //baseline = file("$projectDir/config/baseline.xml") // a way of suppressing issues before introducing detekt
}

tasks.withType<Detekt>().configureEach {
    jvmTarget = "21"
    reports {
        html.required = true // observe findings in your browser with structure and code snippets
        xml.required = true // checkstyle like format mainly for integrations like Jenkins
        sarif.required = true // standardized SARIF format (https://sarifweb.azurewebsites.net/) to support integrations with GitHub Code Scanning
        md.required = true // simple Markdown format
    }
}
