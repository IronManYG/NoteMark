package dev.gaddal.notemark

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dev.gaddal.core.presentation.designsystem.NoteMarkTheme
import dev.gaddal.feature.auth.presentation.landing.LandingRoot

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            NoteMarkTheme {
                LandingRoot() // only for test, later nav will implement
            }
        }
    }
}