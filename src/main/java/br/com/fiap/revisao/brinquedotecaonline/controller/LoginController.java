package br.com.fiap.revisao.brinquedotecaonline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/api/index")
    public String index() {
        return "index";
    }

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/api/index";
    }
}
