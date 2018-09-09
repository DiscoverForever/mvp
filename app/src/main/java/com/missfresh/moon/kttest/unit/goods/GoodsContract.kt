package com.missfresh.moon.kttest.unit.goods

import com.missfresh.moon.kttest.base.BasePresenter
import com.missfresh.moon.kttest.base.BaseView
import com.missfresh.moon.kttest.unit.goods.GoodsPresenter

interface GoodsContract {
    interface Presenter: BasePresenter {

    }
    interface View: BaseView<GoodsPresenter> {

    }
}