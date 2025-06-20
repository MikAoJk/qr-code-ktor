val javaVersion = 21

val kotlinVersion = "2.1.21"
val logbackVersion = "1.5.18"
val zingVersion = "3.5.3"

plugins {
    kotlin("jvm") version "2.1.21"
    id("io.ktor.plugin") version "3.2.0"
}

group = "mikaojk.github.io"
version = "0.0.1"

application {
    mainClass = "mikaojk.github.io.ApplicationKt"
}


kotlin {
    jvmToolchain(javaVersion)
}


repositories {
    mavenCentral()
}

dependencies {
    // KtorSever dependencies
    implementation("io.ktor:ktor-server-core")
    implementation("io.ktor:ktor-server-cio")
    implementation("io.ktor:ktor-serialization-jackson")
    implementation("io.ktor:ktor-server-content-negotiation")

    // Logging dependencies
    implementation("ch.qos.logback:logback-classic:$logbackVersion")

    // QR code dependencies
    implementation("com.google.zxing:javase:$zingVersion")

    // Test dependencies
    testImplementation("io.ktor:ktor-server-test-host")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
}
