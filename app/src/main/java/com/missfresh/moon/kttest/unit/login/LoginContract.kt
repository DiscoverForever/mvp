package com.missfresh.moon.kttest.unit.login

import com.missfresh.moon.kttest.base.BasePresenter
import com.missfresh.moon.kttest.base.BaseView

interface LoginContract {
    interface Presenter: BasePresenter {

    }
    interface View: BaseView<LoginPresenter> {

    }
}