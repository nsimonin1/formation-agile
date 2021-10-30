package com.afrinnov.formation.controller;

import com.afrinnov.formation.controller.service.LogoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
@RequiredArgsConstructor
public class LogoutController {
    private final LogoutService logoutService;

    @GetMapping
    public String connect() {
        logoutService.logout();
        return "redirect:/";
    }
}
