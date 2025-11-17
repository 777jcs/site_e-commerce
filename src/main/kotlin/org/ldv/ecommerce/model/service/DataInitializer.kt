package org.ldv.ecommerce.model.service

import org.ldv.ecommerce.model.dao.*
import org.ldv.ecommerce.model.entity.*
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataInitializer(
    private val produitDAO: ProduitDAO,
    private val imageDAO: ImageDAO,
    private val avisDAO: AvisDAO,
    private val utilisateurDAO: UtilisateurDAO,
    private val panierDAO: PanierDAO,
    private val commandeDAO: CommandeDAO
) : CommandLineRunner {

    override fun run(vararg args: String?) {

        // Si la base contient déjà des données, on ne fait rien
        if (produitDAO.count() > 0) {
            println(" Données déjà présentes, initialisation ignorée.")
            return
        }

        println(" Injection des données de test...")

        // === UTILISATEURS ===
        val user1 = Utilisateur(
            idUtilisateur = null,
            nom = "Durand",
            email = "durand@example.com",
            motDePasse = "azerty123",
            role = "CLIENT"
        )

        val admin = Utilisateur(
            idUtilisateur = null,
            nom = "Admin",
            email = "admin@example.com",
            motDePasse = "admin",
            role = "ADMIN"
        )

        utilisateurDAO.saveAll(listOf(user1, admin))


        // === PRODUITS ===
        val p1 = Produit(
            idProduit = null,
            nom = "nike air 90",
            marque = "Nike",
            description = "T-shirt confortable 100% coton",
            prix = 19.99f,
            stock = 50
        )

        val p2 = Produit(
            idProduit = null,
            nom = "",
            marque = "Adidas",
            description = "Chaussures légères pour la course",
            prix = 89.99f,
            stock = 20
        )

        produitDAO.saveAll(listOf(p1, p2))


        // === IMAGES ===
        val img1 = Image(
            idImage = null,
            chemin = "images/tshirt_noir.jpg",
            principale = true
        )

        val img2 = Image(
            idImage = null,
            chemin = "images/running.jpg",
            principale = true
        )

        imageDAO.saveAll(listOf(img1, img2))


        // === AVIS ===
        val avis1 = Avis(
            idAvis = null,
            note = 5,
            commentaire = "Excellent produit !",
            dateAvis = "2024-11-01"
        )

        val avis2 = Avis(
            idAvis = null,
            note = 4,
            commentaire = "Bon rapport qualité/prix.",
            dateAvis = "2024-11-10"
        )

        avisDAO.saveAll(listOf(avis1, avis2))


        // === PANIER ===
        val panier = Panier(
            idPanier = null,
            dateCreation = "2024-11-20"
        )

        panierDAO.save(panier)


        // === COMMANDE ===
        val commande = Commande(
            idCommande = null,
            dateCommande = "2024-11-21",
            statut = "EN_COURS",
            total = 109.98f
        )

        commandeDAO.save(commande)

        println(" Données initiales insérées !")
    }
}
