package com.afrinnov.formation.controller.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class LogoutService {
    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public void logout() {
        Arrays.stream(request.getCookies()).forEach(cookie -> {
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        });

    }
}
