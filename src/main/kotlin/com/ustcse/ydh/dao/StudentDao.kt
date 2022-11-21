package com.ustcse.ydh.dao

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.ustcse.ydh.domain.Student
import org.apache.ibatis.annotations.Mapper


/***************************************************
 *@Author 殷德好
 *@Date 2022/11/15 15:11
 *@Version 1.0
 ***************************************************/
@Mapper
interface StudentDao: UserDao<Student> {
}