package com.afrinnov.formation.controller.service;

import com.afrinnov.formation.dispo.ProductAvailableService;
import com.afrinnov.formation.dispo.model.Product;
import com.afrinnov.formation.model.OrderModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class HomeService {
    private final HttpServletRequest request;
    private final CurrentOrderModelService currentOrderModelService;
    private final ProductAvailableService productAvailableService;

    public boolean isConnected() {
        return Objects.nonNull(request.getSession(false));
    }

    public OrderModel currentOrderModel() {
        return currentOrderModelService.getOrderModel();
    }

    public List<Product> getProducts() {
        return productAvailableService.avails();
    }
}
