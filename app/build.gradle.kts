plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.imani.childregistration"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.imani.childregistration"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //to help make http request api request
    implementation ("com.loopj.android:android-async-http:1.4.9")
    //gson for converting JSON Arrays into Array in kotlin
    implementation("com.google.code.gson:gson:2.8.7")
    //for swipe refresh in recycler view
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    //for making  circular images
    implementation("de.hdodenhof:circleimageview:3.0.1")
    //app_compact dependandacy for the themes
    implementation("androidx.appcompat:appcompat:1.6.1")
}