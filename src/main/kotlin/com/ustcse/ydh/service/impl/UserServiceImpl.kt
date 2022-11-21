package com.ustcse.ydh.service.impl

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.ustcse.ydh.dao.AdminDao
import com.ustcse.ydh.dao.StudentDao
import com.ustcse.ydh.dao.TeacherDao

import com.ustcse.ydh.dao.UserDao
import com.ustcse.ydh.domain.Student
import com.ustcse.ydh.domain.Teacher
import com.ustcse.ydh.service.UserService
import org.apache.ibatis.annotations.Mapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *@Author 殷德好
 *@Date 2022/11/16 16:57
 *@Version 1.0
 * 想用泛型偷懒，未竟
 */

@Service
class UserServiceImpl<User>:UserService<User> {
    /**
     * todo
     * MybatisPlus找不到泛型对应的映射类
     *
     */
    @Autowired
    private var userDao:UserDao<User>?=null


    override fun save(user: User): Boolean {
        userDao?.let {
            it.insert(user)
            return true
        }
        return false
    }

    override fun delete(userId: Int): Boolean {
        userDao?.let {
            it.deleteById(userId)
            return true
        }
        return false
    }

    override fun getById(userId: Int): User? {
        userDao?.let {
            return it.selectById(userId)
        }
        return null
    }

    /**
     * 因为使用column字符串作为查询条件，数据库修改后，查询也要做相应的修改
     */
    override fun getByPhone(phone: String): User? {
        userDao?.let {
            val qw = QueryWrapper<User>()
            qw.eq("phone_number", phone)
            return it.selectOne(qw)
        }
        return null
    }

    override fun getByExactName(name: String): User? {
        userDao?.let {
            val qw = QueryWrapper<User>()
            qw.eq("username", name)
            return it.selectOne(qw)
        }
        return null
    }

    override fun getByMap(columnMap: Map<String, Any>): List<User> {
        userDao?.let {
            // 通过 map 传递参数，不是通过 LIKE 查询，而是通过 = 查询
            return it.selectByMap(columnMap)
        }
        return listOf()
    }

    override fun getByLikePhone(phone: String): List<User> {
        userDao?.let {
            val qw = QueryWrapper<User>()
            qw.like("phone_number", phone)
            return it.selectList(qw)
        }
        return listOf()
    }

    override fun getByLikeName(name: String): List<User> {
        userDao?.let {
            val qw = QueryWrapper<User>()
            qw.like("username", name)
            return it.selectList(qw)
        }
        return listOf()
    }

    override fun getByLikeMap(columnMap: Map<String, Any>): List<User> {
        userDao?.let {
            val qw = QueryWrapper<User>()
            for ((k,v) in columnMap){
                qw.like(k, "$v")
            }
            return it.selectList(qw)
        }
        return listOf()
    }

    override fun getAll(): List<User> {
        userDao?.let {
            return it.selectList(null)
        }
        return listOf()
    }

    override fun update(user: User): Boolean {
        userDao?.let {
            it.updateById(user)
            return true
        }
        return false
    }
}