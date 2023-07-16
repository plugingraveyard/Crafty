import org.gradle.kotlin.dsl.maven

plugins {
    `java-library`

    id("com.github.johnrengelman.shadow")
}

repositories {
    maven("https://repo.crazycrew.us/first-party/")

    maven("https://repo.crazycrew.us/third-party/")

    maven("https://repo.crazycrew.us/snapshots/")

    maven("https://repo.crazycrew.us/releases/")

    maven("https://jitpack.io/")

    mavenCentral()
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of("17"))
}

tasks {
    compileJava {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(17)

        options.compilerArgs = listOf("-parameters")
    }
}