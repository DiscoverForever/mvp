package com.mvp.moon.kttest.service

import android.app.AlarmManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.os.SystemClock
import android.app.PendingIntent
import com.mvp.moon.kttest.broadcastreceiver.AlarmReceiver


class TimingTaskService(): Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        var alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        var triggerAtTime = SystemClock.elapsedRealtime() + 10 * 1000
        val i = Intent(this, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 0, i, 0)
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pendingIntent)
        return super.onStartCommand(intent, flags, startId)

    }
}