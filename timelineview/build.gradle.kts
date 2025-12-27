plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    `maven-publish`
}

android {
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlin {
        jvmToolchain(17)
    }

    buildFeatures {
        compose = true
    }

    namespace = "com.github.ferprieto.timelineview"
    
     publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(libs.kotlin.stdlib)

    // AndroidX Core Dependencies  
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core)

    // Compose BOM for version alignment
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.foundation)
    implementation(libs.compose.material3)
    implementation(libs.compose.activity)

    // Compose Debug Tools
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.test.manifest)

    // Testing Dependencies
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    
    // Android Instrumented Testing
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.7.0")
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    
    // Compose Testing
    androidTestImplementation("androidx.compose.ui:ui-test")
    androidTestImplementation("androidx.test:rules:1.5.0")
    androidTestImplementation("androidx.test:runner:1.5.2")
}

// Force resolution of compatible AndroidX versions
configurations.configureEach {
    resolutionStrategy {
        force("androidx.core:core:${libs.versions.androidxCore.get()}")
        force("androidx.core:core-ktx:${libs.versions.androidxCore.get()}")
        force("androidx.appcompat:appcompat:${libs.versions.androidxAppcompat.get()}")
        force("androidx.activity:activity-compose:${libs.versions.activityCompose.get()}")
    }
}

// Configuration Cache compatible version handling
val gitVersion: String by lazy {
    providers.exec {
        commandLine("git", "describe", "--tags", "--always", "--first-parent", "--abbrev=7", "--match=*", "HEAD")
    }.standardOutput.asText.get().trim().removePrefix("v").removeSuffix(".dirty")
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("maven") {
                from(components["release"])

                groupId = "ferPrieto"
                artifactId = "timelineview"
                version = gitVersion
                
                pom {
                    name.set("TimelineView")
                    description.set("A synchronized dual-view timeline visualization component for Android with native Compose support")
                    url.set("https://github.com/ferPrieto/TimelineView")

                    licenses {
                        license {
                            name.set("The Apache License, Version 2.0")
                            url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        }
                    }

                    developers {
                        developer {
                            id.set("ferprieto")
                            name.set("Fernando Prieto")
                            email.set("f.prieto.moyano@gmail.com")
                        }
                    }

                    scm {
                        connection.set("scm:git:github.com/ferPrieto/TimelineView.git")
                        developerConnection.set("scm:git:ssh://github.com/ferPrieto/TimelineView.git")
                        url.set("https://github.com/ferPrieto/TimelineView/tree/master")
                    }
                }
            }
        }

        repositories {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/ferPrieto/TimelineView")
                credentials {
                    username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME") ?: System.getenv("GITHUB_ACTOR")
                    password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN") ?: System.getenv("GITHUB_TOKEN")
                }
            }
        }
    }
}
