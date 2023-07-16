plugins {
    id("paper-plugin")
}

group = "${rootProject.group}.paper"

dependencies {

}

tasks {
    reobfJar {
        outputJar.set(file("$buildDir/libs/${rootProject.name}-${project.name}-${project.version}.jar"))
    }

    shadowJar {
        fun reloc(pkg: String) = relocate(pkg, "${rootProject.group}.dep.$pkg")
    }

    processResources {
        filesMatching("paper-plugin.yml") {
            expand(
                "name" to rootProject.name,
                "group" to project.group,
                "version" to project.version,
                "description" to rootProject.description
            )
        }
    }
}