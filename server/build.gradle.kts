plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.kotlinSerialization)
    application
}

group = "com.mario"
version = "1.0.0"
application {
    mainClass.set("com.mario.ApplicationKt")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=${extra["io.ktor.development"] ?: "false"}")
}

dependencies {
    implementation(libs.logback)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.negotiation)
    implementation(libs.ktor.seralization.kotlinx.json)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.server.auth)
    implementation(libs.ktor.server.jwt)
    testImplementation(libs.ktor.server.tests)
    testImplementation(libs.kotlin.test.junit)
}