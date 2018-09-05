package com.missfresh.moon.kttest.utils

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.widget.Toast


object DialogUtils {
    fun showDialog(context: Context, title: String, message: String, onSuccess: () -> Unit?, onCancle: () -> Unit?) {
        val dialog = AlertDialog.Builder(context)
                .setTitle(title)//设置对话框的标题
                .setMessage(message)//设置对话框的内容
                //设置对话框的按钮
                .setNegativeButton("取消", DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                    onCancle()
                })
                .setPositiveButton("确定", DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                    onSuccess()
                }).create()
        dialog.show()
    }
}