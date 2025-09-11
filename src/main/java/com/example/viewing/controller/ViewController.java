package com.example.viewing.controller;

import com.example.viewing.service.StorageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    private final StorageService storageService;

    public ViewController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/menu";
    }

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

    @GetMapping("/ar-view")
    public String arView() {
        return "ar-view";
    }

    @GetMapping("/admin")
    public String admin(@RequestParam(name = "password", required = false) String password, Model model) {
        boolean authenticated = password != null && storageService.validatePassword(password);
        model.addAttribute("authenticated", authenticated);
        return "admin";
    }
}