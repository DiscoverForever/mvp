package com.missfresh.moon.kttest.unit.db

import android.os.Bundle
import com.missfresh.moon.kttest.base.BaseActivity
import com.missfresh.moon.kttest.unit.login.DbContract
import com.missfresh.moon.kttest.unit.login.DbPresenter

class DbActivity() : BaseActivity(), DbContract.View {
    override var presenter: DbPresenter = DbPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


}
