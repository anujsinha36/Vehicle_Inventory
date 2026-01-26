package com.example.vehicleinventory.presentation.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable


private val LightColorScheme = lightColorScheme(
    primary = PrimaryButtonColor,
    background = Background,
    surface = SurfaceColor,
    outline = BorderColor,
    outlineVariant = ButtonBorder,
    onSurface = TextPrimary,
    onSurfaceVariant = TextSecondary


    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun VehicleInventoryTheme(
   // darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
   // dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {


    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}