package com.br.irb3.auth

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("tbirb3usuario")
data class User(@Id val id: Int, val username: String?, val email: String, val password: String)
