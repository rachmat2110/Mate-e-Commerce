plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.hilt.gradle.plugin)
    id("kotlin-kapt")
}

android {
    namespace = "com.example.mateecommerce"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.mateecommerce"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        getByName("debug"){
            buildConfigField("String", "BASE_URL", "\"https://assets.bagicode.com/bcompose/\"")
        }

        getByName("release"){
            buildConfigField("String", "BASE_URL", "\"https://assets.bagicode.com/bcompose/\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    //Module
    implementation(project(path = ":feature:auth"))
    implementation(project(path = ":feature:home"))
    implementation(project(path = ":core:navigator"))
    implementation(project(path = ":domain"))
    implementation(project(path = ":data:remote"))
    implementation(project(path = ":data:local"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    //Dagger Hilt
    implementation(libs.com.dagger)
    kapt(libs.hilt.android.compiler)
    kapt(libs.androidx.hilt.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //Retrofit
    implementation(libs.squareup.retrofit)
    implementation(libs.google.code)
    implementation(libs.squareup.retrofit2)
    implementation(libs.squareup.okhttp)
    implementation(libs.squareup.logging.interceptor)

    //Chucker
    implementation(libs.com.github.chucker.lib)
    releaseImplementation(libs.com.github.chucker.lib.no.op)
}

kapt{
    correctErrorTypes = true
}