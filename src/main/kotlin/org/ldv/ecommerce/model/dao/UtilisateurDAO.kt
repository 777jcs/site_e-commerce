package org.ldv.ecommerce.model.dao


import org.ldv.ecommerce.model.entity.Utilisateur
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query


interface UtilisateurDAO : JpaRepository<Utilisateur, Int>{


    @Query("select u from Utilisateur u where u.email = ?1")
    fun findByEmail(email: String): Utilisateur

}
