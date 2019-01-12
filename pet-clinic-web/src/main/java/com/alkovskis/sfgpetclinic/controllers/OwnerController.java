package com.alkovskis.sfgpetclinic.controllers;

import com.alkovskis.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OwnerController {

   private  OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping(value = {"/owners", "/owners/index", "/owners/index.html"})
    public String owners(Model model) {

        model.addAttribute("owners", ownerService.findAll());

        return "owners/index";
    }
}
