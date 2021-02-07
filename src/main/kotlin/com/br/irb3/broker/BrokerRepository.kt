package com.br.irb3.broker

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BrokerRepository : CrudRepository<Broker, Int> {
    fun findByCodb3(codb3: String):Broker
}