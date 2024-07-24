package com.aub.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class loginController {
  @GetMapping("hi")
  public String index(){
    return "login";
  }

  //   @Autowired
  // private loginService loginService;

  // @PostMapping("/admin")
  // public String login(@RequestBody loginModel login) {
  //     loginModel user = loginService.login(login.getUsername(), login.getPassword());
  //     return user != null ? "Login successful" : "Login failed";
  // }
  //   @Autowired
  // private loginService loginService;

  // @PostMapping("")
  // public String login(@RequestBody loginModel login) {
  //     loginModel user = loginService.login(login.getUsername(), login.getPassword());
  //     return user != null ? "Login successful" : "Login failed";
  // }
}
