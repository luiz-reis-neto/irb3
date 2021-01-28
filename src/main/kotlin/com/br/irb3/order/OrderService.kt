package com.br.irb3.order

import org.springframework.stereotype.Service

@Service
class OrderService(private val repository: OrderRepository) {
    fun getAllOrders(): List<Order> {
        return this.repository.findAll().toList()
    }
}