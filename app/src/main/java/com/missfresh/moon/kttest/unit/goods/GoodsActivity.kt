package com.missfresh.moon.kttest.unit.goods

import android.graphics.Color
import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import com.google.gson.Gson
import com.missfresh.moon.kttest.adapter.SuperAdaper
import com.missfresh.moon.kttest.base.BaseActivity
import com.missfresh.moon.kttest.crud.GoodsDaoOpe
import com.missfresh.moon.kttest.entity.goods.Goods
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import android.support.v7.widget.DividerItemDecoration



class GoodsActivity() : BaseActivity(), GoodsContract.View {
    override var presenter: GoodsPresenter = GoodsPresenter(this)
    lateinit var rvGoodsList: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            rvGoodsList = recyclerView {

            }.lparams {
                width = matchParent
                height = matchParent
            }
        }
        val list = GoodsDaoOpe().getAllGoods(this@GoodsActivity);
        if (list != null) {
            Log.d("===========list======", list?.size.toString())
            val adapter = SuperAdaper(list)
            val layoutManager = LinearLayoutManager(this@GoodsActivity)
            layoutManager.orientation = LinearLayout.VERTICAL
            rvGoodsList.layoutManager = layoutManager
            rvGoodsList.adapter = adapter
            rvGoodsList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        }

    }

}
