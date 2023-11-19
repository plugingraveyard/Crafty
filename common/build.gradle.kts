plugins {
    id("root-plugin")
}

project.group = "${rootProject.group}.common"
project.version = "${rootProject.version}"

base {
    archivesName.set("${rootProject.name}-${project.name}")
}

dependencies {
    api(project(":api"))

    compileOnlyApi(libs.configme)

    compileOnly(libs.cluster.api)

    compileOnly(libs.annotations)

    compileOnly(libs.gson)
}