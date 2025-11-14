package org.ldv.ecommerce.model.dao


import org.ldv.ecommerce.model.entity.Utilisateur
import org.springframework.data.jpa.repository.JpaRepository


interface UtilisateurDAO : JpaRepository<Utilisateur, Int>