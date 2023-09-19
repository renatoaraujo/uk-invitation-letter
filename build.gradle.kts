plugins {
    kotlin("jvm") version "1.9.0"
    application
}

group = "io.ukinvitationletter"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.itextpdf:itext7-core:8.0.1")
    implementation("org.slf4j:slf4j-nop:1.7.32")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation(kotlin("stdlib-jdk8"))

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("io.ukinvitationletter.MainKt")
    applicationDefaultJvmArgs = listOf(
        "-DconfigPath=${System.getProperty("configPath", "")}",
        "-DoutputPath=${System.getProperty("outputPath", "")}"
    )
}
