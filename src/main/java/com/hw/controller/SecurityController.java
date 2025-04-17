package com.hw.controller;

import com.hw.model.dto.Security;
import com.hw.service.SecurityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/securities")
public class SecurityController {
    private final SecurityService securityService;

    public SecurityController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @GetMapping("/all")
    public String getAllSecurities(Model model) {
        model.addAttribute("securities", securityService.getAllSecurities());
        return "securities";
    }

    @GetMapping("/new")
    public String showCreateSecurityForm(Model model) {
        model.addAttribute("security", new Security());
        return "security-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteSecurity(@PathVariable Long id) {
        securityService.deleteSecurity(id);
        return "redirect:/securities";
    }
}
