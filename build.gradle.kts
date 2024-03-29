import org.gradle.kotlin.dsl.support.uppercaseFirstChar
import java.io.ByteArrayOutputStream

plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"

    id("com.modrinth.minotaur") version "2.8.7"

    `maven-publish`

    `java-library`
}

subprojects {
    plugins.apply("com.github.johnrengelman.shadow")
    plugins.apply("com.modrinth.minotaur")
    plugins.apply("java-library")

    repositories {
        maven("https://repo.crazycrew.us/snapshots/")

        maven("https://repo.crazycrew.us/releases/")

        maven("https://jitpack.io/")

        mavenCentral()
    }

    base {
        archivesName.set("${rootProject.name}-${project.name.uppercaseFirstChar()}")
    }

    version = "${rootProject.property("version")}.${commitsSinceLastTag()}"

    tasks {
        compileJava {
            options.encoding = Charsets.UTF_8.name()
            options.release.set(17)
        }

        javadoc {
            options.encoding = Charsets.UTF_8.name()
        }

        processResources {
            filteringCharset = Charsets.UTF_8.name()
        }

        shadowJar {
            archiveClassifier.set("")

            exclude("META-INF/**")
        }

        modrinth {
            autoAddDependsOn.set(false)

            token.set(System.getenv("modrinth_token"))

            projectId.set(rootProject.name.lowercase())

            versionName.set("${rootProject.name} ${project.version}")

            versionNumber.set("${project.version}")

            versionType.set("alpha")

            uploadFile.set(file("${project.layout.buildDirectory}/${rootProject.name}-${project.version}.jar"))

            gameVersions.addAll(
                "1.20.4"
            )

            changelog.set(rootProject.file("CHANGELOG.md").readText())
        }
    }

    java {
        toolchain.languageVersion.set(JavaLanguageVersion.of("17"))
    }
}

tasks {
    assemble {
        val jarsDir = File("$rootDir/jars")

        doFirst {
            delete(jarsDir)

            jarsDir.mkdirs()
        }

        subprojects.forEach { project ->
            dependsOn(":${project.name}:build")

            doLast {
                runCatching {
                    copy {
                        from(project.layout.buildDirectory.file("libs/${rootProject.name}-${project.name.uppercaseFirstChar()}-${project.version}.jar"))
                        into(jarsDir)
                    }
                }.onSuccess {
                    // Delete to save space on jenkins.
                    delete(project.layout.buildDirectory.get())
                    delete(rootProject.layout.buildDirectory.get())
                }.onFailure {
                    println("Failed to copy file out of build folder into jars directory: Likely does not exist.")
                }
            }
        }
    }
}

fun commitsSinceLastTag(): String {
    val tagDescription = ByteArrayOutputStream()
    exec {
        commandLine("git", "describe", "--tags")
        standardOutput = tagDescription
    }
    if (tagDescription.toString().indexOf('-') < 0) {
        return "0"
    }
    return tagDescription.toString().split('-')[1]
}