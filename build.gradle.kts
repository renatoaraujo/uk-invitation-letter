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
    implementation("org.junit.jupiter:junit-jupiter:5.10.0")
    implementation(kotlin("stdlib-jdk8"))

    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks {
    named("run") {
        dependsOn("test")
    }
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("io.ukinvitationletter.MainKt")

    val cmdConfigPath = project.findProperty("configPath") as String?
    val cmdOutputPath = project.findProperty("outputPath") as String?

    val defaultConfigPath = project.findProperty("defaultConfigPath") as String? ?: ""
    val defaultOutputPath = project.findProperty("defaultOutputPath") as String? ?: ""

    val resolvedConfigPath = cmdConfigPath ?: defaultConfigPath.replace("\${projectDir}", project.projectDir.absolutePath)
    val resolvedOutputPath = cmdOutputPath ?: defaultOutputPath.replace("\${projectDir}", project.projectDir.absolutePath)

    print(cmdConfigPath)
    print(cmdOutputPath)

    applicationDefaultJvmArgs = listOf(
        "-DconfigPath=$resolvedConfigPath",
        "-DoutputPath=$resolvedOutputPath"
    )
}