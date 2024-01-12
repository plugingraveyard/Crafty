plugins {
    id("paper-plugin")
}

dependencies {
    api(project(":common"))

    implementation(libs.bstats)

    implementation(libs.cluster.paper)

    implementation(libs.cloud.paper)

    compileOnly(libs.headdatabase)

    compileOnly(libs.vault)
}

tasks {
    shadowJar {
        listOf(
            "com.ryderbelserion.cluster.paper",
            "org.bstats"
        ).forEach {
            relocate(it, "libs.$it")
        }
    }

    processResources {
        val properties = hashMapOf(
            "name" to rootProject.name,
            "version" to project.version,
            "group" to rootProject.group,
            "description" to rootProject.description,
            "apiVersion" to rootProject.properties["apiVersion"],
            "authors" to rootProject.properties["authors"],
            "website" to rootProject.properties["website"]
        )

        filesMatching("paper-plugin.yml") {
            expand(properties)
        }
    }
}