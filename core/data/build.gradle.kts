plugins {
    alias(libs.plugins.notemark.android.library)
    alias(libs.plugins.notemark.jvm.ktor)
}

android {
    namespace = "dev.gaddal.core.data"
}

dependencies {
    implementation(libs.timber)
    implementation(libs.bundles.koin)

    implementation(projects.core.domain)
    implementation(projects.core.database)
}