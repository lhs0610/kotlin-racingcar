plugins {
    kotlin("jvm") version "1.8.10"
    id("org.jlleitschuh.gradle.ktlint") version "10.3.0"
}

group = "camp.nextstep.edu"
version = "1.0-SNAPSHOT"
val kotestVersion = "5.4.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core-jvm:$kotestVersion")
    testImplementation("io.kotest:kotest-property-jvm:$kotestVersion")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "11"
    }
    test {
        useJUnitPlatform()
    }
    ktlint {
        verbose.set(true)
    }
}