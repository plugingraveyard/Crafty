plugins {
    id("root-plugin")
}

project.group = "${rootProject.group}.common"
project.version = "${rootProject.version}"

dependencies {
    api(project(":api"))

    compileOnlyApi(libs.configme)

    compileOnly(libs.cluster.api)

    compileOnly(libs.annotations)

    compileOnly(libs.gson)
}