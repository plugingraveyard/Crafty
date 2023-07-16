plugins {
    `java-library`
}

rootProject.group = "me.corecraft.crafty"
rootProject.description = "Lightweight plugin containing server essentials."
rootProject.version = "0.0.1"

val combine = tasks.register<Jar>("combine") {
    mustRunAfter("build")
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    val jarFiles = subprojects.flatMap { subproject ->
        files(subproject.layout.buildDirectory.file("libs/${rootProject.name}-${subproject.name}-${subproject.version}.jar").get())
    }.filter { it.name != "MANIFEST.MF" }.map { file ->
        if (file.isDirectory) file else zipTree(file)
    }

    from(jarFiles)
}

allprojects {
    apply(plugin = "java")

    java {
        toolchain.languageVersion.set(JavaLanguageVersion.of("17"))
    }

    project(":paper") {
        repositories {
            maven("https://repo.papermc.io/repository/maven-public/")
        }
    }

    project(":fabric") {
        repositories {
            maven("https://maven.fabricmc.net")
        }
    }

    repositories {
        mavenCentral()
    }

    tasks {
        compileJava {
            options.encoding = Charsets.UTF_8.name()
            options.release.set(17)
        }
    }
}

tasks {
    assemble {
        subprojects.forEach { project ->
            dependsOn(":${project.name}:build")
        }

        finalizedBy(combine)
    }
}