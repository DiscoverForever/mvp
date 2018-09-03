package com.missfresh.moon.kttest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import org.jetbrains.anko.*
import android.content.Context
import android.graphics.Color
import android.view.Gravity
import com.missfresh.moon.kttest.unit.login.DbActivity


class MainActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        relativeLayout() {
            gravity = Gravity.CENTER
            textView("Welcome to Kotlin") {
                textSize = 30.toFloat()
                textColor = Color.BLUE
            }
        }
        this.getSystemService(Context.CONNECTIVITY_SERVICE)
//        toast(NetWorkUtils.isNetworkConnected(this).toString())
        Handler().postDelayed({
           startActivity<DbActivity>()
        }, 3000)
    }
}

