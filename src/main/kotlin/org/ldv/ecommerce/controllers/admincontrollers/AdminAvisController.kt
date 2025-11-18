package org.ldv.ecommerce.controllers.admincontrollers

import org.ldv.ecommerce.model.dao.AvisDAO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

/**
 * Contrôleur permettant à l'administrateur de gérer les avis.
 * Fonctionnalités :
 * - Afficher la liste de tous les avis
 * - Supprimer un avis
 */
@Controller
@RequestMapping("/admin/avis")  // Toutes les URLs commencent par /admin/avis
class AdminAvisController(
    private val avisDAO: AvisDAO
) {

    /**
     * Page liste des avis
     * URL : /admin/avis
     */
    @GetMapping("")
    fun list(model: Model): String {

        // Récupère tous les avis en BDD
        val avisList = avisDAO.findAll()

        // Envoie la liste à la vue Thymeleaf
        model.addAttribute("avisList", avisList)

        // Correspond à : src/main/resources/templates/avis/list.html
        return "avis/list"
    }

    /**
     * Suppression d'un avis
     * URL : /admin/avis/delete/{id}
     */
    @GetMapping("/delete/{id}")
    fun delete(@PathVariable id: Int): String {

        // Supprime l'avis dans la BDD
        avisDAO.deleteById(id)

        // Redirige vers la liste des avis
        return "redirect:/admin/avis"
    }
}
