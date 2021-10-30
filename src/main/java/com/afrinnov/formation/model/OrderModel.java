package com.afrinnov.formation.model;

import com.afrinnov.formation.dispo.model.Product;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "with",toBuilder = true)
public class OrderModel {
    private String email;
    private CustomerBasket basket;

    public void addProduct(Product product) {
        basket.addItem(product);
    }

    public int countItems() {
        return basket.countItems();
    }
}
