package com.mvp.moon.kttest.unit.login

import com.mvp.moon.kttest.base.BasePresenter
import com.mvp.moon.kttest.base.BaseView

interface LoginContract {
    interface Presenter: BasePresenter {

    }
    interface View: BaseView<LoginPresenter> {

    }
}