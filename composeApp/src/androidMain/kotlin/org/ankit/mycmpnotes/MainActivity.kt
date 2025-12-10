package org.ankit.mycmpnotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import org.ankit.mycmpnotes.ui.HomeScreen
import org.ankit.mycmpnotes.ui.theme.Background

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                scrim = Background.toArgb() // your dark status bar color
            ),
            navigationBarStyle = SystemBarStyle.dark(
                scrim = Background.toArgb() // your dark nav bar color
            )
        )
        super.onCreate(savedInstanceState)
 
        setContent {
//            App()
            HomeScreen()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
   // App()
    HomeScreen()
}