package com.ustcse.ydh

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import com.alibaba.druid.pool.DruidDataSource
import org.springframework.web.servlet.config.annotation.EnableWebMvc

//(exclude = [DataSourceAutoConfiguration::class])
@SpringBootApplication
@EnableWebMvc
@MapperScan("com.ustcse.ydh.dao")
class EmoMmSystemApplication

fun main(args: Array<String>) {
    runApplication<EmoMmSystemApplication>(*args)
}

