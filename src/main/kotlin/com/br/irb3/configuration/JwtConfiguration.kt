package com.br.irb3.configuration

import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder
import java.security.interfaces.RSAPublicKey
import org.springframework.security.oauth2.jwt.JwtDecoder
import java.security.KeyStoreException
import java.security.PublicKey
import java.security.KeyStore
import java.security.NoSuchAlgorithmException
import java.security.UnrecoverableKeyException
import java.security.interfaces.RSAPrivateKey
import java.io.IOException
import java.security.Key
import java.security.cert.Certificate
import java.security.cert.CertificateException

private val logger = KotlinLogging.logger {}

@Component
class JwtConfiguration {
    @Value("\${app.security.jwt.keystore-location}")
    private val keyStorePath: String? = null

    @Value("\${app.security.jwt.keystore-password}")
    private val keyStorePassword: String? = null

    @Value("\${app.security.jwt.key-alias}")
    private val keyAlias: String? = null

    @Value("\${app.security.jwt.private-key-passphrase}")
    private val privateKeyPassphrase: String? = null

    @Bean
    fun keyStore(): KeyStore? {
        try {
            val keyStore = KeyStore.getInstance(KeyStore.getDefaultType())
            val resourceAsStream = Thread.currentThread().contextClassLoader.getResourceAsStream(keyStorePath)
            keyStore.load(resourceAsStream, keyStorePassword!!.toCharArray())
            return keyStore
        } catch (e: IOException) {
            logger.error(e) {"Unable to load keystore: $keyStorePath" }
        } catch (e: CertificateException) {
            logger.error(e) {"Unable to load keystore: $keyStorePath" }
        } catch (e: NoSuchAlgorithmException) {
            logger.error(e) {"Unable to load keystore: $keyStorePath" }
        } catch (e: KeyStoreException) {
            logger.error(e) {"Unable to load keystore: $keyStorePath" }
        }
        throw IllegalArgumentException("Unable to load keystore")
    }

    @Bean
    fun jwtSigningKey(keyStore: KeyStore): RSAPrivateKey? {
        try {
            val key: Key = keyStore.getKey(keyAlias, privateKeyPassphrase!!.toCharArray())
            if (key is RSAPrivateKey) {
                return key
            }
        } catch (e: UnrecoverableKeyException) {
            logger.error(e) {"Unable to load private key from keystore: $keyStorePath" }
        } catch (e: NoSuchAlgorithmException) {
            logger.error(e) {"Unable to load private key from keystore: $keyStorePath" }
        } catch (e: KeyStoreException) {
            logger.error(e) {"Unable to load private key from keystore: $keyStorePath" }
        }
        throw IllegalArgumentException("Unable to load private key")
    }

    @Bean
    fun jwtValidationKey(keyStore: KeyStore): RSAPublicKey? {
        try {
            val certificate: Certificate = keyStore.getCertificate(keyAlias)
            val publicKey: PublicKey = certificate.publicKey
            if (publicKey is RSAPublicKey) {
                return publicKey
            }
        } catch (e: KeyStoreException) {
            logger.error(e) {"Unable to load private key from keystore: $keyStorePath" }
        }
        throw IllegalArgumentException("Unable to load RSA public key")
    }

    @Bean
    fun jwtDecoder(rsaPublicKey: RSAPublicKey?): JwtDecoder? {
        return NimbusJwtDecoder.withPublicKey(rsaPublicKey).build()
    }
}