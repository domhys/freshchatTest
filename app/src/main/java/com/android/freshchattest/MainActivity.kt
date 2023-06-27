package com.android.freshchattest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.android.freshchattest.ui.theme.FreshchatTestTheme
import com.freshchat.consumer.sdk.Freshchat
import com.freshchat.consumer.sdk.FreshchatConfig
import com.freshchat.consumer.sdk.FreshchatNotificationConfig

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      FreshchatTestTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          Greeting("Android")
        }
      }
    }

    initializeFreshdesk()
  }

  private fun initializeFreshdesk() {
    val config = FreshchatConfig("MY APP ID", " MY APP KEY").apply {
      domain = "MY DOMAIN"
    }
    val notificationConfig = FreshchatNotificationConfig().setNotificationInterceptionEnabled(true)
    with (Freshchat.getInstance(this.applicationContext)) {
      init(config)
      setNotificationConfig(notificationConfig)
    }
  }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!",
    modifier = modifier
  )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  FreshchatTestTheme {
    Greeting("Android")
  }
}