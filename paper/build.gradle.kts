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

    implementation("dev.triumphteam", "triumph-cmd-bukkit", "2.0.0-ALPHA-8")

    implementation("org.bstats", "bstats-bukkit", "3.0.2")

    implementation(libs.cluster.bukkit.api) {
        exclude("com.ryderbelserion.cluster", "cluster-api")
    }

    compileOnly("me.clip", "placeholderapi", "2.11.3")
}

tasks {
    shadowJar {
        listOf(
            "com.ryderbelserion.cluster",
            "dev.triumphteam",
            "org.bstats",
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