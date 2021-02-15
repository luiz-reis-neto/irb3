package com.br.irb3.configuration

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTCreator
import com.auth0.jwt.algorithms.Algorithm
import org.springframework.stereotype.Component

import java.time.Instant

import java.security.interfaces.RSAPublicKey

import java.security.interfaces.RSAPrivateKey
import java.util.*


@Component
class JwtHelper(private val privateKey: RSAPrivateKey, private val publicKey: RSAPublicKey) {
    fun createJwtForClaims(subject: String?, claims: Map<String, String?>): String {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = Instant.now().toEpochMilli()
        calendar.add(Calendar.DATE, 1)
        val jwtBuilder: JWTCreator.Builder = JWT.create().withSubject(subject)

        // Add claims
        claims.forEach { (name: String, value: String?) ->
            jwtBuilder.withClaim(
                name,
                value
            )
        }

        // Add expiredAt and etc
        return jwtBuilder
            .withNotBefore(Date())
            .withExpiresAt(calendar.time)
            .sign(Algorithm.RSA256(publicKey, privateKey))
    }
}