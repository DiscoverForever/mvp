package com.mvp.moon.kttest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import org.jetbrains.anko.*
import android.content.Context
import android.graphics.Color
import android.os.Message
import android.view.Gravity
import android.widget.TextView
import com.mvp.moon.kttest.event.LoginEvent
import com.mvp.moon.kttest.event.MessageEvent
import com.mvp.moon.kttest.unit.db.DbActivity
import com.mvp.moon.kttest.unit.login.LoginActivity
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class MainActivity() : AppCompatActivity() {
    private lateinit var tv: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EventBus.getDefault().register(this)
        EventBus.getDefault().post(LoginEvent("tyy"))
        relativeLayout() {
            gravity = Gravity.CENTER
            tv = textView("Welcome to Kotlin") {
                textSize = 30.toFloat()
                textColor = Color.BLUE
            }
        }
//        this.getSystemService(Context.CONNECTIVITY_SERVICE)
//        toast(NetWorkUtils.isNetworkConnected(this).toString())
//        Handler().postDelayed({
//           startActivity<LoginActivity>()
            startActivity<DbActivity>()
//        }, 3000)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    open fun onMessageEvent(message: MessageEvent) {
        tv.text = message.message
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }
}

