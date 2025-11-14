package org.ldv.ecommerce.model.dao
import org.ldv.ecommerce.model.entity.Image
import org.springframework.data.jpa.repository.JpaRepository


interface ImageDAO : JpaRepository<Image, Int>