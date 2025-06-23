plugins {
    alias(libs.plugins.notemark.android.feature.ui)
}

android {
    namespace = "dev.gaddal.feature.notes.presentation"
}

dependencies {
    implementation(libs.androidx.activity.compose)
    implementation(libs.timber)

    implementation(projects.core.domain)
    implementation(projects.feature.notes.domain)
}