package org.ldv.ecommerce.controllers.admincontrollers

import org.ldv.ecommerce.model.dao.ProduitDAO
import org.ldv.ecommerce.model.entity.Produit
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/admin/produits")   // URL de base = /admin/produits
class AdminProduitsController(
    private val produitDAO: ProduitDAO
) {

    /**
     * LISTE DES PRODUITS
     * URL : /admin/produits/list
     */
    @GetMapping("/list")
    fun list(model: Model): String {

        // On envoie la liste des produits
        model.addAttribute("produits", produitDAO.findAll())

        // templates/produit/list.html
        return "produit/list"
    }


    /**
     * FORMULAIRE DE CREATION
     */
    @GetMapping("/create")
    fun createForm(model: Model): String {

        // Produit vide pour le formulaire
        model.addAttribute(
            "produit",
            Produit(
                idProduit = null,
                nom = "",
                marque = "",
                description = "",
                prix = 0f,
                stock = 0
            )
        )

        return "produit/create"
    }


    /**
     * TRAITEMENT DE CREATION
     */
    @PostMapping("/create")
    fun create(@ModelAttribute produit: Produit): String {

        produitDAO.save(produit)

        return "redirect:/admin/produits/list"
    }


    /**
     * FORMULAIRE D'ÉDITION
     */
    @GetMapping("/edit/{id}")
    fun editForm(@PathVariable id: Int, model: Model): String {

        val produit = produitDAO.findById(id).orElseThrow()

        model.addAttribute("produit", produit)

        return "produit/edit"
    }


    /**
     * TRAITEMENT DE MODIFICATION
     */
    @PostMapping("/edit/{id}")
    fun edit(@ModelAttribute produit: Produit): String {

        produitDAO.save(produit)

        return "redirect:/admin/produits/list"
    }


    /**
     * SUPPRESSION
     */
    @GetMapping("/delete/{id}")
    fun delete(@PathVariable id: Int): String {

        produitDAO.deleteById(id)

        return "redirect:/admin/produits/list"
    }


    /**
     * PAGE DE DETAIL
     */
    @GetMapping("/show/{id}")
    fun show(@PathVariable id: Int, model: Model): String {

        val produit = produitDAO.findById(id).orElseThrow()

        model.addAttribute("produit", produit)

        return "produit/show"
    }
}
