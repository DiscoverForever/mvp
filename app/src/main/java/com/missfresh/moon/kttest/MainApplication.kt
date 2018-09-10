package com.missfresh.moon.kttest

import android.content.IntentFilter
import com.missfresh.moon.kttest.base.BaseApplication
import com.missfresh.moon.kttest.broadcastreceiver.NetworkChangeReceiver
import android.support.v4.view.accessibility.AccessibilityEventCompat.setAction
import android.content.Intent
import com.missfresh.moon.kttest.service.NetworkStateService


class MainApplication : BaseApplication() {
    private lateinit var intentFilter: IntentFilter
    private lateinit var networkChangeReceiver: NetworkChangeReceiver
    override fun onCreate() {
        super.onCreate()
//        intentFilter = IntentFilter()
//        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE")
//        networkChangeReceiver = NetworkChangeReceiver()
//        registerReceiver(networkChangeReceiver, intentFilter)
        val intent = Intent(this, NetworkStateService::class.java)
        intent.action = "com.missfresh.moon.kttest.service.NetworkStateService"
        startService(intent)


    }
}