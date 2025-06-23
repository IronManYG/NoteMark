plugins {
    alias(libs.plugins.notemark.android.library)
}

android {
    namespace = "dev.gaddal.feature.notes.network"
}

dependencies {
    implementation(libs.bundles.koin)

    implementation(projects.core.domain)
    implementation(projects.core.data)
}