dependencies {
    api(project(":api"))

    compileOnly(libs.clusterApi5)

    api(libs.configme) {
        exclude(group = "org.yaml", module = "snakeyaml")
    }
}