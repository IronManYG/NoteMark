plugins {
    alias(libs.plugins.notemark.android.library)
}

android {
    namespace = "dev.gaddal.feature.notes.data"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.androidx.work)
    implementation(libs.koin.android.workmanager)
    implementation(libs.kotlinx.serialization.json)

    implementation(projects.core.domain)
    implementation(projects.core.database)
    implementation(projects.feature.notes.domain)
}