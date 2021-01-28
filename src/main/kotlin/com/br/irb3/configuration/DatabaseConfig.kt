package com.br.irb3.configuration

import org.springframework.context.annotation.Configuration
import com.zaxxer.hikari.HikariDataSource

import com.zaxxer.hikari.HikariConfig
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import javax.sql.DataSource


@Configuration
class DatabaseConfig {
//    @Value("\${spring.datasource.url}")
//    private val dbUrl: String? = null
//
//    @Bean
//    fun dataSource(): DataSource? {
//        val config = HikariConfig()
//        config.jdbcUrl = dbUrl
//        return HikariDataSource(config)
//    }
}