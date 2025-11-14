package org.ldv.ecommerce.model.dao
import org.ldv.ecommerce.model.entity.Panier
import org.springframework.data.jpa.repository.JpaRepository

interface PanierDAO : JpaRepository<Panier, Int>