plugins {
    id("root-plugin")
}

project.group = "${rootProject.group}.common"
project.version = "${rootProject.version}"

dependencies {
    api(project(":api"))

    api(libs.cluster.api)

    api(libs.config.me) {
        exclude("org.yaml", "snakeyaml")
    }

    compileOnly(libs.annotations)

    compileOnly(libs.adventure.mm)
    compileOnly(libs.adventure.api)
}