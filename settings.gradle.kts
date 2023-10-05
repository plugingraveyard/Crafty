pluginManagement {
    repositories {
        maven("https://repo.papermc.io/repository/maven-public/")

        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "Crafty"

listOf(
    "paper",
    "common",
    "api"
).forEach {
    include(it)
}