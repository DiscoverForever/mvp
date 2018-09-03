package com.missfresh.moon.kttest.unit.login

import android.os.Bundle
import android.text.InputType
import android.view.Gravity
import android.widget.EditText
import android.widget.LinearLayout
import com.missfresh.moon.kttest.R
import com.missfresh.moon.kttest.base.BaseActivity
import com.missfresh.moon.kttest.constant.Color
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class DbActivity() : BaseActivity(), DbContract.View {
    override var presenter: DbPresenter = DbPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


}
