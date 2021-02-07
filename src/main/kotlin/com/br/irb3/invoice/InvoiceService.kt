package com.br.irb3.invoice

import com.br.irb3.broker.BrokerRepository
import com.br.irb3.order.OrderRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class InvoiceService(val orderRepository: OrderRepository, val repository: InvoiceRepository, val brokerRepository: BrokerRepository) {
    //@Transactional
    fun createInvoice(invoice: Invoice, brokerCode: String) {
        val broker = brokerRepository.findByCodb3(brokerCode)
        val invoiceId = repository.save(invoice.copy(idCorretora = broker.id)).id
        invoice.orders.forEach {
            orderRepository.save(it.copy(idNota = invoiceId, ordemDia = invoice.dataOperacao))
        }
    }
}