package com.ustcse.ydh.service

import com.ustcse.ydh.domain.Teacher

/**
 *@Author 殷德好
 *@Date 2022/11/16 23:21
 *@Version 1.0
 */
interface TeacherService {
    /**
     * 添加用户信息
     * 返回bool
     */
    fun save(teacher: Teacher):Boolean

    /**
     * 删除用户信息
     * 返回bool
     */
    fun delete(teacherId:Int):Boolean

    /**
     * 修改用户信息 返回bool
     */
    fun update(teacher: Teacher):Boolean

    /**
     * 精确查询用户信息，可以通过姓名、手机号、编号查询
     */
    fun getById(teacherId:Int): Teacher?

    fun getByPhone(phone:String): Teacher?

    fun getByExactName(name:String): Teacher?

    fun getByMap(columnMap:Map<String, Any> ):List<Teacher>

    /**
     * 模糊查询，可以通过姓名、手机号查询
     */

    fun getByLikePhone(phone:String):List<Teacher>

    fun getByLikeName(name:String):List<Teacher>

    fun getByLikeMap(columnMap:Map<String, Any> ):List<Teacher>

    /**
     * 查询所有用户信息
     */
    fun getAll():List<Teacher>
}