pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "NoteMark"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":build-logic:convention")
include(":core:data")
include(":core:database")
include(":core:domain")
include(":core:presentation:ui")
include(":core:presentation:designsystem")
include(":feature:auth:data")
include(":feature:auth:domain")
include(":feature:auth:presentation")
include(":feature:notes:data")
include(":feature:notes:domain")
include(":feature:notes:presentation")
include(":feature:notes:network")
