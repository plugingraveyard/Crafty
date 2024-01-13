dependencies {
    compileOnly("com.ryderbelserion.cluster:api:6.3")

    api("ch.jalu:configme:1.4.1") {
        exclude(group = "org.yaml", module = "snakeyaml")
    }
}