plugins {
    id("root-plugin")
}

defaultTasks("build")

rootProject.group = "com.ryderbelserion.crafty"
rootProject.description = "Lightweight plugin containing server essentials."
rootProject.version = "1.0"

tasks {
    assemble {
        val jarsDir = File("$rootDir/jars")
        if (jarsDir.exists()) jarsDir.delete()

        subprojects.forEach { project ->
            dependsOn(":${project.name}:build")

            doLast {
                if (!jarsDir.exists()) jarsDir.mkdirs()

                val file = file("${project.buildDir}/libs/${rootProject.name}-${rootProject.version}.jar")

                copy {
                    from(file)
                    into(jarsDir)
                }
            }
        }
    }
}