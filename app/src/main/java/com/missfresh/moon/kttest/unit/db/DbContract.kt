package com.missfresh.moon.kttest.unit.db

import com.missfresh.moon.kttest.base.BasePresenter
import com.missfresh.moon.kttest.base.BaseView

interface DbContract {
    interface Presenter: BasePresenter {

    }
    interface View: BaseView<DbPresenter> {

    }
}