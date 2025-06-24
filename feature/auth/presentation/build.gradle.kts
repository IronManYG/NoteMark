plugins {
    alias(libs.plugins.notemark.android.feature.ui)
}

android {
    namespace = "dev.gaddal.feature.auth.presentation"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.feature.auth.domain)
}