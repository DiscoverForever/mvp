package com.missfresh.moon.kttest.ScanQrCode

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import com.missfresh.moon.kttest.service.GitHubService
import com.missfresh.moon.kttest.entity.repo.Repo
import com.missfresh.moon.kttest.utils.HttpUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ScanQrcodeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    fun initView() {
        verticalLayout {
            backgroundColor = Color.GRAY
            var keyword = editText() {
                hint = "请输入关键字"
            }
            button("增") {
                onClick {
                    toast("查询")


                    val service = HttpUtils().getService(GitHubService::class.java)
                    val repos = service.listRepos(keyword.text.toString())
                    repos.enqueue(object: Callback<List<Repo>> {
                        override fun onResponse(call: Call<List<Repo>>?, response: Response<List<Repo>>?) {
                             //To change body of created functions use File | Settings | File Templates.
                            response?.body()?.forEach {
                                Log.d("res", it?.name)
                            }

                        }

                        override fun onFailure(call: Call<List<Repo>>?, t: Throwable?) {
                            Log.d("res", "FAIL")
                            //To change body of created functions use File | Settings | File Templates.
                        }

                    })
                    Log.d("res", repos.toString())
                }
            }
            button("删") {
                onClick {
                    toast("查询")
                }
            }
            button("改") {
                onClick {
                    toast("查询")
                }
            }
            button("查") {
                onClick {
                    toast("查询")
                }
            }
            relativeLayout {
                backgroundColor = Color.BLACK
                gravity = Gravity.CENTER
                var tvLogo = textView {
                    text = "Missfresh"
                    textColor = Color.WHITE
                }
            }.lparams{
                width = matchParent
                height = dip(100)
            }

        }
    }
}
