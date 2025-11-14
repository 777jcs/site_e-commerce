package org.ldv.ecommerce.model.entity


import jakarta.persistence.*

@Entity
class Avis(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var idAvis: Int?,

    @Column(nullable = false)
    var note: Int,

    @Column(nullable = false)
    var commentaire: String,

    @Column(nullable = false)
    var dateAvis: String
)