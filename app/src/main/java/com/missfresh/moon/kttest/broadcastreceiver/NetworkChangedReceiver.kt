package com.missfresh.moon.kttest.broadcastreceiver

import android.widget.Toast
import android.content.Intent
import android.content.BroadcastReceiver
import android.content.Context
import android.util.Log


internal class NetworkChangeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Log.d("networkstatus", "网络状态改变")
        Toast.makeText(context, "网络状态改变", Toast.LENGTH_SHORT).show()
    }
}



