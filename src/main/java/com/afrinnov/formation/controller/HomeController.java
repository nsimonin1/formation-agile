package com.afrinnov.formation.controller;

import com.afrinnov.formation.controller.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {
    private final HomeService homeService;

    @GetMapping
    public ModelAndView home() {
        if (!homeService.isConnected()) {
            return new ModelAndView("redirect:/login");
        }
        ModelAndView mav = new ModelAndView("home-page");
        mav.addObject("orderModel", homeService.currentOrderModel());
        mav.addObject("products", homeService.getProducts());
        return mav;
    }
}
