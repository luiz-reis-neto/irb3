package com.br.irb3.invoice

import com.br.irb3.order.OrderRequest
import java.time.LocalDate

data class InvoiceRequest(
    val numeroNota: String,
    val dataOperacao: LocalDate,
    val emolumentos: Double,
    val corretagem: Double,
    val liquidacao: Double,
    val registro: Double,
    val iss: Double,
    val irr: Double,
    val outrasTaxas: Double,
    val taxaoper: Double,
    val execucao: Double,
    val taxaTermoOpcao: Double,
    val taxaCustodia: Double,
    val imposto: Double,
    val orders: List<OrderRequest>
)