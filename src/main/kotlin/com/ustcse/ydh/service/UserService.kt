package com.ustcse.ydh.service



/**
 *@Author 殷德好
 *@Date 2022/11/16 16:56
 *@Version 1.0
 */
interface UserService<User> {
    /**
     * 添加用户信息
     * 返回bool
     */
    fun save(user: User):Boolean

    /**
     * 删除用户信息
     * 返回bool
     */
    fun delete(userId:Int):Boolean

    /**
     * 修改用户信息 返回bool
     */
    fun update(user: User):Boolean

    /**
     * 精确查询用户信息，可以通过姓名、手机号、编号查询
     */
    fun getById(userId:Int): User?

    fun getByPhone(phone:String): User?

    fun getByExactName(name:String): User?

    fun getByMap(columnMap:Map<String, Any> ):List<User>

    /**
     * 模糊查询，可以通过姓名、手机号查询
     */

    fun getByLikePhone(phone:String):List<User>

    fun getByLikeName(name:String):List<User>

    fun getByLikeMap(columnMap:Map<String, Any> ):List<User>

    /**
     * 查询所有用户信息
     */
    fun getAll():List<User>
}