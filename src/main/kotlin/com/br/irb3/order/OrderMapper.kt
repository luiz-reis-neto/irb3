package com.br.irb3.order

import org.springframework.stereotype.Component

@Component
class OrderMapper {
    fun requestToModel(request: OrderRequest): Order {
        return Order(
            id = 0,
            idNota = 0,
            ordemDia = request.dia,
            tipoOperacao = request.tipoOperacao,
            operacao = request.operacao,
            ticket = request.ticket,
            nomeAcao = request.nomeAcao,
            quantidade = request.quantidade,
            precoUnitario = request.precoUnitario,
            taxaTbc = request.taxaTbc,
            tipoMercado = request.tipoMercado,
            tipoAtivo = request.tipoAtivo
        )
    }
}