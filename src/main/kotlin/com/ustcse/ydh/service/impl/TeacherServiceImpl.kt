package com.ustcse.ydh.service.impl

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.ustcse.ydh.dao.TeacherDao
import com.ustcse.ydh.domain.Teacher
import com.ustcse.ydh.service.TeacherService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *@Author 殷德好
 *@Date 2022/11/16 23:22
 *@Version 1.0
 */
@Service
class TeacherServiceImpl:TeacherService {

    @Autowired
    private var teacherDao: TeacherDao?=null

    override fun save(teacher: Teacher): Boolean {
        teacherDao?.let {
            it.insert(teacher)
            return true
        }
        return false
    }

    override fun delete(teacherId: Int): Boolean {
        teacherDao?.let {
            it.deleteById(teacherId)
            return true
        }
        return false
    }

    override fun getById(teacherId: Int): Teacher? {
        teacherDao?.let {
            return it.selectById(teacherId)
        }
        return null
    }

    /**
     * 因为使用column字符串作为查询条件，数据库修改后，查询也要做相应的修改
     */
    override fun getByPhone(phone: String): Teacher? {
        teacherDao?.let {
            val qw = QueryWrapper<Teacher>()
            qw.eq("phone_number", phone)
            return it.selectOne(qw)
        }
        return null
    }

    override fun getByExactName(name: String): Teacher? {
        teacherDao?.let {
            val qw = QueryWrapper<Teacher>()
            qw.eq("username", name)
            return it.selectOne(qw)
        }
        return null
    }

    override fun getByMap(columnMap: Map<String, Any>): List<Teacher> {
        teacherDao?.let {
            // 通过 map 传递参数，不是通过 LIKE 查询，而是通过 = 查询
            return it.selectByMap(columnMap)
        }
        return listOf()
    }

    override fun getByLikePhone(phone: String): List<Teacher> {
        teacherDao?.let {
            val qw = QueryWrapper<Teacher>()
            qw.like("phone_number", phone)
            return it.selectList(qw)
        }
        return listOf()
    }

    override fun getByLikeName(name: String): List<Teacher> {
        teacherDao?.let {
            val qw = QueryWrapper<Teacher>()
            qw.like("username", name)
            return it.selectList(qw)
        }
        return listOf()
    }

    override fun getByLikeMap(columnMap: Map<String, Any>): List<Teacher> {
        teacherDao?.let {
            val qw = QueryWrapper<Teacher>()
            for ((k,v) in columnMap){
                qw.like(k, "$v")
            }
            return it.selectList(qw)
        }
        return listOf()
    }

    override fun getAll(): List<Teacher> {
        teacherDao?.let {
            return it.selectList(null)
        }
        return listOf()
    }

    override fun update(teacher: Teacher): Boolean {
        teacherDao?.let {
            it.updateById(teacher)
            return true
        }
        return false
    }
}