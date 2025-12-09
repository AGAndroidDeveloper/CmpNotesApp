package org.ankit.mycmpnotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.ankit.mycmpnotes.ui.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
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