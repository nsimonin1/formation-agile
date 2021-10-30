package com.afrinnov.formation.controller.service;

import com.afrinnov.formation.dispo.ProductAvailableService;
import com.afrinnov.formation.dispo.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PanierAddService {
    private final ProductAvailableService productAvailableService;
    private final CurrentOrderModelService currentOrderModelService;

    public void addToBasket(String productCode) {
        Optional<Product> product = productAvailableService.findProduct(productCode);
        product.ifPresent(currentOrderModelService::updateBasket);
    }
}
