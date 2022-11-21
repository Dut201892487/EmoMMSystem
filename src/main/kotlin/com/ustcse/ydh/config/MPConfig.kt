package com.ustcse.ydh.config

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 *@Author 殷德好
 *@Date 2022/9/25 18:21
 *@Version 1.0
 */
@Configuration
class MPConfig {
    @Bean
    fun mpInterceptor():MybatisPlusInterceptor{
        //1.定义Mp拦截器
        val mpInterceptor = MybatisPlusInterceptor()
        //2.添加具体的拦截器
        mpInterceptor.addInnerInterceptor(PaginationInnerInterceptor())
        return mpInterceptor
    }
}