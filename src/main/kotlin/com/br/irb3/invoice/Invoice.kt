package com.br.irb3.invoice

import com.br.irb3.order.Order
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate

@Table("tbirb3nota")
data class Invoice(@Id val id: Int? = null,
                   val idCorretora: Int? = null,
                   val numeroNota: String? = null,
                   val dataOperacao: LocalDate? = null,
                   val emolumentos: Double? = null,
                   val corretagem: Double? = null,
                   val liquidacao: Double? = null,
                   val registro: Double? = null,
                   val iss: Double? = null,
                   val outrasTaxas: Double? = null,
                   val taxaOperacao: Double? = null,
                   val execucao: Double? = null,
                   val taxaTermoOpcao: Double? = null,
                   val taxaCustodia: Double? = null,
                   val imposto: Double? = null,
                   val orders: List<Order> = listOf()
)