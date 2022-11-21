package com.ustcse.ydh.domain

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.util.*

/*******************************
 *@Author 殷德好
 *@Date 2022/11/15 14:55
 *@Version 1.0
 */
/***********************************************************************
 * Module:  Student.java
 * Purpose: Defines the Class 学生
 ***********************************************************************/

class Student {
    @TableField(value="student_id")
    var studentId: String? = null

    var username: String? = null
    var birthday : Date? = null
    var gender  = false
    var grade = 0
    @TableField(value="class")
    var className: String? = null
    var phoneNumber: String? = null
    var email : String? = null
    @TableId(type = IdType.ASSIGN_ID)
    var userId: Long = 0
    var password:String?=null
    override fun toString(): String {
        return "Student(studentId=$studentId, username=$username, birthday=$birthday, gender=$gender, grade=$grade, className=$className, phoneNumber=$phoneNumber, email=$email, userId=$userId, password=$password)"
    }

}