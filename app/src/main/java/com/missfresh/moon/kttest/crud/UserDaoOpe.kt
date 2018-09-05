package com.missfresh.moon.kttest.crud

import android.content.Context
import com.missfresh.moon.kttest.entity.user.User
import com.missfresh.moon.kttest.greendao.UserDao
import com.missfresh.moon.kttest.utils.DbManager
import org.greenrobot.greendao.query.QueryBuilder
import org.greenrobot.greendao.query.WhereCondition


class UserDaoOpe() {


    /**
     * 添加数据至数据库
     * @param context
     * *
     * @param user
     */
    fun createUser(context: Context?, user: User) {

        DbManager.getInstance(context!!)?.getDaoSession(context)?.getUserDao()?.insert(user)
    }


    /**
     * 将数据实体通过事务添加至数据库
     * @param context
     * *
     * @param list
     */
    fun createUser(context: Context?, list: List<User>?) {
        if (null == list || list.size <= 0) {
            return
        }
        DbManager.getInstance(context!!)?.getDaoSession(context)?.getUserDao()?.insertInTx(list)
    }

    /**
     * 添加数据至数据库，如果存在，将原来的数据覆盖
     * 内部代码判断了如果存在就update(entity);不存在就insert(entity)；
     * @param context
     * *
     * @param User
     */
    fun createOrupdateUser(context: Context?, User: User) {
        DbManager.getInstance(context!!)?.getDaoSession(context)?.getUserDao()?.save(User)
    }

    /**
     * 删除数据至数据库

     * @param context
     * *
     * @param User 删除具体内容
     */
    fun deleteUser(context: Context?, User: User) {
        DbManager.getInstance(context!!)?.getDaoSession(context)?.getUserDao()?.delete(User)
    }

    /**
     * 根据id删除数据至数据库
     * @param context
     * *
     * @param id      删除具体内容
     */
    fun deleteUserById(context: Context?, id: Long) {
        DbManager.getInstance(context!!)?.getDaoSession(context)?.getUserDao()?.deleteByKey(id)
    }

    /**
     * 删除全部数据
     * @param context
     */
    fun deleteAllUser(context: Context?) {
        DbManager.getInstance(context!!)?.getDaoSession(context)?.getUserDao()?.deleteAll()
    }

    /**
     * 更新数据库
     * @param context
     * *
     * @param User
     */
    fun updateUser(context: Context?, User: User) {
        DbManager.getInstance(context!!)?.getDaoSession(context)?.getUserDao()?.update(User)
    }


    /**
     * 查询所有数据
     * @param context
     * *
     * @return
     */
    fun getAllUser(context: Context?): MutableList<User>? {
        val builder = DbManager.getInstance(context!!)?.getDaoSession(context)?.getUserDao()?.queryBuilder()
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
    fun getUserById(context: Context?, id: Long): User? {
        val builder = DbManager.getInstance(context!!)?.getDaoSession(context)?.getUserDao()?.queryBuilder()
        /**
         * 返回当前id的数据集合,当然where(这里面可以有多组，做为条件);
         * 这里build.list()；与where(UserDao.Properties.Id.eq(id)).list()结果是一样的；
         * 在QueryBuilder类中list()方法return build().list();

         */
        // Query<User> build = builder.where(UserDao.Properties.Id.eq(id)).build();
        // List<User> list = build.list();
        return builder?.where(UserDao.Properties.Id.eq(id))?.unique()
    }


    fun searchUser(context: Context?, cond: WhereCondition, vararg condMore: WhereCondition): MutableList<User>? {
        val builder = DbManager.getInstance(context!!)?.getDaoSession(context)?.getUserDao()?.queryBuilder()
        return builder?.where(cond, *condMore)?.list()
    }
}