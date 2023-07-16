plugins {
    id("root-plugin")

    //id("fabric-loom") version "1.3-SNAPSHOT"
}

tasks {
    shadowJar {
        val file = File("$rootDir/jars/prebuilt")

        doFirst {
            if (!file.exists()) file.mkdirs()
        }

        archiveFileName.set("$file/${rootProject.name.lowercase()}-fabric.jar")

        archiveClassifier.set("")
    }
}

dependencies {
    //minecraft("com.mojang", "minecraft", "1.20.1")

    //mappings("net.fabricmc", "yarn", "1.20.1+build.9")

    //modImplementation("net.fabricmc", "fabric-loader", "0.14.21")
    //modImplementation("net.fabricmc.fabric-api", "fabric-api", "0.85.0+1.20.1")
}