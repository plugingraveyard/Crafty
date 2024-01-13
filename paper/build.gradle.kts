plugins {
    id("io.papermc.paperweight.userdev") version "1.5.11"

    id("xyz.jpenilla.run-paper") version "2.2.2"
}

repositories {
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")

    maven("https://repo.papermc.io/repository/maven-public/")

    maven("https://repo.codemc.io/repository/maven-public/")

    maven("https://repo.triumphteam.dev/snapshots/")

    maven("https://repo.oraxen.com/releases/")

    flatDir { dirs("libs") }
}

dependencies {
    paperweight.paperDevBundle("1.20.4-R0.1-SNAPSHOT")

    implementation("net.kyori:adventure-platform-bukkit:4.3.2")

    implementation("com.ryderbelserion.cluster:paper:6.3")

    implementation("org.bstats:bstats-bukkit:3.0.2")

    compileOnly("com.arcaniax:HeadDatabase-API:1.3.1")

    compileOnly("com.github.MilkBowl:VaultAPI:1.7.1")
}

tasks {
    assemble {
        dependsOn(reobfJar)
    }

    /*
    // Publish to hangar.papermc.io.
hangarPublish {
    publications.register("plugin") {
        version.set("${project.version}")

        id.set(rootProject.name)

        channel.set(type)

        changelog.set(rootProject.file("CHANGELOG.md").readText())

        apiKey.set(System.getenv("hangar_key"))

        platforms {
            register(Platforms.PAPER) {
                jar.set(file("$directory/${rootProject.name}-${project.name.uppercaseFirstChar()}-${project.version}.jar"))

                platformVersions.set(listOf(mcVersion))
            }
        }
    }
}
*/

    shadowJar {
        listOf(
            "org.bstats"
        ).forEach {
            relocate(it, "libs.$it")
        }
    }

    runServer {
        jvmArgs("-Dnet.kyori.ansi.colorLevel=truecolor", "-Dfile.encoding=UTF8")

        minecraftVersion("1.20.4")
    }

    modrinth {
        loaders.addAll("paper", "purpur")
    }

    processResources {
        /*val properties = hashMapOf(
            "name" to rootProject.name,
            "version" to project.version,
            "group" to rootProject.group,
            "description" to rootProject.description
            //"apiVersion" to rootProject.properties["apiVersion"],
            //"authors" to rootProject.properties["authors"],
            //"website" to rootProject.properties["website"]
        )

        filesMatching("paper-plugin.yml") {
            expand(properties)
        }*/
    }
}