pluginManagement {
    repositories {
        maven("https://repo.papermc.io/repository/maven-public/")

        maven("https://maven.fabricmc.net/")

        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "crafty"

listOf(
    "common",
    "paper",
    "api"
).forEach {
    include("${rootProject.name}-$it")
    project(":${rootProject.name}-${it}").projectDir = file(it)
}