plugins {
    id("paper-plugin")
}

project.group = "${rootProject.group}.paper"
project.version = "${rootProject.version}"

repositories {
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")

    maven("https://repo.codemc.io/repository/maven-public/")

    maven("https://repo.triumphteam.dev/snapshots/")
}

dependencies {
    implementation(project(":common"))

    implementation(libs.cluster.paper)

    implementation(libs.triumphcmds)

    compileOnly(libs.placeholderapi)
}

tasks {
    shadowJar {
        listOf(
            "com.ryderbelserion.cluster",
            "dev.triumphteam",
            "ch.jalu"
        ).forEach {
            relocate(it, "libs.$it")
        }
    }

    processResources {
        val props = mapOf(
            "name" to rootProject.name,
            "group" to project.group,
            "version" to rootProject.version,
            "description" to rootProject.description,
            "apiVersion" to "1.20",
            "website" to "https://modrinth.com/plugin/${rootProject.name.lowercase()}"
        )

        filesMatching("paper-plugin.yml") {
            expand(props)
        }
    }
}