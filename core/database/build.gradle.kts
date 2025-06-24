plugins {
    alias(libs.plugins.notemark.android.library)
    alias(libs.plugins.notemark.android.room)
}

android {
    namespace = "dev.gaddal.core.database"
}

dependencies {
    implementation(libs.bundles.koin)

    implementation(projects.core.domain)
}