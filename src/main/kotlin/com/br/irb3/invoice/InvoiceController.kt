package com.br.irb3.invoice

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/invoice")
class InvoiceController(val service: InvoiceService, val mapper: InvoiceMapper) {
    @PostMapping
    fun createInvoice(@RequestBody request: InvoiceRequest): ResponseEntity<Any>  {
        val invoice = mapper.requestToModel(request)
        service.createInvoice(invoice, request.codigoCorretora)
        return ResponseEntity.ok().build()
    }
}