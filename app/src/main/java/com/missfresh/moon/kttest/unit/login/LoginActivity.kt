package com.missfresh.moon.kttest.unit.login

import android.os.Bundle
import android.text.InputType
import android.view.Gravity
import android.widget.EditText
import android.widget.LinearLayout
import com.missfresh.moon.kttest.R
import com.missfresh.moon.kttest.base.BaseActivity
import com.missfresh.moon.kttest.constant.Color
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class LoginActivity() : BaseActivity(), LoginContract.View {
    override var presenter: LoginPresenter = LoginPresenter(this)
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout() {
            backgroundColor = Color.white
            relativeLayout() {
                imageView(R.drawable.logo) {

                }.lparams() {
                    width = dip(100)
                    height = dip(100)
                }
            }.lparams() {
                gravity = Gravity.CENTER
                topMargin = dip(100)
                bottomMargin = dip(30)
            }

            etUsername = editText() {
                hint = "请输入用户名"
                height = dip(50)
                singleLine = true
                hintTextColor = Color.hintText
                backgroundColor = Color.bgEditText
                leftPadding = dip(12)
                rightPadding = dip(12)
            }.lparams() {
                width = matchParent
                height = dip(50)
                topMargin = dip(10)
                leftMargin = dip(30)
                rightMargin = dip(30)

            }


            linearLayout {
                backgroundColor = Color.bgEditText
                weightSum = 3f
                orientation = LinearLayout.HORIZONTAL
                etPassword = editText {
                    inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                    hint = "请输入密码"
                    hintTextColor = Color.hintText
                    backgroundColor = Color.bgEditText
                    leftPadding = dip(12)
                    rightPadding = dip(12)
                }.lparams() {
                    weight = 2f
                    width = 0
                    height = dip(50)

                }

                button("登录") {
                    backgroundColor = Color.mainTheme
                    textColor = Color.bgEditText
                    onClick {
                        checkUsername(etUsername.text.toString(), etPassword.text.toString())
                    }
                }.lparams() {
                    weight = 1f
                    width = 0
                    height = dip(50)
                }
            }.lparams() {
                width = matchParent
                height = dip(50)
                topMargin = dip(20)
                leftMargin = dip(30)
                rightMargin = dip(30)

            }
        }
    }

    /**
     * 校验账号密码
     */
    private fun checkUsername(username: String, password: String): Boolean {
        var isValiable = false
//        TODO mock 用户名：admin 密码：admin
        if (username == "admin" && password == "admin") {
            isValiable = true
            toast("登录成功")
            startActivity<DbActivity>()
        } else if (username == "") {
            toast("用户名不能为空")

        } else if (password == "") {
            toast("密码不能为空")
        } else {
            toast("用户名或密码错误")
        }

        return isValiable
    }
}
