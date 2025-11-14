package org.ldv.ecommerce.model.entity


import jakarta.persistence.*

@Entity
class Panier(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var idPanier: Int?,

    @Column(nullable = false)
    var dateCreation: String
)