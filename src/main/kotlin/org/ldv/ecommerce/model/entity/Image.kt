package org.ldv.ecommerce.model.entity


import jakarta.persistence.*

@Entity
class Image(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var idImage: Int?,

    @Column(nullable = false)
    var chemin: String,

    @Column(nullable = false)
    var principale: Boolean
)