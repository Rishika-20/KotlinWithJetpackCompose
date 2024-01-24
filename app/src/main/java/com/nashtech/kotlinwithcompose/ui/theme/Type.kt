package com.nashtech.kotlinwithcompose.ui.theme

/**
 * Typography.kt
 *
 * This file defines a set of Material typography styles for text in the Kotlin with Compose app.
 * It includes default styles such as bodyLarge, which can be customized or overridden as needed.
 *
 * @see androidx.compose.material3.Typography
 * @see androidx.compose.ui.text.TextStyle
 * @see androidx.compose.ui.text.font.FontFamily
 * @see androidx.compose.ui.text.font.FontWeight
 * @see androidx.compose.ui.unit.sp
 */


import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * Typography is a set of predefined text styles to be used in the app's UI.
 *
 * @param bodyLarge The default text style for large body text.
 *                  It is defined with a 16sp font size, normal font weight,
 *                  a line height of 24sp, and a letter spacing of 0.5sp.
 *                  Set of Material typography styles to start with.
 */

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)