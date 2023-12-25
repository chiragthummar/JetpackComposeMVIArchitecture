@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    alias(libs.plugins.parcelize)
}

android {
    namespace = "com.md.jetpackcomposemviarchitecture"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.md.jetpackcomposemviarchitecture"
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
            isMinifyEnabled = true
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
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(libs.androidx.appcompat)

    /* *****************************************************
     **** Lifecycle
     ****************************************************** */
    implementation(libs.lifecycle.extensions)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.lifecycle.runtime.compose)
    implementation(libs.lifecycle.process)
    implementation(libs.lifecycle.common.java8)
    implementation(libs.runtime.livedata)
    implementation(libs.activity.ktx)


    /* *****************************************************
      **** Coroutines
      ****************************************************** */
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    /* *****************************************************
      **** Splash
      ****************************************************** */
    implementation(libs.core.splashscreen)

    /* *****************************************************
     **** Lottie Animation
     ****************************************************** */
    implementation(libs.lottie.compose)


    /* *****************************************************
     **** Coil Image Loading
     ****************************************************** */
    implementation(libs.coil.compose)
    implementation(libs.coil.video)

    /* *****************************************************
     **** Download File
    ****************************************************** */
    implementation(libs.work.runtime.ktx)

    /* *****************************************************
    **** Dependency-Hilt Injection
    ****************************************************** */
    implementation(libs.navigation.compose)
    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation.compose)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.work)

    /* *****************************************************
      **** Retrofit2
      ****************************************************** */
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)
    implementation(libs.converter.moshi)
}