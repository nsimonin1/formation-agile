package com.afrinnov.formation.controller.service;

import com.afrinnov.formation.model.CustomerBasket;
import com.afrinnov.formation.model.OrderModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class PanierService {
    private final HttpServletRequest request;
    private final CurrentOrderModelService currentOrderModelService;


    public boolean isConnected() {
        return Objects.nonNull(request.getSession(false));
    }

    public OrderModel currentOrderModel() {
        return currentOrderModelService.getOrderModel();
    }

    public CustomerBasket getBasket() {
        return currentOrderModelService.getOrderModel().getBasket();
    }
}
