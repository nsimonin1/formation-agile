package com.afrinnov.formation.model;

import com.afrinnov.formation.dispo.model.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;


class CustomerBasketTest {

    @Test
    void addProduct() {
        //Arrange
        CustomerBasket basket = new CustomerBasket(new ArrayList<>());
        Product product = new Product();
        product.setPrice(2000);
        //Act
        basket.addItem(product);

        //Assert
        assertThat(basket.getItems()).hasSize(1);
        assertThat(basket.getItems().get(0).getQuantity()).isEqualTo(1);
        assertThat(basket.totalPrice()).isEqualTo(2000);
    }

    @Test
    void addExistingProduct() {
        //Arrange
        Product item = new Product();
        item.setReference("0006");
        item.setPrice(2000);
        CustomerBasket basket = new CustomerBasket(singletonList(new BasketItem(item)));
        //Act
        Product product = new Product();
        product.setReference("0006");
        basket.addItem(product);

        //Assert
        assertThat(basket.getItems()).hasSize(1);
        assertThat(basket.getItems().get(0).getQuantity()).isEqualTo(2);
        assertThat(basket.totalPrice()).isEqualTo(4000);
    }
}