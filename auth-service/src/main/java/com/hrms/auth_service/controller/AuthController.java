package com.hrms.auth_service.controller;
import com.hrms.auth_service.entity.User;
import com.hrms.auth_service.service.AuthService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return authService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> body) {
        return authService.login(body.get("username"), body.get("password"));
    }
}
