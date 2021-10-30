package com.afrinnov.formation.model;

import com.afrinnov.formation.dispo.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Getter
@NoArgsConstructor
public class CustomerBasket {
    private List<BasketItem> items;

    public CustomerBasket(List<BasketItem> items) {
        this.items = items;
    }

    public void addItem(Product product) {
        Optional<BasketItem> basketItem = items.stream().filter(item -> Objects.equals(item.getReference(), product.getReference()))
                .findFirst();
        if (basketItem.isEmpty()) {
            items.add(new BasketItem(product));
        } else {
            basketItem.get().add();
        }
    }

    public int countItems() {
        return items.size();
    }

    public int totalPrice() {
        return items.stream().map(BasketItem::totalPrice).reduce(Integer::sum).orElse(0);
    }
}
