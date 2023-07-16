pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()

        maven("https://maven.fabricmc.net")
    }
}

rootProject.name = "Crafty"

include("fabric")
include("paper")