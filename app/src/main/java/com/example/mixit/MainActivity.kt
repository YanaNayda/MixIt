package com.example.mixit
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mixit.login.LogIn
import com.example.mixit.ui.theme.MixItTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WelcomeScreen()

        }

        }
    }


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    LogIn()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MixItTheme {
        Greeting("Android")
    }
}