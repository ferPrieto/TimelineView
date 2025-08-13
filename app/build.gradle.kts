plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.compose)
}

android {
    compileSdk = libs.versions.compileSdk.get().toInt()
    
    defaultConfig {
        applicationId = "ferprieto.timelineview"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    
    // Configure JVM Toolchain for Kotlin 2.0 compatibility (Gradle 9 recommendation)
    kotlin {
        jvmToolchain(17)
    }
    
    buildFeatures {
        compose = true
    }
    
    lint {
        quiet = true
        xmlReport = true
        htmlReport = true
        abortOnError = true
        warningsAsErrors = false
    }
    
    namespace = "ferprieto.timelineview"
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(libs.kotlin.stdlib)
    
    // AndroidX Core Dependencies
    implementation(libs.bundles.androidx.core)

    // Compose BOM for version alignment
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)
    
    // lib from Maven
    implementation(libs.timelineview)
    
    // Compose Debug Tools
    debugImplementation(libs.bundles.compose.debug)

    // Unit Testing
    testImplementation(libs.bundles.testing.unit)
    
    // UI Testing  
    androidTestImplementation(libs.bundles.testing.ui)
    
    // Compose Testing
    androidTestImplementation(libs.bundles.testing.compose)
}

// Force resolution of compatible AndroidX versions
configurations.configureEach {
    resolutionStrategy {
        force("androidx.core:core:${libs.versions.androidxCore.get()}")
        force("androidx.core:core-ktx:${libs.versions.androidxCore.get()}")
        force("androidx.appcompat:appcompat:${libs.versions.androidxAppcompat.get()}")
        force("androidx.constraintlayout:constraintlayout:${libs.versions.androidxConstraintlayout.get()}")
        force("androidx.activity:activity-compose:${libs.versions.activityCompose.get()}")
        force("androidx.lifecycle:lifecycle-viewmodel-compose:${libs.versions.lifecycleViewmodelCompose.get()}")
    }
} 
