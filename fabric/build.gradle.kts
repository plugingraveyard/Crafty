plugins {
    id("root-plugin")

    //id("fabric-loom") version "1.3-SNAPSHOT"
}

tasks {
    shadowJar {
        archiveBaseName.set("${rootProject.name}-Fabric")

        archiveClassifier.set("")

        doLast {

        }
    }
}

dependencies {
    //minecraft("com.mojang", "minecraft", "1.20.1")

    //mappings("net.fabricmc", "yarn", "1.20.1+build.9")

    //modImplementation("net.fabricmc", "fabric-loader", "0.14.21")
    //modImplementation("net.fabricmc.fabric-api", "fabric-api", "0.85.0+1.20.1")
}