package com.hw.controller;



import com.hw.model.dto.User;
import com.hw.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/new")
    public String showCreateUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users/list";
    }

    @GetMapping("/list")
    public String listUsers(Model model) {
        var users = userService.findAllUsers();
        if (users.isEmpty()) {
            model.addAttribute("message", "Пользователей нет в базе данных.");
        } else {
            model.addAttribute("users", users);
        }
        return "user-list"; // Имя шаблона HTML
    }
}



