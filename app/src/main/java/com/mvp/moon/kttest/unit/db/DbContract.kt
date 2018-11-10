package com.mvp.moon.kttest.unit.db

import com.mvp.moon.kttest.base.BasePresenter
import com.mvp.moon.kttest.base.BaseView

interface DbContract {
    interface Presenter: BasePresenter {

    }
    interface View: BaseView<DbPresenter> {

    }
}