package com.crud.springboot_tymeleaf_crud.controller;


import com.crud.springboot_tymeleaf_crud.models.User;
import com.crud.springboot_tymeleaf_crud.services.UserService;
import com.crud.springboot_tymeleaf_crud.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
     UserServiceImpl userService;

    @RequestMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("user",this.userService.getAllUser());
        List<User> userList =  this.userService.getAllUser();

        for (int i=0; i<userList.size(); i++){
            System.out.println("ALl User "+userList.get(i).getId()+" "+" "+userList.get(i).getName()+"  "+userList.get(i).getEmail());
        }

        return "index.html";

    }


    @GetMapping("/showNewUserAddForm")
    public String showNewUserAddForm(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "newUser.html";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        System.out.println("Click");
        userService.saveUser(user);
        return "redirect:/";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id,Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "updateUser";
    }

    @GetMapping("deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") Long id){
        userService.deleteUser(id);
        return "redirect:/";
    }






}
