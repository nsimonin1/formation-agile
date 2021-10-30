package com.afrinnov.formation.controller.service;

import com.afrinnov.formation.dispo.model.Product;
import com.afrinnov.formation.error.AfrinnovAuthenticationException;
import com.afrinnov.formation.model.CustomerBasket;
import com.afrinnov.formation.model.OrderModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CurrentOrderModelService {
    public static final String CURRENT_ORDER = "currentOrder";
    private final HttpServletRequest request;

    public void initOrder(String email) {
        HttpSession session = request.getSession();
        OrderModel orderModel = OrderModel.builder()
                .withEmail(email)
                .withBasket(new CustomerBasket(new ArrayList<>()))
                .build();
        session.setAttribute(CURRENT_ORDER, orderModel);
    }

    public OrderModel getOrderModel() {
        HttpSession session = getCurrentSession();
        return ((OrderModel) session.getAttribute(CURRENT_ORDER)).toBuilder().build();
    }

    public void updateBasket(Product product) {
        HttpSession session = getCurrentSession();
        OrderModel orderModel = ((OrderModel) session.getAttribute(CURRENT_ORDER)).toBuilder().build();
        orderModel.addProduct(product);
        session.setAttribute(CURRENT_ORDER, orderModel);
    }

    private HttpSession getCurrentSession() {
        return Optional.ofNullable(request.getSession(false)).orElseThrow(AfrinnovAuthenticationException::new);
    }
}
