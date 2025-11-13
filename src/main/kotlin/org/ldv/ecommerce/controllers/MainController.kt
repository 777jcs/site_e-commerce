package org.ldv.ecommerce.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
internal class MainController {
    /**
     * Méthode permettant d'afficher la page d'accueil de l'application.
     * @return le chemin vers le template a partir du dossier ressources/templates (on ne marque pas le .html)
     */
    @GetMapping("/SnkHouse")
    fun home():String
    {
        return "index"
    }

    @GetMapping("/a-propos")
    fun aPropos(): String {
        return "PagesVisiteur/a-propos"
    }

    @GetMapping("/contact")
    fun contact(): String {
        return "PagesVisiteur/contact"
    }

    @GetMapping("/inscription")
    fun inscription(): String {
        return "PagesVisiteur/inscription"
    }

    @GetMapping("/produits")
    fun produits(): String {
        return "PagesVisiteur/produits"
    }

    @GetMapping("/rgpd")
    fun rgpd(): String {
        return "PagesVisiteur/rgpd"
    }
}

