plugins {
    id("xyz.jpenilla.run-paper") version "2.1.0"

    id("paper-plugin")
}

project.group = "${rootProject.group}.paper"

repositories {
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")

    maven("https://repo.codemc.io/repository/maven-public/")

    maven("https://repo.triumphteam.dev/snapshots/")
}

dependencies {
    implementation("dev.triumphteam", "triumph-cmd-bukkit", "2.0.0-ALPHA-8")

    implementation("com.ryderbelserion.cluster", "cluster-api", "0.1.1")

    implementation("org.bstats", "bstats-bukkit", "3.0.2")

    implementation("ch.jalu", "configme", "1.3.1")

    compileOnly("me.clip", "placeholderapi", "2.11.3")
}

val component: SoftwareComponent = components["java"]

tasks {
    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = project.group.toString()
                artifactId = "${rootProject.name.lowercase()}-api"
                version = rootProject.version.toString()

                from(component)
            }
        }
    }

    runServer {
        minecraftVersion("1.20.1")

        jvmArgs("-Dnet.kyori.ansi.colorLevel=truecolor")
    }

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
            "apiVersion" to "1.20"
        )

        filesMatching("paper-plugin.yml") {
            expand(props)
        }
    }
}