package com.missfresh.moon.kttest.adapter

import android.content.Context
import android.widget.ArrayAdapter
import com.missfresh.moon.kttest.entity.goods.Goods
import android.widget.TextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.missfresh.moon.kttest.R


class GoodsAdapter(context: Context, private val resourceId: Int, objects: List<Goods>): ArrayAdapter<Goods>(context, resourceId, objects){
    override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
//        val fruit = getItem(position) as Fruit // 获取当前项的Fruit实例
        val view = LayoutInflater.from(context).inflate(resourceId, null)//实例化一个对象
//        val fruitImage = view.findViewById(R.id.fruit_image) as ImageView//获取该布局内的图片视图
//        val fruitName = view.findViewById(R.id.fruit_name) as TextView//获取该布局内的文本视图
//        fruitImage.setImageResource(fruit!!.getImageId())//为图片视图设置图片资源
//        fruitName.setText(fruit!!.getName())//为文本视图设置文本内容
        return view
    }
}
