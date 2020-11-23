package com.vending.frontend.controller;

import java.util.ArrayList;
import java.util.Map;

import com.vending.frontend.controller.interfaces.UserClient;
import com.vending.frontend.models.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableFeignClients
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserClient userClient;


    @GetMapping("/")
    public Map<String, ArrayList<UserDTO>> getAll(){
        return this.userClient.getAll();
    }

    
    @PostMapping("/")
    public void addUser(@RequestBody UserDTO user){
        this.userClient.addUser(user);
    }
    
    @GetMapping("/{id}")
    public UserDTO getOne(@PathVariable Integer id){
        return this.userClient.getOne(id);
    }
    
}
