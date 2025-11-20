package org.ldv.ecommerce.service

import org.ldv.ecommerce.model.dao.UtilisateurDAO
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class MyUserDetailsService(
    private val utilisateurDAO: UtilisateurDAO
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {

        // On va chercher l'utilisateur via son email
        val utilisateur = utilisateurDAO.findByEmail(username)
            ?: throw UsernameNotFoundException("Utilisateur introuvable : $username")

        // On récupère le nom du rôle (ADMIN / CLIENT)
        val role = utilisateur.role?.nom
            ?: throw UsernameNotFoundException("Rôle introuvable pour cet utilisateur")

        // On construit l'utilisateur de Spring Security
        return User.withUsername(utilisateur.email)
            .password(utilisateur.mdp)   // mot de passe hashé en BCRYPT
            .roles(role)          // "ADMIN" => Spring devient "ROLE_ADMIN"
            .build()
    }
}
