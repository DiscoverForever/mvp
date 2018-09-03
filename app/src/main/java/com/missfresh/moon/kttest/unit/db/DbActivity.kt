package com.missfresh.moon.kttest.unit.db

import android.os.Bundle
import com.missfresh.moon.kttest.base.BaseActivity

class DbActivity() : BaseActivity(), DbContract.View {
    override var presenter: DbPresenter = DbPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


}
