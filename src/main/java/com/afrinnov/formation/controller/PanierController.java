package com.afrinnov.formation.controller;

import com.afrinnov.formation.controller.service.PanierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/panier")
@RequiredArgsConstructor
public class PanierController {
    private final PanierService panierService;

    @GetMapping
    public ModelAndView panier() {
        if (!panierService.isConnected()) {
            return new ModelAndView("redirect:/login");
        }
        ModelAndView mav = new ModelAndView("panier");
        mav.addObject("orderModel", panierService.currentOrderModel());
        mav.addObject("basket", panierService.getBasket());
        return mav;
    }
}
