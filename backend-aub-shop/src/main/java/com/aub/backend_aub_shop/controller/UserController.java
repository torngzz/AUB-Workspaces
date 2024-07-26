package com.aub.backend_aub_shop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aub.backend_aub_shop.model.UserModel;
import com.aub.backend_aub_shop.service.UserService;

@Controller
@RequestMapping(value = {"", "/users"})
public class UserController {
  @Autowired UserService userService;

    // @GetMapping(value = {"","/"})
    // public String getAllUserx(
    //     @RequestParam(name = "pageNumber", defaultValue = "0" int pageNumber),
    //     @RequestParam(name = "pageSize", defaultValue = "10" int pageSize)
    // ){
    //     Page<UserModel> users = userService.findAll(pageNumber, pageSize); 
    //     addAttribute("users", users);
    //     return "UserManagement/user-list";
    // }


    @GetMapping(value = {"", "/"})
    public String getAllUser(
        @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
        @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
        Model model
    ) {
        Page<UserModel> users = userService.findAll(pageNumber, pageSize); 
        model.addAttribute("users", users);
        return "UserManagement/user-list";
    }

    @GetMapping("/withoutpagination")
    public String getAllUsers(Model m){
        List<UserModel> users = userService.findAll(); 
        m.addAttribute("users", users);
        return "UserManagement/user-list";
    }

    @GetMapping("/addUser")
    public String addUser(Model m){
        m.addAttribute("user", new UserModel());
        return "UserManagement/add-user";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") UserModel userModel) {
        userService.create(userModel);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String UpdateById(@PathVariable("id") Long id, Model m){
        Optional<UserModel> users = userService.findById(id);
        m.addAttribute("user", users.orElse(new UserModel()));
        return "UserManagement/edit-user";
    }
    
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("user") UserModel users , Model m){
        UserModel updateUser = userService.update(users, id);
        m.addAttribute("user",updateUser);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/users"; 
    }
}
