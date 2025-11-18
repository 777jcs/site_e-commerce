package org.ldv.ecommerce.controllers.admincontrollers


import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AdminController {

    /**
     * Page d'accueil du back office
     * URL : /admin
     */
    @GetMapping("/admin")
    fun dashboard(): String {
        return "pageAdmin/dashboard"
        // correspond à : templates/pageAdmin/dashboard.html
    }
}