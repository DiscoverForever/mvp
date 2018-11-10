package com.mvp.moon.kttest

import android.content.IntentFilter
import com.mvp.moon.kttest.base.BaseApplication
import com.mvp.moon.kttest.broadcastreceiver.NetworkChangeReceiver
import android.support.v4.view.accessibility.AccessibilityEventCompat.setAction
import android.content.Intent
import com.mvp.moon.kttest.service.NetworkStateService
import com.mvp.moon.kttest.service.TimingTaskService


class MainApplication : BaseApplication() {
    private lateinit var intentFilter: IntentFilter
    private lateinit var networkChangeReceiver: NetworkChangeReceiver
    override fun onCreate() {
        super.onCreate()
//        int
//
//
// entFilter = IntentFilter()
//        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE")
//        networkChangeReceiver = NetworkChangeReceiver()
//        registerReceiver(networkChangeReceiver, intentFilter)
        val intent = Intent(this, NetworkStateService::class.java)
        intent.action = "com.mvp.moon.kttest.service.NetworkStateService"
        startService(intent)

        val timingTaskService = Intent(this, TimingTaskService::class.java)
        startService(timingTaskService)

    }
}