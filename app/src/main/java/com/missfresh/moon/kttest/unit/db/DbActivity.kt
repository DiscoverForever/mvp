package com.missfresh.moon.kttest.unit.db

import android.app.Dialog
import android.content.Context
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.*
import com.missfresh.moon.kttest.R
import com.missfresh.moon.kttest.base.BaseActivity
import com.missfresh.moon.kttest.crud.GoodsDaoOpe
import com.missfresh.moon.kttest.crud.UserDaoOpe
import com.missfresh.moon.kttest.entity.goods.Goods
import com.missfresh.moon.kttest.entity.user.User
import com.missfresh.moon.kttest.event.LoginEvent
import com.missfresh.moon.kttest.event.MessageEvent
import com.missfresh.moon.kttest.unit.goods.GoodsActivity
import com.missfresh.moon.kttest.utils.DialogUtils
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.util.*
import java.util.Arrays.asList
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


class DbActivity() : BaseActivity(), DbContract.View {
    override var presenter: DbPresenter = DbPresenter(this)
    private lateinit var etName: EditText
    private lateinit var etAge: EditText
    private lateinit var mContext: Context
    private lateinit var lvUser: ListView
    private lateinit var tvTips: TextView
    private lateinit var vtly: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EventBus.getDefault().register(this)
        mContext = this
        verticalLayout() {
            linearLayout() {
                weightSum = 3f
                orientation = LinearLayout.HORIZONTAL
                textView() {
                    text = "姓名"
                }.lparams {
                    width = dip(50)
                    gravity = Gravity.CENTER
                }
                etName = editText() {
                    hint = "name"
                }.lparams {
                    weight = 3f
                    width = 0
                }
            }.lparams {
                width = matchParent
                leftMargin = dip(30)
                rightMargin = dip(30)
            }
            linearLayout() {
                weightSum = 3f
                orientation = LinearLayout.HORIZONTAL
                textView {
                    text = "年龄"
                }.lparams {
                    width = dip(50)
                    gravity = Gravity.CENTER
                }
                etAge = editText() {
                    hint = "age"
                }.lparams {
                    weight = 3f
                    width = 0
                }
            }.lparams {
                width = matchParent
                leftMargin = dip(30)
                rightMargin = dip(30)
            }
            button("新增") {
                onClick {
                    var user = User()
                    user.name = etName.text?.toString()
                    user.age = etAge.text?.toString()
                    UserDaoOpe().createUser(mContext, user)
                }
            }
            button("删除") {
                onClick {
                    UserDaoOpe().deleteUserById(mContext, 1)
                }
            }
            button("修改") {
                onClick {
                    DialogUtils.showDialog(mContext, "提示", "是否确认补货完成？确认后无法修改", fun() {
                        toast("确定")
                        EventBus.getDefault().post(MessageEvent("I come from DBActivity"))
                    }, fun() {
                        toast("取消")
                    })
                }
            }
            button("查询") {
                onClick {
                    startActivity<GoodsActivity>()
//                    var user = UserDaoOpe().getUserById(mContext, 1)
//                    Log.d("name", user?.name)
//                    Log.d("age", user?.age)
//                    var data = mutableListOf<Map<String, Long>>()
//                    getGoodsList().forEach {
//                        var set = mutableMapOf<String, Long>("id" to it.id, "codeType" to it.codeType.toLong())
//                        data.add(set)
//                    }
//                    lvUser.adapter = SimpleAdapter(mContext, data, R.layout.list_item, arrayOf("id", "codeType"), intArrayOf(R.id.tv1, R.id.tv2))
//                    lvUser.adapter = ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, arrayListOf<String>("1", "2", "3"))
                }
            }
            button("缓存盘点数据") {
                onClick {
                    GoodsDaoOpe().createGoods(this@DbActivity, getGoodsList())


                }
            }
            vtly = verticalLayout {
                lvUser = listView()
                linearLayout() {
                    tvTips = textView("系统未检测出临期过期商品，您可手动扫码添加报损商品")
                }.lparams {
                    gravity = Gravity.CENTER
                    width = matchParent
                    height = dip(150)
                }
            }
        }

    }

    fun toggleTips() {
        if (vtly.visibility === View.INVISIBLE) {
            vtly.visibility = View.VISIBLE

        } else {
            vtly.visibility = View.INVISIBLE

        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    open fun onLoginEvent(loginEvent: LoginEvent) {
        toast(loginEvent.message)
        Log.d("LoginEvent", loginEvent.message)
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    fun getGoodsList(): ArrayList<Goods> {
        var goodsList = ArrayList<Goods>()
        for (i in 11..20) {
            var goods = Goods()
            goods.id = i.toLong()
            goods.shelfLay = 2
            goods.layLine = 2
            goods.goodsName = "华北红肉火龙果【品类水果】"
            goods.goodsNo = "p-hbhrhlg-1g"
            goods.picUrl = "https://image.missfresh.cn/731945401be04d6e87cda4d08401785e.jpeg"
            goods.codeType = 2
            goods.codeNo = "6000006"
            goods.materialNo = "6000006"
            goods.qualityType = 0
            goods.operationDate = 1536031350385
            goods.uniqueCode = 275
            goodsList.add(goods)

        }
        return goodsList
    }

}
