package com.ustcse.ydh.service

import com.ustcse.ydh.domain.SysAdmin

/**
 *@Author 殷德好
 *@Date 2022/11/15 16:43
 *@Version 1.0
 */
interface AdminService {

    /**
     * 添加用户信息
     * 返回bool
     */
    fun save(admin: SysAdmin):Boolean

    /**
     * 删除用户信息
     * 返回bool
     */
    fun delete(adminId:Int):Boolean

    /**
     * 修改用户信息 返回bool
     */
    fun update(admin:SysAdmin):Boolean

    /**
     * 精确查询用户信息，可以通过姓名、手机号、编号查询
     */
    fun getById(adminId:Int):SysAdmin?

    fun getByPhone(phone:String):SysAdmin?

    fun getByExactName(name:String):SysAdmin?

    fun getByMap(columnMap:Map<String, Any> ):List<SysAdmin>

    /**
     * 模糊查询，可以通过姓名、手机号、编号查询
     */
    fun getByLikeId(adminId:Int):List<SysAdmin>

    fun getByLikePhone(phone:String):List<SysAdmin>

    fun getByLikeName(name:String):List<SysAdmin>

    fun getByLikeMap(columnMap:Map<String, Any> ):List<SysAdmin>

    /**
     * 查询所有用户信息
     */
    fun getAll():List<SysAdmin>
}