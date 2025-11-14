package org.ldv.ecommerce.model.entity


import jakarta.persistence.*

@Entity
class Commande(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var idCommande: Int?,

    @Column(nullable = false)
    var dateCommande: String,

    @Column(nullable = false)
    var statut: String,

    @Column(nullable = false)
    var total: Float
)