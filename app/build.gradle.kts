// app/build.gradle.kts — Aura AI Android wrapper (WebView host + JS bridges)
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.aura.ai"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.aura.ai"
        minSdk = 24                    // Android 7.0 — WebView کامل + Web Speech + File System Access
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"

        // آیکون وب‌اپ در اسپلش اندروید ۱۲ بهتر نمایش داده شود
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"
        }
        release {
            // برای انتشار واقعی signingConfig اضافه کنید (مراحل در README توضیح داده شده)
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
        viewBinding = true
    }

    // تمام محتوای وب‌اپ در assets/www قرار دارد؛ در زمان build بدون تغییر کپی می‌شود
    sourceSets["main"].assets.srcDirs("src/main/assets")
}

dependencies {
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.activity:activity-ktx:1.9.2")
    implementation("androidx.webkit:webkit:1.12.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")

    // Kotlin coroutines برای اجرای غیرهمزمان درخواست‌ها در Bridge
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")
}
