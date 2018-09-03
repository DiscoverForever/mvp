package com.missfresh.moon.kttest.base

import android.annotation.SuppressLint
import android.app.Application

/**
 * 各个模块通用的基础的 App 类。
 * 这个是基类，放基础功能。
 */
@SuppressLint("Registered")
open class BaseApplication : Application() {
    companion object {
        lateinit var INSTANCE: BaseApplication
    }
    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}