import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.21-2"
    id("com.github.johnrengelman.shadow") version "6.1.0"
    id("name.remal.check-updates") version "1.1.6"
}

group = "me.cmatheny"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")
}

tasks {
    test {
        useJUnitPlatform()
    }

    withType<KotlinCompile>() {
        kotlinOptions.jvmTarget = "1.8"
    }

    withType<GradleBuild> {
        finalizedBy(shadowJar)
    }
}
