package com.alkovskis.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OwnerController {

    @GetMapping(value = {"/owners","/owners/index","/owners/index.html"})
    public String owners(Model model){

        return "owners/index";
    }
}
