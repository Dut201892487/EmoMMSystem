package com.ustcse.ydh.service

import com.ustcse.ydh.domain.Student

/**
 *@Author 殷德好
 *@Date 2022/11/16 22:58
 *@Version 1.0
 */
interface StudentService{
    /**
     * 添加用户信息
     * 返回bool
     */
    fun save(student: Student):Boolean

    /**
     * 删除用户信息
     * 返回bool
     */
    fun delete(studentId:Long):Boolean

    /**
     * 修改用户信息 返回bool
     */
    fun update(student: Student):Boolean

    /**
     * 精确查询用户信息，可以通过姓名、手机号、编号查询
     */
    fun getById(studentId:Long): Student?
    fun getByStuId(studentId:String): Student?

    fun getByPhone(phone:String): Student?

    fun getByExactName(name:String): Student?

    fun getByMap(columnMap:Map<String, Any> ):List<Student>

    /**
     * 模糊查询，可以通过学号、姓名、手机号查询
     */

    fun getByLikePhone(phone:String):List<Student>

    fun getByLikeStuId(studentId:String):List<Student>

    fun getByLikeName(name:String):List<Student>

    fun getByLikeMap(columnMap:Map<String, Any> ):List<Student>

    /**
     * 查询所有用户信息
     */
    fun getAll():List<Student>

}