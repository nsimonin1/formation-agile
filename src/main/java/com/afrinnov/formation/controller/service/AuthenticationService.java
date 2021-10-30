package com.afrinnov.formation.controller.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationService {
    private final CurrentOrderModelService currentOrderModelService;

    public void authenticate(String username) {
        currentOrderModelService.initOrder(username);
    }
}
