package com.br.irb3.order

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("tbirb3ordens")
data class Order(@Id val id: Int,
                 val idNota: Int,
                 val ordemDia: LocalDateTime,
                 val operacao: Int,
                 val ticket: String,
                 val nomeAcao: String,
                 val quantidade: Int,
                 val precoUnitario: Double,
                 val tipoOperacao: Char,
                 val taxaTbc: Double,
                 val tipoMercado: Char,
                 val tipoAtivo: Char,
)
