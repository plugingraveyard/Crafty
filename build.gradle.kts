plugins {
    `java-library`

    id("io.papermc.paperweight.userdev") version "1.5.4"

    id("com.github.johnrengelman.shadow") version "8.1.1"
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")

    maven("https://repo.triumphteam.dev/snapshots/")

    maven("https://repo.crazycrew.us/api/")

    maven("https://jitpack.io/")

    mavenCentral()
    //mavenLocal()
}

dependencies {
    implementation("cloud.commandframework", "cloud-core", "1.8.3")
    implementation("cloud.commandframework", "cloud-brigadier", "1.8.3")
    implementation("cloud.commandframework", "cloud-minecraft-extras", "1.8.3") {
        exclude("net.kyori")
    }

    //implementation("dev.triumphteam:triumph-cmd-bukkit:2.0.0-ALPHA-7")

    implementation("us.crazycrew.crazycore:crazycore-paper:1.0.0.3")

    implementation("dev.triumphteam:triumph-gui:3.1.2")

    implementation("ch.jalu:configme:1.3.0")

    paperweight.paperDevBundle("1.19.4-R0.1-SNAPSHOT")
}

tasks {
    shadowJar {
        listOf(
            "us.crazycrew.crazycore",
            "dev.triumphteam",
            "ch.jalu"
        ).forEach { pack -> relocate(pack, "${rootProject.group}.$pack") }
    }

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
}