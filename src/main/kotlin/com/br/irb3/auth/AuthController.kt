package com.br.irb3.auth

import com.br.irb3.configuration.JwtHelper
import org.springframework.http.MediaType
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.http.HttpStatus

import org.springframework.web.server.ResponseStatusException

import java.util.stream.Collectors

import org.springframework.security.core.GrantedAuthority

import java.util.HashMap

import org.springframework.security.core.userdetails.UsernameNotFoundException

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class AuthController(
    private val userDetailsService: UserDetailsService,
    private val passwordEncoder: PasswordEncoder,
    private val jwtHelper: JwtHelper
) {
    @PostMapping("/login", consumes = [ MediaType.APPLICATION_JSON_VALUE ])
    fun login(@RequestBody request: LoginRequest): LoginResult {
        val userDetails = try {
            userDetailsService.loadUserByUsername(request.email)
        } catch (e: UsernameNotFoundException) {
            throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found!")
        }

        if (!passwordEncoder.matches(request.password, userDetails.password)) {
            throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated.")
        }

        val claims: MutableMap<String, String?> = HashMap()
        claims["username"] = request.email
        val authorities = userDetails.authorities.stream()
            .map { obj: GrantedAuthority -> obj.authority }
            .collect(Collectors.joining(","))
        claims["authorities"] = authorities
        claims["userId"] =  (userDetails as? UserPrincipal)?.let { it.id }

        val jwt: String = jwtHelper.createJwtForClaims(request.email, claims)
        return LoginResult(token=jwt)
    }
}