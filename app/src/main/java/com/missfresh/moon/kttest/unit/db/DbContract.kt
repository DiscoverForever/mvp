package com.missfresh.moon.kttest.unit.login

import com.missfresh.moon.kttest.base.BasePresenter
import com.missfresh.moon.kttest.base.BaseView

interface DbContract {
    interface Presenter: BasePresenter {

    }
    interface View: BaseView<DbPresenter> {

    }
}