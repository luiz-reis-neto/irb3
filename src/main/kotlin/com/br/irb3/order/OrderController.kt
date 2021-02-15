package com.br.irb3.order

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/order")
class OrderController(private val service: OrderService) {
    @GetMapping
    @ResponseBody
    fun getAllOrder() : List<Order> {
        return this.service.getAllOrders()
    }
}