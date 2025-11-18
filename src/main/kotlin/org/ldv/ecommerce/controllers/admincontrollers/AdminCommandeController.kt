package org.ldv.ecommerce.controllers.admincontrollers

import org.ldv.ecommerce.model.dao.CommandeDAO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/admin/commandes")
class AdminCommandeController(
    private val commandeDAO: CommandeDAO
) {

    // LISTE COMMANDES
    @GetMapping("")
    fun list(model: Model): String {
        model.addAttribute("commandes", commandeDAO.findAll())
        return "commande/list"
    }

    // DETAILS D'UNE COMMANDE
    @GetMapping("/{id}")
    fun details(@PathVariable id: Int, model: Model): String {
        val commande = commandeDAO.findById(id).orElseThrow()
        model.addAttribute("commande", commande)
        return "commande/show"
    }
}