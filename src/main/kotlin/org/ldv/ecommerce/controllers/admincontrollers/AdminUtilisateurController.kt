package org.ldv.ecommerce.controllers.admincontrollers

import org.ldv.ecommerce.model.dao.UtilisateurDAO
import org.ldv.ecommerce.model.entity.Utilisateur
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/admin/utilisateurs")
class AdminUtilisateurController(
    private val utilisateurDAO: UtilisateurDAO
) {

    @GetMapping("")
    fun list(model: Model): String {

        val utilisateurs = utilisateurDAO.findAll()
        model.addAttribute("utilisateurs", utilisateurs)

        return "utilisateur/list"
    }

    @GetMapping("/create")
    fun createForm(model: Model): String {

        // Création d’un utilisateur vide
        model.addAttribute("utilisateur", Utilisateur(
            idUtilisateur = null,
            nom = "",
            email = "",
            mdp = "",
            role = null // ⚠️ rôle à sélectionner plus tard
        ))

        return "utilisateur/create"
    }

    @PostMapping("/create")
    fun create(@ModelAttribute utilisateur: Utilisateur): String {

        utilisateurDAO.save(utilisateur)
        return "redirect:/admin/utilisateurs"
    }

    @GetMapping("/edit/{id}")
    fun editForm(@PathVariable id: Int, model: Model): String {

        val utilisateur = utilisateurDAO.findById(id).orElseThrow()
        model.addAttribute("utilisateur", utilisateur)

        return "utilisateur/edit"
    }

    @PostMapping("/edit/{id}")
    fun edit(@ModelAttribute utilisateur: Utilisateur): String {

        utilisateurDAO.save(utilisateur)
        return "redirect:/admin/utilisateurs"
    }

    @GetMapping("/delete/{id}")
    fun delete(@PathVariable id: Int): String {

        utilisateurDAO.deleteById(id)
        return "redirect:/admin/utilisateurs"
    }
}
