package com.mvp.moon.kttest.utils

import com.mvp.moon.kttest.constant.HttpConstant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HttpUtils {
    private var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(HttpConstant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    fun <T> getService(service: Class<T>): T {
        return retrofit.create(service)
    }
}