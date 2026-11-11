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

    // OAuth client ID is public configuration, NOT a password or client secret.
    // Without a project-specific client ID the optional Google control remains hidden.
    val configuredGoogleId = providers.gradleProperty("sopa.googleWebClientId")
        .orElse(providers.environmentVariable("SOPA_GOOGLE_WEB_CLIENT_ID"))
        .orElse("")
        .get()
    val webClientId = configuredGoogleId.takeIf {
        it.matches(Regex("[A-Za-z0-9-]+\\.apps\\.googleusercontent\\.com"))
    } ?: ""

    defaultConfig {
        applicationId = "app.sopadeletras.cristiana"
        buildConfigField("String", "GOOGLE_WEB_CLIENT_ID", "\"$webClientId\"")
        minSdk = 26
        targetSdk = 36
        versionCode = 25
        versionName = "1.0.6"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    // Release signing: credentials come from env vars (CI) or Gradle properties
    // (~/.gradle/gradle.properties). Without them, release falls back to the debug key.
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
            signingConfig = signingConfigs.getByName(if (hasReleaseSigning) "release" else "debug")
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
        buildConfig = true
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
    implementation(libs.androidx.credentials)
    implementation(libs.androidx.credentials.play)
    implementation(libs.google.identity.googleid)
    implementation(libs.google.play.services.auth)
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
