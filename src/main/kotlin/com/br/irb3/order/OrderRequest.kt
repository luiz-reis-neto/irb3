package com.br.irb3.order

import java.time.LocalDate

data class OrderRequest(
    val operacao: Int?,
    val ticket: String?,
    val nomeAcao: String?,
    val quantidade: Int?,
    val precoUnitario: Double?,
    val tipoOperacao: Char?,
    val taxaTbc: Double?,
    val tipoMercado: Char?,
    val tipoAtivo: Char?
)