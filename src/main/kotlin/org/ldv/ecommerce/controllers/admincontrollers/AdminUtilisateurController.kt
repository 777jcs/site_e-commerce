package org.ldv.ecommerce.controllers.admincontrollers

import org.ldv.ecommerce.model.dao.UtilisateurDAO
import org.ldv.ecommerce.model.entity.Utilisateur
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

/**
 * Contrôleur permettant à l'administrateur de gérer les utilisateurs.
 * - Afficher la liste des utilisateurs
 * - Ajouter un utilisateur
 * - Modifier un utilisateur
 * - Supprimer un utilisateur
 */
@Controller
@RequestMapping("/admin/utilisateurs") // Tous les chemins commencent par /admin/utilisateurs
class AdminUtilisateurController(
    private val utilisateurDAO: UtilisateurDAO // Injection du DAO pour accéder à la base
) {

    /**
     * Affiche la liste de tous les utilisateurs
     * URL : /admin/utilisateurs
     */
    @GetMapping("")
    fun list(model: Model): String {

        // Récupère tous les utilisateurs dans la BDD
        val utilisateurs = utilisateurDAO.findAll()

        // Envoie les données à la vue (HTML)
        model.addAttribute("utilisateurs", utilisateurs)

        // Renvoie la page HTML située dans templates/utilisateur/list.html
        return "utilisateur/list"
    }

    /**
     * Affiche le formulaire de création d'un utilisateur
     * URL : /admin/utilisateurs/create
     */
    @GetMapping("/create")
    fun createForm(model: Model): String {

        // Création d'un utilisateur vide pour le formulaire
        model.addAttribute("utilisateur", Utilisateur(null, "", "", "", "CLIENT"))

        // Affiche templates/utilisateur/create.html
        return "utilisateur/create"
    }

    /**
     * Traite l'envoi du formulaire de création d'un utilisateur
     */
    @PostMapping("/create")
    fun create(@ModelAttribute utilisateur: Utilisateur): String {

        // Enregistre le nouvel utilisateur dans la BDD
        utilisateurDAO.save(utilisateur)

        // Redirige vers la liste
        return "redirect:/admin/utilisateurs"
    }

    /**
     * Affiche le formulaire d'édition d'un utilisateur existant
     * Exemple : /admin/utilisateurs/edit/3
     */
    @GetMapping("/edit/{id}")
    fun editForm(@PathVariable id: Int, model: Model): String {

        // Récupère l'utilisateur par son ID ou renvoie une erreur s'il n'existe pas
        val utilisateur = utilisateurDAO.findById(id).orElseThrow()

        // Envoie l'utilisateur existant au formulaire
        model.addAttribute("utilisateur", utilisateur)

        // Renvoie le HTML d’édition
        return "utilisateur/edit"
    }

    /**
     * Traite le formulaire d’édition
     */
    @PostMapping("/edit/{id}")
    fun edit(@ModelAttribute utilisateur: Utilisateur): String {

        // Sauvegarde les modifications dans la BDD
        utilisateurDAO.save(utilisateur)

        // Redirection vers la liste
        return "redirect:/admin/utilisateurs"
    }

    /**
     * Supprime un utilisateur via son ID
     * Exemple : /admin/utilisateurs/delete/5
     */
    @GetMapping("/delete/{id}")
    fun delete(@PathVariable id: Int): String {

        // Suppression dans la BDD
        utilisateurDAO.deleteById(id)

        // Retour à la liste
        return "redirect:/admin/utilisateurs"
    }
}