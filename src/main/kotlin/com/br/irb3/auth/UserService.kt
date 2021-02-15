package com.br.irb3.auth

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) : UserDetailsService {
    override fun loadUserByUsername(email: String?): UserDetails {
        return email?.let(userRepository::findByEmail)?.let { UserPrincipal(it) }
            ?: throw UsernameNotFoundException("User not found!")
    }
}