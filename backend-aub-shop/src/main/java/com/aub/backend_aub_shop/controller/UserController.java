package com.aub.backend_aub_shop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aub.backend_aub_shop.model.User_Model;
import com.aub.backend_aub_shop.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
  @Autowired UserService userService;

    @GetMapping(value = {"","/"})
    public String getAllUsers(Model m){
        List<User_Model> users = userService.findAll(); 
        m.addAttribute("users", users);
        return "UserManagement/user-list";
      
    }

    @GetMapping("/addUser")
    public String addUser(Model m){
        m.addAttribute("user", new User_Model());
        return "UserManagement/add-user";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User_Model userModel){
        userService.create(userModel);
        return "redirect:UserManagement/users";
    }

    @GetMapping("/edit/{id}")
    public String UpdateById(@PathVariable("id") Long id, Model m){
        Optional<User_Model> users = userService.findById(id);
        m.addAttribute("user", users.orElse(new User_Model()));
        return "UserManagement/edit-user";
    }
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("user") User_Model users , Model m){
        User_Model updateUser = userService.update(users, id);
        m.addAttribute("user",updateUser);
        return "redirect:UserManagement/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:UserManagement/users"; // Redirect to staff list after deletion
    }
}
