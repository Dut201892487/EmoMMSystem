package com.ustcse.ydh.service.impl

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.core.toolkit.support.SFunction
import com.ustcse.ydh.dao.AdminDao
import com.ustcse.ydh.domain.SysAdmin
import com.ustcse.ydh.service.AdminService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/***************************************************
 *@Author 殷德好
 *@Date 2022/11/15 16:44
 *@Version 1.0
 ***************************************************/
@Service
class AdminServiceImpl:AdminService {
    @Autowired
    private val adminDao:AdminDao?=null

    override fun save(admin: SysAdmin): Boolean {
        adminDao?.let {
            it.insert(admin)
            return true
        }
        return false
    }

    override fun delete(adminId: Int): Boolean {
        adminDao?.let {
            it.deleteById(adminId)
            return true
        }
        return false
    }

    override fun update(admin: SysAdmin): Boolean {
        adminDao?.let {
            it.updateById(admin)
            return true
        }
        return false
    }

    override fun getById(adminId: Int): SysAdmin? {
        adminDao?.let {
            return it.selectById(adminId)
        }
        return null
    }

    override fun getByPhone(phone: String): SysAdmin? {
        adminDao?.let {
            val lqw = LambdaQueryWrapper<SysAdmin>()
            lqw.eq(SysAdmin::phoneNumber, phone)
            return it.selectOne(lqw)
        }
        return null
    }

    override fun getByExactName(name: String): SysAdmin? {
        adminDao?.let {
            val lqw = LambdaQueryWrapper<SysAdmin>()
            lqw.eq(SysAdmin::username, name)
            return it.selectOne(lqw)
        }
        return null
    }

    override fun getByMap(columnMap:Map<String, Any> ):List<SysAdmin>{
        adminDao?.let {
            // 通过 map 传递参数，不是通过 LIKE 查询，而是通过 = 查询
            return it.selectByMap(columnMap)
        }
        return listOf()
    }


    override fun getByLikeId(adminId: Int): List<SysAdmin> {
        adminDao?.let {
            val lqw = LambdaQueryWrapper<SysAdmin>()
            lqw.like(SysAdmin::adminId, adminId)
            return it.selectList(lqw)
        }
        return listOf()
    }

    override fun getByLikePhone(phone: String): List<SysAdmin> {
        adminDao?.let {
            val lqw = LambdaQueryWrapper<SysAdmin>()
            lqw.like(SysAdmin::phoneNumber, phone)
            return it.selectList(lqw)
        }
        return listOf()
    }

    override fun getByLikeName(name: String): List<SysAdmin> {
        adminDao?.let {
            val lqw = LambdaQueryWrapper<SysAdmin>()
            lqw.like(SysAdmin::username, name)
            return it.selectList(lqw)
        }
        return listOf()
    }

    override fun getByLikeMap(columnMap: Map<String, Any>): List<SysAdmin> {
        adminDao?.let {
            val qw = QueryWrapper<SysAdmin>()
            for ((k,v) in columnMap){
                qw.like(k, "$v")
            }

            return it.selectList(qw)
        }
        return listOf()
    }

    override fun getAll(): List<SysAdmin> {
        adminDao?.let {
            return it.selectList(null)
        }
        return listOf()
    }
}