plugins {
    alias(libs.plugins.notemark.android.library)
    alias(libs.plugins.notemark.jvm.ktor)
}

android {
    namespace = "dev.gaddal.feature.auth.data"
}

dependencies {
    implementation(libs.bundles.koin)

    implementation(projects.feature.auth.domain)
    implementation(projects.core.domain)
    implementation(projects.core.data)
}