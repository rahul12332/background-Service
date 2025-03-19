package com.example.truecaller_clone

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager

class CallReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val state = intent.getStringExtra(TelephonyManager.EXTRA_STATE)

        if (state == TelephonyManager.EXTRA_STATE_IDLE) {  // Call ended
            val phoneNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER)

            val overlayIntent = Intent(context, OverlayService::class.java).apply {
                putExtra("caller_number", phoneNumber)
            }
            context.startService(overlayIntent)
        }
    }
}
