package com.br.irb3.invoice

import com.br.irb3.order.OrderRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class InvoiceService(val orderRepository: OrderRepository, val repository: InvoiceRepository) {
    //@Transactional
    fun createInvoice(invoice: Invoice) {
        val invoiceId = repository.save(invoice).id
        invoice.orders.forEach {
            orderRepository.save(it.copy(idNota = invoiceId))
        }
    }
}