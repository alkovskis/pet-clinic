package com.alkovskis.sfgpetclinic.controllers;

import com.alkovskis.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping(value = {"/vets", "/vets/index", "vets/index.html"})
    public String vets(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";

    }
}
