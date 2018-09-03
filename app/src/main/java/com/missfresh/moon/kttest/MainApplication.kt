package com.missfresh.moon.kttest

import android.content.IntentFilter
import com.missfresh.moon.kttest.base.BaseApplication
import com.missfresh.moon.kttest.broadcastreceiver.NetworkChangeReceiver

class MainApplication: BaseApplication() {
    private lateinit var intentFilter: IntentFilter
    private lateinit var networkChangeReceiver: NetworkChangeReceiver
    override fun onCreate() {
        super.onCreate()
        intentFilter = IntentFilter()
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE")
        networkChangeReceiver = NetworkChangeReceiver()
        registerReceiver(networkChangeReceiver, intentFilter)

    }
}