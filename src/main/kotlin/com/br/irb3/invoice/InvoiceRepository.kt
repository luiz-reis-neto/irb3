package com.br.irb3.invoice

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface InvoiceRepository : CrudRepository<InvoiceEntity, Int>