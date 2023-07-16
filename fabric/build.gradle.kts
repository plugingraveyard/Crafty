plugins {
    `java-library`

    //id("fabric-loom") version "1.3-SNAPSHOT"
}

group = "${rootProject.group}.fabric"

repositories {
    maven("https://maven.fabricmc.net/")
}

dependencies {
    //minecraft("com.mojang", "minecraft", "1.20.1")

    //mappings("net.fabricmc:yarn:1.20.1+build.9:v2")

    //modImplementation("net.fabricmc", "fabric-loader", "0.14.21")
    //modImplementation("net.fabricmc.fabric-api", "fabric-api", "0.85.0+1.20.1")
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