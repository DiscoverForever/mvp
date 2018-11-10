package com.mvp.moon.kttest.unit.goods

import com.mvp.moon.kttest.base.BasePresenter
import com.mvp.moon.kttest.base.BaseView
import com.mvp.moon.kttest.unit.goods.GoodsPresenter

interface GoodsContract {
    interface Presenter: BasePresenter {

    }
    interface View: BaseView<GoodsPresenter> {

    }
}