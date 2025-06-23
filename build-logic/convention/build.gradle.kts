plugins {
    `kotlin-dsl`
}

group = "dev.gaddal.notemark.buildlogic"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "notemark.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
    }
}