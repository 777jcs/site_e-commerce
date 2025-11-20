package org.ldv.ecommerce.model.entity

import jakarta.persistence.*

@Entity
class Role(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long? = null,

    @Column(nullable = false, unique = true)
    var nom: String, // ex : "ADMIN" ou "CLIENT"

    @OneToMany(mappedBy = "role", cascade = [CascadeType.ALL], orphanRemoval = false)
    var utilisateurs: MutableList<Utilisateur> = mutableListOf()
)
