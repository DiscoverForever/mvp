package com.missfresh.moon.kttest.unit.db

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.missfresh.moon.kttest.base.BaseActivity
import com.missfresh.moon.kttest.crud.UserDaoOpe
import com.missfresh.moon.kttest.entity.user.User
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class DbActivity() : BaseActivity(), DbContract.View {
    override var presenter: DbPresenter = DbPresenter(this)
    private lateinit var etName: EditText
    private lateinit var etAge: EditText
    private lateinit var mContext: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                    UserDaoOpe.getInstance().insertData(mContext, user)
                }
            }
            button("删除") {
                onClick { }
            }
            button("修改") {
                onClick { }
            }
            button("查询") {
                onClick {
                    var user = UserDaoOpe.getInstance().queryById(mContext, 1)
                    Log.d("name", user?.name)
                    Log.d("age", user?.age)
                }
            }
        }

    }


}
