plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "app.sopadeletras"
    compileSdk {
        version = release(37) {
            minorApiLevel = 2
        }
    }

    defaultConfig {
        applicationId = "app.sopadeletras.cristiana"
        minSdk = 26
        targetSdk = 36
        versionCode = 31
        versionName = "1.0.12"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    // Release credentials belong only to owner-controlled local Gradle properties.
    // Never fall back to the debug certificate for a production build.
    val releaseStoreFile = providers.environmentVariable("SIGNING_KEYSTORE_FILE")
        .orElse(providers.gradleProperty("sopa.keystoreFile")).orNull
    val releaseStorePassword = providers.environmentVariable("SIGNING_PASSWORD")
        .orElse(providers.gradleProperty("sopa.keystorePassword")).orNull
    val releaseKeyAlias = providers.environmentVariable("SIGNING_KEY_ALIAS")
        .orElse(providers.gradleProperty("sopa.keyAlias")).orNull
    val hasReleaseSigning = releaseStoreFile != null && releaseStorePassword != null && releaseKeyAlias != null

    signingConfigs {
        if (hasReleaseSigning) {
            create("release") {
                storeFile = file(releaseStoreFile!!)
                storePassword = releaseStorePassword
                keyAlias = releaseKeyAlias
                keyPassword = releaseStorePassword
            }
        }
    }

    buildTypes {
        debug {
            // Test-only identity; no release credentials or distribution change.
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-candidate-dev"
        }
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
            signingConfig = if (hasReleaseSigning) signingConfigs.getByName("release") else null
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    // F-Droid rejects the Google-signed dependency metadata block
    dependenciesInfo {
        includeInApk = false
        includeInBundle = false
    }
    buildFeatures {
        compose = true
    }
    // Keep native libraries unstripped so the APK is identical whether or not the
    // build machine has the NDK (needed for F-Droid reproducible builds).
    packaging {
        jniLibs {
            keepDebugSymbols += "**/*.so"
        }
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material.icons)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3.windowsizeclass)
    implementation(libs.androidx.core.splashscreen)
    testImplementation(libs.junit)
}

tasks.register<Exec>("validateWords") {
    group = "verification"
    description = "Validates assets/words banks. Fails the build."
    if (System.getProperty("os.name").startsWith("Windows", ignoreCase = true)) {
        commandLine("py", "-3", rootProject.file("tools/validate_words.py").absolutePath)
    } else {
        commandLine("python3", rootProject.file("tools/validate_words.py").absolutePath)
    }
}

afterEvaluate {
    tasks.withType<Test> { dependsOn("validateWords") }
}
