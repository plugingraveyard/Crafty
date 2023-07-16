plugins {
    id("paper-plugin")
}

tasks {
    reobfJar {
        val file = File("$rootDir/jars/prebuilt")

        if (!file.exists()) file.mkdirs()

        outputJar.set(layout.buildDirectory.file("$file/${rootProject.name.lowercase()}-paper.jar"))
    }

    shadowJar {
        fun reloc(pkg: String) = relocate(pkg, "${rootProject.group}.dep.$pkg")
    }

    processResources {
        filesMatching("paper-plugin.yml") {
            expand(
                "name" to rootProject.name,
                "group" to rootProject.group,
                "version" to rootProject.version,
                "description" to rootProject.description,
            )
        }
    }
}