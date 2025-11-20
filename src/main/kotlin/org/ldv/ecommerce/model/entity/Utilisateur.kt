package org.ldv.ecommerce.model.entity

import jakarta.persistence.*

@Entity
class Utilisateur(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var idUtilisateur: Long? = null,

    @Column(nullable = false)
    var nom: String,

    @Column(nullable = false, unique = true)
    var email: String,

    @Column(nullable = false)
    var mdp: String,

    @ManyToOne
    @JoinColumn(name = "role_id")
    var role: Role? = null


)
