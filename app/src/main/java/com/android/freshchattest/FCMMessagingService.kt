package com.android.freshchattest

import android.util.Log
import com.freshchat.consumer.sdk.Freshchat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FCMMessagingService : FirebaseMessagingService() {

  override fun onMessageReceived(remoteMessage: RemoteMessage) {
    Log.e("TRACKING","FIREBASE NOTIFICATION RECEIVED")
    if (Freshchat.isFreshchatNotification(remoteMessage)) {
      Freshchat.handleFcmMessage(applicationContext, remoteMessage);
    } else {
      Log.e("TRACKING","NOT FIREBASE NOTIFICATION")
    }
  }

  override fun onNewToken(token: String) {
    super.onNewToken(token)
    Log.e("TRACKING","ON NEW TOKEN $token")
    Freshchat.getInstance(applicationContext).setPushRegistrationToken(token)
  }
}