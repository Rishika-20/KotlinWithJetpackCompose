/**
* This file defines the overall theme for the Kotlin with Compose app, including color schemes,
* typography, and dynamic color adjustments based on the system's appearance.
*
* @see androidx.compose.foundation.isSystemInDarkTheme
* @see androidx.compose.material3.MaterialTheme
* @see androidx.compose.material3.darkColorScheme
* @see androidx.compose.material3.dynamicDarkColorScheme
* @see androidx.compose.material3.dynamicLightColorScheme
* @see androidx.compose.material3.lightColorScheme
* @see androidx.compose.runtime.Composable
* @see androidx.compose.runtime.SideEffect
* @see androidx.compose.ui.graphics.toArgb
* @see androidx.compose.ui.platform.LocalContext
* @see androidx.compose.ui.platform.LocalView
* @see androidx.core.view.WindowCompat
*/

package com.nashtech.kotlinwithcompose.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.compose.ui.graphics.Color

/**
 * Custom dark color scheme used in the app, defined with specific color values.
 */

private val CustomDarkColorScheme = darkColorScheme(
    primary = Color(0xB2E20F0F),
    secondary = Color(0xFFE6E2E2),
    tertiary = Color(0xA12CA4CA)
)

/**
 * Custom light color scheme used in the app, defined with specific color values.
 */

private val CustomLightColorScheme = lightColorScheme(
    primary = Color(0xFFF5A6A6),
    secondary = Color(0xFFE971E6),
    tertiary = Color(0xBFC55252)
)

/**
 * KotlinWithComposeTheme is a Composable function that sets up the overall theme for the app.
 *
 * @param darkTheme Whether to use the dark theme. Defaults to the system's appearance.
 * @param dynamicColor Whether to use dynamic color adjustments (Android 12+ feature).
 * @param content The Composable content to be displayed within the theme.
 */

@Composable
fun KotlinWithComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> CustomDarkColorScheme
        else -> CustomLightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

