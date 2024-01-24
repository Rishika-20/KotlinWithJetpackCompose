package com.nashtech.kotlinwithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nashtech.kotlinwithcompose.ui.theme.KotlinWithComposeTheme
import com.nashtech.kotlinwithcompose.ui.theme.NashTechcolor40
import com.nashtech.kotlinwithcompose.ui.theme.Purple40

/**
 * MainActivity serves as the main entry point for the Kotlin with Compose app.
 * It extends [ComponentActivity] and sets up the Compose content.
 *
 * @constructor Creates a new instance of [MainActivity].
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Set up the Compose theme for the entire activity
            KotlinWithComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    // To use normal background.
                    color = Purple40
                ) {
                    // Display a greeting message inside the Surface
                    Greeting("Nashers")
                }
            }
        }
    }
}

/**
 * Greeting is a Composable function that displays a welcome message.
 *
 * @param name The name to include in the greeting message.
 * @param modifier Optional [Modifier] to customize the layout.
 */
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hi $name,\n Welcome to Learning Jetpack Compose with Kotlin !",
        modifier = modifier.fillMaxWidth()
            .padding(30.dp)
            .background(NashTechcolor40),
        style = MaterialTheme.typography.headlineMedium
    )
}

/**
 * GreetingPreview is a Composable function used for previewing the Greeting Composable.
 */
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinWithComposeTheme {
        Greeting("Nashers")
    }
}