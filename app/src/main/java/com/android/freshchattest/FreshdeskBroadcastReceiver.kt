package com.android.freshchattest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.freshchat.consumer.sdk.Freshchat

class FreshdeskBroadcastReceiver : BroadcastReceiver() {

  override fun onReceive(context: Context, intent: Intent) {
    // NEVER GETS CALLED AFTER CLICKING ON NOTIFICATION - NO MATTER IF I REGISTER THE RECEIVER IN THE MANIFEST, ACTIVITY OR APPLICATION
    Log.e("TRACKING","ON RECEIVE CALLED LINK: extras ${intent.extras}")
    val link = intent.extras?.getString(DEEPLINK_URL_KEY).orEmpty()
    if (link.isEmpty()) {
      // Log exception
    } else {
      Freshchat.openFreshchatDeeplink(context.applicationContext, link)
    }
  }

}

private const val DEEPLINK_URL_KEY = "FRESHCHAT_DEEPLINK"