package com.ustcse.ydh

import com.ustcse.ydh.dao.StudentDao
import com.ustcse.ydh.domain.Student
import com.ustcse.ydh.domain.SysAdmin
import com.ustcse.ydh.service.AdminService
import com.ustcse.ydh.service.StudentService
import com.ustcse.ydh.service.UserService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import javax.annotation.Resource


@SpringBootTest()
class EmoMmSystemApplicationTests {

    @Autowired
    private val adminService: AdminService?=null

    @Autowired
    private val studentService:StudentService?=null

    @Test
    fun contextLoads() {

    }

    @Test
    fun testGetAllAdmin(){
        val adminList = adminService!!.getAll()
        println(adminList)
    }

    @Test
    fun testGetAllStudent(){
        val stuList = studentService?.getAll()
        println(stuList)
    }

    @Test
    fun testAddStudent(){
        val student = Student()
        student.let {
            it.studentId = "SA22225453"
            it.username = "殷德好"
            it.phoneNumber = "19956704343"
            it.password = "123456"
        }
        studentService?.save(student)
    }

    @Test
    fun testAddAdmin(){
        val admin = SysAdmin()
        admin.let {
            it.username = "殷德好"
            it.phoneNumber = "19956704343"
            it.password = "123456"
        }
        adminService?.save(admin)
    }

    @Test
    fun testGetByMap(){
        val map = mapOf<String,Any>(
            Pair("username","殷"),Pair("password","2"),)
        adminService?.let {
            it.getByLikeMap(map)
        }
    }


}
