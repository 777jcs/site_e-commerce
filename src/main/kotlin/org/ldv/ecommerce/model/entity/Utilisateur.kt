package org.ldv.ecommerce.model.entity


import jakarta.persistence.*
@Entity
class Utilisateur (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var idUtilisateur: Int?,

    @Column(nullable = false)
    var nom: String,

    @Column(nullable = false)
    var email: String,

    @Column(nullable = false)
    var motDePasse: String,

    @Column(nullable = false)
    var role: String
)