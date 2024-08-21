package com.aub.backend_aub_shop.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aub.backend_aub_shop.dto.UserDTO;
import com.aub.backend_aub_shop.model.UserModel;
import com.aub.backend_aub_shop.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = {"", "/users"})
//set tr role Admin
@PreAuthorize("hasRole('Admin')")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"", "/"})
    public String getAllUser(
        @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
        @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
        @RequestParam(name = "username", required = false, defaultValue = "") String username,
        Model model
    ) {
        Page<UserDTO> users = userService.findAll(username, pageNumber, pageSize);

        model.addAttribute("users", users.getContent());
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("username", username);
        model.addAttribute("totalPages", users.getTotalPages());
        model.addAttribute("currentPage", pageNumber);

        return "UserManagement/user-list";
    }    
    
    @GetMapping("/withoutpagination")
    public String getAllUsers(Model m){
        List<UserModel> users = userService.findAll(); 
        m.addAttribute("users", users);
        return "UserManagement/user-list";
    }

    @GetMapping("/addUser")
    public String addUser(Model m)
    {
        m.addAttribute("user", new UserModel());
        return "UserManagement/add-user";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") UserModel userModel, HttpServletRequest httpRequest) 
    {
        try{
            userService.create(httpRequest, userModel);
            return "redirect:/users";
        }
        catch(IllegalArgumentException e){
            return "redirect:/users/error";   
        }
    }

    @GetMapping("/edit/{id}")
    public String UpdateById(@PathVariable("id") Long id, Model m){
        Optional<UserModel> users = userService.findById(id);
        m.addAttribute("user", users.orElse(new UserModel()));
        return "UserManagement/edit-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("user") UserModel users, Model m, HttpServletRequest httpRequest) {
        try {
            UserModel updateUser = userService.update(users, id, httpRequest);
            m.addAttribute("user", updateUser);
            return "redirect:/users";
        } catch (IllegalArgumentException e) {
            // Handle specific exceptions like IllegalArgumentException
            m.addAttribute("error", e.getMessage());
            return "redirect:/users/error";
        } catch (Exception e) {
            // Handle any other unexpected exceptions
            m.addAttribute("error", "An unexpected error occurred.");
            return "redirect:/users/error";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        Logger logger = LoggerFactory.getLogger(UserService.class);
        logger.info("User with Id" + id);
        return "redirect:/users"; 
    }

    @GetMapping("/error")
    public String errorPage(){
        return "error/page-404";
    }

    @PostMapping("/change-password")
    public String changePassword(@RequestParam("oldPassword") String oldPassword,
                                @RequestParam("newPassword") String newPassword,
                                @RequestParam("cfPassword") String confirmPassword,
                                Model model) {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        try {
            userService.changePassword(username, oldPassword, newPassword, confirmPassword);
            model.addAttribute("successMessage", "Password changed successfully.");
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
        return "redirect:/"; // Redirects to the homepage or current page
    }
}
