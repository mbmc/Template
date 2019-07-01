object Releases {
    const val version_code = 1
    const val version_name = "1.0"
}

object Versions {
    // APK
    const val compile_sdk = 28
    const val min_sdk = 23
    const val target_sdk = 28

    const val gradle = "3.4.1"
    const val kotlin = "1.3.40"

    // Android
    const val app_compat = "1.0.2"
    const val constraint_layout = "1.1.3"
    const val lifecycle = "2.0.0"
    const val material = "1.0.0"
    const val recyclerview = "1.0.0"

    // Test
    const val mockito = "2.28.2"
    const val runner = "1.1.1"
    const val rules = "1.1.1"
    const val espresso_core = "3.1.1"
    const val junit = "4.12"
    const val core_testing = "2.0.0"

    // 3rd party
    const val dagger = "2.16" // issues with 2.17+
    const val javax = "1@jar"
    const val retrofit = "2.6.0"
    const val rxjava = "2.2.10"
    const val rxkotlin = "2.3.0"
    const val rxandroid = "2.1.1"
    const val moshi = "1.8.0"
    const val okio = "2.2.2"
}

object Libraries {
    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"

    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val dagger_compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val dagger_android = "com.google.dagger:dagger-android:${Versions.dagger}"
    const val dagger_android_processor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    const val javax = "javax.inject:javax.inject:${Versions.javax}"
    const val retrofit_rxjava = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val retrofit_moshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val rxjava = "io.reactivex.rxjava2:rxjava:${Versions.rxjava}"
    const val rxkotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxkotlin}"
    const val rxandroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid}"
    const val moshi_kotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val okio = "com.squareup.okio:okio:${Versions.okio}"
}

object AndroidLibraries {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.app_compat}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}" // No -ktx
    const val material = "com.google.android.material:material:${Versions.material}"
    const val databinding = "com.android.databinding:compiler:${Versions.gradle}" // Same version as gradle
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"

    const val core_testing = "androidx.arch.core:core-testing:${Versions.core_testing}"
    const val junit = "androidx.test.ext:junit:1.1.0"
    const val runner = "androidx.test:runner:${Versions.runner}"
    const val rules = "androidx.test:rules:${Versions.rules}"
    const val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espresso_core}"
}

object TestLibraries {
    const val junit = "junit:junit:${Versions.junit}"
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    const val kotlin_reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
}