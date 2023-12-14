plugins {
    alias(libs.plugins.paperweight)
    alias(libs.plugins.shadowjar)

    alias(libs.plugins.runpaper)

    `maven-publish`
}

base {
    archivesName.set(rootProject.name)
}

val mcVersion = rootProject.properties["minecraftVersion"] as String

dependencies {
    api(project(":common"))

    implementation(libs.bstats)

    implementation(libs.cluster5)

    implementation(libs.commandApi)

    compileOnly(libs.headdatabase)

    compileOnly(libs.vault)

    paperweightDevelopmentBundle("io.papermc.paper:dev-bundle:$mcVersion-R0.1-SNAPSHOT")
}

tasks {

    // Runs a test server.
    runServer {
        jvmArgs("-Dnet.kyori.ansi.colorLevel=truecolor")

        minecraftVersion(mcVersion)
    }

    // Assembles the plugin.
    assemble {
        dependsOn(reobfJar)
    }

    publishing {
        repositories {
            maven {
                url = uri("https://repo.crazycrew.us/releases/")

                credentials {
                    this.username = System.getenv("GRADLE_USERNAME")
                    this.password = System.getenv("GRADLE_PASSWORD")
                }
            }
        }
    }

    shadowJar {
        archiveClassifier.set("")

        exclude("META-INF/**")

        listOf(
          "org.bstats", "com.ryderbelserion.cluster", "dev.jorel.commandapi"
        ).forEach {
            relocate(it, "libs.$it")
        }
    }

    processResources {
        val properties = hashMapOf(
                "name" to rootProject.name,
                "version" to rootProject.version,
                "group" to rootProject.group,
                "description" to rootProject.description,
                "apiVersion" to rootProject.properties["apiVersion"],
                "authors" to rootProject.properties["authors"],
                "website" to rootProject.properties["website"]
        )

        inputs.properties(properties)

        filesMatching("paper-plugin.yml") {
            expand(properties)
        }
    }
}