plugins {
    `maven-publish`
}

base {
    archivesName.set("${rootProject.name}-${project.name}")
}

dependencies {
    compileOnlyApi(libs.bundles.adventure)
}

val component: SoftwareComponent = components["java"]

tasks {
    publishing {
        publications {
            create<MavenPublication>("maven") {
                artifactId = "api"

                from(component)

                pom {
                    name.set("Crafty API")
                    description.set("Lightweight plugin/mod containing essentials.")
                    url.set("https://github.com/ryderbelserion/Crafty")

                    licenses {
                        license {
                            name.set("MIT")
                            url.set("https://github.com/ryderbelserion/Crafty/blob/main/LICENSE")
                        }
                    }

                    developers {
                        developer {
                            id.set("ryderbelserion")
                            name.set("Ryder Belserion")
                            url.set("https://github.com/ryderbelserion")
                            email.set("no-reply@ryderbelserion.com")
                        }
                    }

                    scm {
                        connection.set("scm:git:https://github.com/ryderbelserion/Crafty.git")
                        developerConnection.set("scm:git:git@github.com:ryderbelserion/Crafty.git")
                        url.set("https://github.com/ryderbelserion/Crafty")
                    }

                    issueManagement {
                        system.set("GitHub")
                        url.set("https://github.com/ryderbelserion/Crafty/issues")
                    }
                }
            }
        }
    }
}