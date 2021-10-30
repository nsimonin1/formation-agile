package com.afrinnov.formation.dispo;

import com.afrinnov.formation.dispo.model.Product;
import com.afrinnov.formation.dispo.model.Products;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
public class ProductAvailableService {
    private final ObjectMapper objectMapper;
    @Value("classpath:data/product-avails.json")
    private Resource resourceProductAvails;
    private final Map<String, Product> productStore = new ConcurrentHashMap<>(new HashMap<>());

    public List<Product> avails() {
        try {
            Products products = objectMapper.readValue(resourceProductAvails.getInputStream(), Products.class);
            products.getProducts().forEach(product -> productStore.put(product.getReference(), product));
            return products.getProducts();
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    public Optional<Product> findProduct(String productCode) {
        return Optional.ofNullable(productStore.get(productCode));
    }
}
