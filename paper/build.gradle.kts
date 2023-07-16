plugins {
    id("io.papermc.paperweight.userdev") version "1.5.5"

    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "${rootProject.group}.paper"
version = rootProject.version

dependencies {
    paperweight.paperDevBundle("1.20.1-R0.1-SNAPSHOT")
}

base {
    archivesName.set("${rootProject.name}-${project.name}")
}

tasks {
    assemble {
        dependsOn(reobfJar)
    }

    reobfJar {
        outputJar.set(file("$buildDir/libs/${rootProject.name}-${project.name}-${project.version}.jar"))
    }

    shadowJar {
        fun reloc(pkg: String) = relocate(pkg, "${project.group}.dep.$pkg")
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