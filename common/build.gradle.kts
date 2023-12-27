plugins {
    id("root-plugin")
}

dependencies {
    api(project(":api"))

    compileOnly(libs.cluster.api)

    api(libs.configme) {
        exclude(group = "org.yaml", module = "snakeyaml")
    }
}