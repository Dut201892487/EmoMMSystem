package com.ustcse.ydh.service.impl

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.ustcse.ydh.dao.StudentDao
import com.ustcse.ydh.domain.Student
import com.ustcse.ydh.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *@Author 殷德好
 *@Date 2022/11/16 23:18
 *@Version 1.0
 */
@Service
class StudentServiceImpl:StudentService {

    @Autowired
    private var studentDao: StudentDao?=null

    override fun save(student: Student): Boolean {
        studentDao?.let {
            it.insert(student)
            return true
        }
        return false
    }

    override fun delete(studentId: Long): Boolean {
        studentDao?.let {
            it.deleteById(studentId)
            return true
        }
        return false
    }

    override fun getById(studentId: Long): Student? {
        studentDao?.let {
            return it.selectById(studentId)
        }
        return null
    }
    override fun getByStuId(studentId:String): Student?{
        studentDao?.let {
            val qw = QueryWrapper<Student>()
            qw.eq("student_id", studentId)
            return it.selectOne(qw)
        }
        return null
    }

    /**
     * 因为使用column字符串作为查询条件，数据库修改后，查询也要做相应的修改
     */
    override fun getByPhone(phone: String): Student? {
        studentDao?.let {
            val qw = QueryWrapper<Student>()
            qw.eq("phone_number", phone)
            return it.selectOne(qw)
        }
        return null
    }

    override fun getByExactName(name: String): Student? {
        studentDao?.let {
            val qw = QueryWrapper<Student>()
            qw.eq("username", name)
            return it.selectOne(qw)
        }
        return null
    }

    override fun getByMap(columnMap: Map<String, Any>): List<Student> {
        studentDao?.let {
            // 通过 map 传递参数，不是通过 LIKE 查询，而是通过 = 查询
            return it.selectByMap(columnMap)
        }
        return listOf()
    }

    override fun getByLikePhone(phone: String): List<Student> {
        studentDao?.let {
            val qw = QueryWrapper<Student>()
            qw.like("phone_number", phone)
            return it.selectList(qw)
        }
        return listOf()
    }

    override fun getByLikeName(name: String): List<Student> {
        studentDao?.let {
            val qw = QueryWrapper<Student>()
            qw.like("username", name)
            return it.selectList(qw)
        }
        return listOf()
    }
    override fun getByLikeStuId(studentId:String):List<Student>{
        studentDao?.let {
            val qw = QueryWrapper<Student>()
            qw.like("student_id", studentId)
            return it.selectList(qw)
        }
        return listOf()
    }
    override fun getByLikeMap(columnMap: Map<String, Any>): List<Student> {
        studentDao?.let {
            val qw = QueryWrapper<Student>()
            for ((k,v) in columnMap){
                qw.like(k, "$v")
            }
            return it.selectList(qw)
        }
        return listOf()
    }

    override fun getAll(): List<Student> {
        studentDao?.let {
            return it.selectList(null)
        }
        return listOf()
    }

    override fun update(student: Student): Boolean {
        studentDao?.let {
            it.updateById(student)
            return true
        }
        return false
    }
}