package com.afrinnov.formation.model;

import com.afrinnov.formation.dispo.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BasketItem {
    private Product product;
    private int quantity;

    public BasketItem(Product product) {
        this.product = product;
        quantity = 1;
    }

    public void add() {
        quantity++;
    }

    public void remove() {
        quantity--;
    }

    public String getReference() {
        return product.getReference();
    }

    public Integer totalPrice() {
        return product.getPrice() * quantity;
    }
}
