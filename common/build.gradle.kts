plugins {
    id("root-plugin")
}

dependencies {
    api(project(":api"))

    compileOnly(libs.cluster.api)

    implementation(libs.cloud.extras)

    implementation(libs.cloud.core)

    api(libs.configme) {
        exclude(group = "org.yaml", module = "snakeyaml")
    }
}