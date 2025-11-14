package org.ldv.ecommerce.model.dao

import org.ldv.ecommerce.model.entity.Commande
import org.springframework.data.jpa.repository.JpaRepository


interface CommandeDAO : JpaRepository<Commande, Int>