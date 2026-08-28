plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "br.edu.ifgoiano.quizapp"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    //ativa o View Binding no projeto Android
    buildFeatures {
        viewBinding = true
    }

    defaultConfig {
        applicationId = "br.edu.ifgoiano.quizapp"
        minSdk = 36
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

//dependencias essenciais para que o projeto rode
dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}