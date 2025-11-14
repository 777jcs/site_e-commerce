package org.ldv.ecommerce.model.dao
import org.ldv.ecommerce.model.entity.Avis
import org.springframework.data.jpa.repository.JpaRepository

interface AvisDAO : JpaRepository<Avis, Int>