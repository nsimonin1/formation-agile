package com.afrinnov.formation.controller;

import com.afrinnov.formation.controller.service.ProductAddService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ProductAddController {
    private final ProductAddService productAddService;

    @GetMapping("/product-increment")
    public String increment(@RequestParam("product") String productCode,
                            @RequestParam("quantity") int quantity) {
        productAddService.increment(productCode, quantity);
        return "redirect:/";
    }
}
