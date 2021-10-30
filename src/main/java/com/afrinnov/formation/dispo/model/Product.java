package com.afrinnov.formation.dispo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Product {
    private String reference;
    private String title;
    private int price;
    private List<String> descriptions;

}
