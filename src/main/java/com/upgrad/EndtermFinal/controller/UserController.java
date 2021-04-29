package com.upgrad.EndtermFinal.controller;

import com.upgrad.EndtermFinal.model.UserDetails;
import com.upgrad.EndtermFinal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    // Mapping for user details form get request
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("user",new UserDetails());
        return "index";
    }

    // Mapping for user details form post request
    @RequestMapping(method = RequestMethod.POST, value = "/savedata")
    public String saveUser(UserDetails user){
        userService.addUser(user);
        return "redirect:/show";
    }

    // Mapping for show user data
    @RequestMapping("/show")
    public String showData(Model model){
        List<UserDetails> list = userService.getAllUsers();
        model.addAttribute("list", list);
        return "showdata";
    }

    // Mapping for update user
    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, Model model) {
        Optional<UserDetails> user = userService.getUserByID(id);
        UserDetails data = user.get();
        model.addAttribute("data", data);
        return "update";
    }

    // Mapping for delete user
    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return "redirect:/show";
    }

    // Mapping for find user by name
    @RequestMapping( "/find")
    public String find(@Param("keyword") String keyword, Model model){
        List<UserDetails> u = userService.findByUserName(keyword);
        model.addAttribute("u",u);
        return "showdata";
    }

}
