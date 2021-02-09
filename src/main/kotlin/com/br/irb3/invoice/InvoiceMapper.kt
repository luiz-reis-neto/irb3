package com.br.irb3.invoice

import com.br.irb3.order.OrderMapper
import org.springframework.stereotype.Component

@Component
class InvoiceMapper(private val orderMapper: OrderMapper) {
    fun requestToModel(request: InvoiceRequest): Invoice {
        return Invoice(
            numeroNota = request.numeroNota,
            dataOperacao = request.dataOperacao,
            emolumentos = request.emolumentos,
            corretagem = request.corretagem,
            liquidacao = request.liquidacao,
            registro = request.registro,
            iss = request.iss,
            outrasTaxas = request.outrasTaxas,
            taxaOperacao = request.taxaOperacao,
            execucao = request.execucao,
            taxaTermoOpcao = request.taxaTermoOpcao,
            taxaCustodia = request.taxaCustodia,
            imposto = request.imposto,
            orders = request.orders.map(orderMapper::requestToModel)
        )
    }

    fun modelToEntity(model: Invoice): InvoiceEntity {
        return InvoiceEntity(
            numeroNota = model.numeroNota,
            dataOperacao = model.dataOperacao,
            emolumentos = model.emolumentos,
            corretagem = model.corretagem,
            liquidacao = model.liquidacao,
            registro = model.registro,
            iss = model.iss,
            outrasTaxas = model.outrasTaxas,
            taxaOperacao = model.taxaOperacao,
            execucao = model.execucao,
            taxaTermoOpcao = model.taxaTermoOpcao,
            taxaCustodia = model.taxaCustodia,
            imposto = model.imposto,
        )
    }
}