package com.mvp.moon.kttest.crud

import android.content.Context
import com.mvp.moon.kttest.entity.goods.Goods
import com.mvp.moon.kttest.greendao.GoodsDao
import com.mvp.moon.kttest.utils.DbManager
import org.greenrobot.greendao.query.QueryBuilder
import org.greenrobot.greendao.query.WhereCondition


class GoodsDaoOpe() {


    /**
     * 添加数据至数据库
     * @param context
     * *
     * @param goods
     */
    fun createGoods(context: Context?, goods: Goods) {

        DbManager.getInstance(context!!)?.getDaoSession(context)?.getGoodsDao()?.insert(goods)
    }


    /**
     * 将数据实体通过事务添加至数据库
     * @param context
     * *
     * @param list
     */
    fun createGoods(context: Context?, list: List<Goods>?) {
        if (null == list || list.size <= 0) {
            return
        }
        DbManager.getInstance(context!!)?.getDaoSession(context)?.getGoodsDao()?.insertInTx(list)
    }

    /**
     * 添加数据至数据库，如果存在，将原来的数据覆盖
     * 内部代码判断了如果存在就update(entity);不存在就insert(entity)；
     * @param context
     * *
     * @param Goods
     */
    fun createOrupdateGoods(context: Context?, Goods: Goods) {
        DbManager.getInstance(context!!)?.getDaoSession(context)?.getGoodsDao()?.save(Goods)
    }

    /**
     * 删除数据至数据库

     * @param context
     * *
     * @param Goods 删除具体内容
     */
    fun deleteGoods(context: Context?, Goods: Goods) {
        DbManager.getInstance(context!!)?.getDaoSession(context)?.getGoodsDao()?.delete(Goods)
    }

    /**
     * 根据id删除数据至数据库
     * @param context
     * *
     * @param id      删除具体内容
     */
    fun deleteGoodsById(context: Context?, id: Long) {
        DbManager.getInstance(context!!)?.getDaoSession(context)?.getGoodsDao()?.deleteByKey(id)
    }

    /**
     * 删除全部数据
     * @param context
     */
    fun deleteAllGoods(context: Context?) {
        DbManager.getInstance(context!!)?.getDaoSession(context)?.getGoodsDao()?.deleteAll()
    }

    /**
     * 更新数据库
     * @param context
     * *
     * @param Goods
     */
    fun updateGoods(context: Context?, Goods: Goods) {
        DbManager.getInstance(context!!)?.getDaoSession(context)?.getGoodsDao()?.update(Goods)
    }


    /**
     * 查询所有数据
     * @param context
     * *
     * @return
     */
    fun getAllGoods(context: Context?): MutableList<Goods>? {
        val builder = DbManager.getInstance(context!!)?.getDaoSession(context)?.getGoodsDao()?.queryBuilder()
        return builder?.build()?.list()
    }

    /**
     * 根据id，其他的字段类似
     * @param context
     * *
     * @param id
     * *
     * @return
     */
    fun getGoodsById(context: Context?, id: Long): Goods? {
        val builder = DbManager.getInstance(context!!)?.getDaoSession(context)?.getGoodsDao()?.queryBuilder()
        /**
         * 返回当前id的数据集合,当然where(这里面可以有多组，做为条件);
         * 这里build.list()；与where(GoodsDao.Properties.Id.eq(id)).list()结果是一样的；
         * 在QueryBuilder类中list()方法return build().list();

         */
        // Query<Goods> build = builder.where(GoodsDao.Properties.Id.eq(id)).build();
        // List<Goods> list = build.list();
        return builder?.where(GoodsDao.Properties.Id.eq(id))?.unique()
    }


    fun searchGoods(context: Context?, cond: WhereCondition, vararg condMore: WhereCondition): MutableList<Goods>? {
        val builder = DbManager.getInstance(context!!)?.getDaoSession(context)?.getGoodsDao()?.queryBuilder()
        return builder?.where(cond, *condMore)?.list()
    }
}