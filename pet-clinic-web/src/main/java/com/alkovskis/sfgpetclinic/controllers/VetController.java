package com.alkovskis.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VetController {


    @GetMapping(value = {"/vets","/vets/index","vets/index.html"})
    public String vets(Model model) {
//        model.addAttribute("vets", );
        return "vets/index";

    }
}
