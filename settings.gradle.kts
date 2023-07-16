rootProject.name = "Crafty"

include("fabric")

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()

        maven("https://maven.fabricmc.net")
    }
}