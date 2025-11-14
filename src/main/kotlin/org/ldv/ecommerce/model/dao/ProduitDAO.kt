package org.ldv.ecommerce.model.dao
import org.ldv.ecommerce.model.entity.Produit
import org.springframework.data.jpa.repository.JpaRepository

interface ProduitDAO : JpaRepository<Produit, Int>