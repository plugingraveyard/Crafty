plugins {
    id("root-plugin")
}

defaultTasks("build")

rootProject.group = "com.ryderbelserion.crafty"
rootProject.description = "Lightweight plugin containing server essentials."
rootProject.version = "1.0.0"

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
    listOf(
        ":fabric",
        ":paper"
    ).forEach {
        project(it) {
            apply(plugin = "java")


            if (this.name == "paper") {
                repositories {
                    maven("https://repo.papermc.io/repository/maven-public/")
                }

                dependencies {

                }
            }

            if (this.name == "fabric") {
                repositories {
                    maven("https://maven.fabricmc.net")
                }
            }

            dependencies {
                implementation("ch.jalu", "configme", "1.3.1")

                implementation("com.github.Carleslc.Simple-YAML", "Simple-Yaml", "1.8.4") {
                    exclude("org.yaml", "snakeyaml")
                }
            }
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