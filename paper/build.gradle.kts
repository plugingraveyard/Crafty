plugins {
    id("paper-plugin")
}

project.group = "${rootProject.group}.paper"

repositories {
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")

    maven("https://repo.codemc.io/repository/maven-public/")

    //maven("https://repo.crazycrew.us/snapshots/")

    maven("https://jitpack.io/")

    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("com.ryderbelserion.ruby", "ruby-paper", "1.2-snapshot")

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

    shadowJar {
        listOf(
            "com.ryderbelserion.ruby",
            "org.bstats",
            "ch.jalu"
        ).forEach {
            relocate(it, "libs.$it")
        }
    }

    processResources {
        filesMatching("paper-plugin.yml") {
            val props = mapOf(
                "name" to rootProject.name,
                "group" to project.group.toString(),
                "version" to rootProject.version,
                "description" to rootProject.description,
                "authors" to rootProject.properties["authors"],
                "apiVersion" to "1.20",
                "website" to "https://modrinth.com/plugin/${rootProject.name.lowercase()}"
            )

            expand(props)
        }
    }
}