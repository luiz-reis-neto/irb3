package com.br.irb3.broker

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("tbirb3corretora")
data class Broker(@Id val id: Int, val codb3: String)