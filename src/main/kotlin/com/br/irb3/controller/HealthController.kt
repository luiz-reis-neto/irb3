package com.br.irb3.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HealthController {
    @GetMapping("/health")
    @ResponseBody
    fun health(): String = "Service healthy"
}