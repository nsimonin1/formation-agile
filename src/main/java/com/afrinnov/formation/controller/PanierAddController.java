package com.afrinnov.formation.controller;

import com.afrinnov.formation.controller.service.PanierAddService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product-add")
@RequiredArgsConstructor
public class PanierAddController {
    private final PanierAddService panierAddService;
    @GetMapping
    public String addProduct(@RequestParam("product") String productCode) {
        panierAddService.addToBasket(productCode);
        return "redirect:/";
    }
}
