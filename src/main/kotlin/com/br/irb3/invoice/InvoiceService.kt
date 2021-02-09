package com.br.irb3.invoice

import com.br.irb3.broker.BrokerRepository
import com.br.irb3.order.OrderRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class InvoiceService(
    private val orderRepository: OrderRepository,
    private val repository: InvoiceRepository,
    private val brokerRepository: BrokerRepository,
    private val invoiceMapper: InvoiceMapper
    ) {
    //@Transactional
    fun createInvoice(invoice: Invoice, brokerCode: String) {
        val broker = brokerRepository.findByCodb3(brokerCode)
        val entity = invoiceMapper.modelToEntity(invoice).copy(idCorretora = broker.id)
        val invoiceId = repository.save(entity).id
        invoice.orders.forEach {
            orderRepository.save(it.copy(idNota = invoiceId, ordemDia = invoice.dataOperacao))
        }
    }
}