package com.br.irb3.order

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate

@Table("tbirb3ordens")
data class Order(@Id val id: Int? = null,
                 val idNota: Int? = null,
                 val ordemDia: LocalDate? = null,
                 val operacao: Char? = null,
                 val ticket: String? = null,
                 val nomeAcao: String? = null,
                 val quantidade: Int? = null,
                 val precoUnitario: Double? = null,
                 val tipoOperacao: Char? = null,
                 val taxaTbc: Double? = null,
                 val tipoMercado: Char? = null,
                 val tipoAtivo: Char? = null,
)
