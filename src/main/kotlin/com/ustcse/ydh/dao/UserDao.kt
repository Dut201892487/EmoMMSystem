package com.ustcse.ydh.dao

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Mapper

/**
 *@Author 殷德好
 *@Date 2022/11/16 22:19
 *@Version 1.0
 */
@Mapper
interface UserDao<User>:BaseMapper<User> {
}