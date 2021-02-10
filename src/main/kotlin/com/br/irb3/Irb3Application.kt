package com.br.irb3

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.config.annotation.CorsRegistry

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer




@SpringBootApplication
class Irb3Application

fun main(args: Array<String>) {
	runApplication<Irb3Application>(*args)
}

@Bean
fun corsConfigurer(): WebMvcConfigurer? {
	return object : WebMvcConfigurer {
		override fun addCorsMappings(registry: CorsRegistry) {
			registry.addMapping("/**").allowedOrigins("*")
		}
	}
}