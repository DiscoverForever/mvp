package com.mvp.moon.kttest.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.mvp.moon.kttest.service.TimingTaskService

class AlarmReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, p1: Intent?) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Log.d("alarmReceiver", "=====alarmReceiver")
        val timingTaskService = Intent(context, TimingTaskService::class.java)
        context?.startService(timingTaskService)
    }
}