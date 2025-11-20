package org.ldv.ecommerce.model.dao


import org.ldv.ecommerce.model.entity.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleDAO : JpaRepository<Role, Long> {

    // Permettra plus tard de récupérer un rôle par son nom si besoin
    fun findByNom(nom: String): Role?
}
