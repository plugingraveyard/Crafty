plugins {
    `java-library`

    id("io.papermc.paperweight.userdev") version "1.5.4"

    id("com.github.johnrengelman.shadow") version "8.1.1"

    id("xyz.jpenilla.run-paper") version "2.0.1"
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")

    maven("https://repo.aikar.co/content/groups/aikar/")

    maven("https://repo.triumphteam.dev/snapshots/")

    maven("https://repo.crazycrew.us/api/")

    maven("https://jitpack.io/")

    mavenCentral()
}

dependencies {
    compileOnly("co.aikar:acf-paper:0.5.1-SNAPSHOT")

    //compileOnly("dev.triumphteam:triumph-cmd-bukkit:2.0.0-ALPHA-7")

    implementation("us.crazycrew.crazycore:crazycore-paper:1.0.0.3")

    compileOnly("dev.triumphteam:triumph-gui:3.1.2")

    compileOnly("ch.jalu:configme:1.3.0")

    paperweight.paperDevBundle("1.19.4-R0.1-SNAPSHOT")
}

tasks {
    assemble {
        dependsOn(reobfJar)
    }

    reobfJar {
        val file = File("$rootDir/jars")

        if (!file.exists()) file.mkdirs()

        outputJar.set(layout.buildDirectory.file("$file/${rootProject.name}-${rootProject.version}.jar"))
    }

    compileJava {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(17)
    }

    javadoc {
        options.encoding = Charsets.UTF_8.name()
    }

    processResources {
        filteringCharset = Charsets.UTF_8.name()

        filesMatching("paper-plugin.yml") {
            expand(
                "name" to rootProject.name,
                "group" to rootProject.group,
                "version" to rootProject.version,
                "description" to rootProject.description
            )
        }
    }

    runServer {
        minecraftVersion("1.19.4")
    }
}