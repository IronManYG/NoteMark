# NoteMark

<p align="center">
  <img src="[path_to_app_icon]" alt="NoteMark Icon" width="180"/>
</p>

<p align="center">
  Your own collection of notes – capture your thoughts and ideas.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Min%20SDK-24-blue.svg" alt="Min SDK"/>
  <img src="https://img.shields.io/badge/Target%20SDK-35-brightgreen.svg" alt="Target SDK"/>
  <img src="https://img.shields.io/badge/Kotlin-2.0.20-purple.svg" alt="Kotlin Version"/>
  <img src="https://img.shields.io/badge/Jetpack%20ComposeBom-2025.02.00-orange.svg" alt="Jetpack Compose Version"/>
  <img src="https://img.shields.io/badge/License-MIT-green.svg" alt="License"/>
</p>

## Overview

**NoteMark** is notes application designed around rapid capture, effortless organisation, and privacy‑first cloud sync.

## Milestone 1 Features

| Feature                 | Highlights                                                                                                                |
| ----------------------- | ------------------------------------------------------------------------------------------------------------------------- |
| **Splash Screen**       | Minimal, full‑bleed blue background. Shows app logo while we warm up DI & session checks.                       |
| **Landing Screen**      | Responsive split‑layout (graphic + CTA container). Portrait ↔ landscape ↔ tablet rules follow the [requirements](#) spec. |
| **Login Screen**        | Email & password form with full validation, error‑state visuals, live button enable/disable and API integration.          |
| **Registration Screen** | Additional username + repeat‑password fields, contextual helper text, and rich error handling.                            |
| **Session Management**  | Secure token storage, automatic refresh, and a guard that clears the back stack on successful auth.                       |
| **Adaptive Layout**     | Every screen scales beautifully across phones and tablets, portrait & landscape.                                          |

## Screenshots

<p align="center">
  <img src="[screenshots/splash.png]" width="200" alt="Splash"/>
  <img src="[screenshots/landing_portrait.png]" width="200" alt="Landing – Portrait"/>
  <img src="[screenshots/login.png]" width="200" alt="Login"/>
  <img src="[screenshots/register_error.png]" width="200" alt="Register with validation"/>
</p>

## Tech Stack & Libraries

-   **Minimum SDK**: 25
-   **Kotlin + Coroutines + Flow**: Modern concurrency & reactive streams
-   **Jetpack Compose**: Declarative UI toolkit
-   **Navigation Compose**: Simple screen transitions
-   **Material Design 3**: Consistent theming & components
-   **Dependency Injection**: Koin for managing dependencies

> *Milestone 1 ships as a **single‑module MVP**; future milestones will split into `core`, `data`, `domain`, and feature modules.*

## Architecture

While this is a single-module project, the folder structure is inspired by a clean, modular approach:

```
notemark/
├── app/
├── core/
│   ├── data/            // Shared data logic or repositories
│   ├── domain/          // Core business models, common interfaces
│   └── presentation/    // Base Compose components, theming, UI utilities
├── features/
│   ├── auth/
│   │   ├── data/
│   │   ├── domain/
│   │   └── presentation/
└── utils/
```
This layout keeps each feature self-contained (`data`, `domain`, `presentation`) and ready for easier extraction into separate Gradle modules in the future.

### Why This Setup?

-   **Feature Isolation**: Each feature with clear boundaries for logic and UI.
-   **Clear Layer Separation**: Even in a single module, you’re guided by data/domain/presentation layers.
-   **Scalability**: You can promote each feature to its own module if complexity grows.

## Getting Started

1.  **Clone the Repository**
    ```bash
    git clone [https://github.com/IronManYG/NoteMark.git](https://github.com/IronManYG/NoteMark.git)
    ```
2.  **Open in Android Studio**
3.  **Sync Gradle and build the project**
4.  **Run on an emulator or a physical device**

## Acknowledgment

This project was built as part of the **[Pl Mobile Dev Campus](https://pl-coding.com/campus/)** community challenge.

**Thank you for checking out EchoJournal!**

If you have any questions or suggestions, feel free to open an issue or reach out to the maintainer. Happy coding!
