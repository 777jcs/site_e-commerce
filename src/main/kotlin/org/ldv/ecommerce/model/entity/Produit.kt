package org.ldv.ecommerce.model.entity

import jakarta.persistence.*

@Entity
class Produit(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var idProduit: Int?,

    @Column(nullable = false)
    var nom: String,

    @Column(nullable = false)
    var marque: String,

    @Column(nullable = false)
    var description: String,

    @Column(nullable = false)
    var prix: Float,

    @Column(nullable = false)
    var stock: Int
)
