package com.ustcse.ydh.controller

import com.ustcse.ydh.controller.Result
import com.ustcse.ydh.domain.Student
import com.ustcse.ydh.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.*

/***************************************************
 *@Author 殷德好
 *@Date 2022/11/15 16:41
 *@Version 1.0
 ***************************************************/
@RestController
@RequestMapping("/students")
class StudentController {
    @Autowired
    private val studentService:StudentService?=null
    // SHA256 密码加密
    private val encode = BCryptPasswordEncoder()


    /**
     * 学生登录
     * @param stu:Student
     * @sample {"id":123,"password":123456,"phone_number":123456}
     */
    @PostMapping("/login")
    fun login(@RequestBody stu:Student):Result{
        studentService?.let {service->
            // 使用学号登录
            val student = stu.studentId?.let { id ->
                service.getByStuId(id)
            }?:run {
                // 使用手机号登录
                stu.phoneNumber?.let {phone->
                    service.getByPhone(phone)
                }
            }
            student?.let {
                // 选择密码加密算法
                if (encode.matches(student.password, stu.password)){
                    return Result(Code.GET_OK, student, msg = "学号密码验证成功")
                }else{
                    return Result(Code.GET_ERROR, "学号密码不匹配")
                }
            }
            return Result(Code.GET_ERROR, "手机号/学号不正确")
        }
        return Result(Code.GET_ERROR, "系统错误")

    }


    @GetMapping("/{stuId}")
    fun getStuById(@PathVariable stuId:String):Result{
        studentService?.let { service ->
            service.getByStuId(stuId)?.let {
                return Result(Code.GET_OK,it,"查找成功")
            }
            return Result(Code.GET_ERROR,"学号为$stuId 的学生信息不存在")
        }
        return Result(Code.GET_ERROR, "系统错误")
    }
    @GetMapping("/")
    fun getAllStu():Result{
        studentService?.let { service ->
            val stuList = service.getAll()
            return Result(Code.GET_OK,stuList,"查找成功")
        }
        return Result(Code.GET_ERROR, "系统错误")
    }

    @PostMapping("/{stuId}")
    fun updateStuById(@PathVariable stuId:String, @RequestBody stu:Student):Result{
        studentService?.let {
            stu.password = encode.encode(stu.password)
            if(it.update(stu))
                return Result(Code.UPDATE_OK,stu,"更新成功")
            else
                return Result(Code.UPDATE_ERROR,"更新失败")
        }
        return Result(Code.GET_ERROR, "系统错误")
    }

    @PutMapping("/{stuId}")
    fun addStu(@PathVariable stuId:String, @RequestBody stu:Student):Result {
        studentService?.let {
            stu.password = encode.encode(stu.password)
            println(stu)
            if(it.save(stu)){
                return Result(Code.SAVE_OK,stu,"添加成功")
            }else{
                return Result(Code.SAVE_ERROR,"添加失败")
            }
        }
        return Result(Code.GET_ERROR, "系统错误")
    }

    @DeleteMapping("/{stuId}")
    fun deleteStu(@PathVariable stuId:String, @RequestBody stu:Student):Result {
        studentService?.let {
            if(it.delete(stu.userId)){
                return Result(Code.SAVE_OK,stu,"删除成功")
            }else{
                return Result(Code.SAVE_ERROR,"删除失败")
            }
        }
        return Result(Code.GET_ERROR, "系统错误")
    }
}