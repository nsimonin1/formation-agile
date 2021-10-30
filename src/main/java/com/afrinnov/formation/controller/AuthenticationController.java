package com.afrinnov.formation.controller;

import com.afrinnov.formation.controller.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/connect")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @GetMapping
    public String connect(@RequestParam("username") String username) {
        authenticationService.authenticate(username);
        return "redirect:/";
    }
}
