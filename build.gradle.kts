plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.kapt) apply false
    alias(libs.plugins.git.version)
}

// Gradle 9.0.0 - Global configurations for all subprojects
allprojects {
    // Enable reproducible builds
    tasks.withType<AbstractArchiveTask>().configureEach {
        isPreserveFileTimestamps = false
        isReproducibleFileOrder = true
    }
}

tasks.register<Delete>("clean") {
    delete(layout.buildDirectory)
} 