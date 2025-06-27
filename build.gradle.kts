val javaVersion = 21

val kotlinVersion = "2.2.0"
val logbackVersion = "1.5.18"
val zingVersion = "3.5.3"

plugins {
    kotlin("jvm") version "2.2.0"
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
    // Ktor server
    implementation("io.ktor:ktor-server-core")
    implementation("io.ktor:ktor-server-cio")
    implementation("io.ktor:ktor-serialization-jackson")
    implementation("io.ktor:ktor-server-content-negotiation")

    // Logging
    implementation("ch.qos.logback:logback-classic:$logbackVersion")

    // QR code
    implementation("com.google.zxing:javase:$zingVersion")

    // Test
    testImplementation("io.ktor:ktor-server-test-host")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
}
