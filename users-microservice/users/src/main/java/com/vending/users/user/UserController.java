package com.vending.users.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public Map<String, ArrayList<User>> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @RequestMapping("/users/{id}")
    public User getUser(@PathVariable Integer id){
        return this.userService.getUser(id);
    }
    @PostMapping("/users")
    @ResponseBody
    public void addProduct(@RequestBody UserDTO user){
        User persistentUser = new User();
        persistentUser.setId(user.getId());
        persistentUser.setEmail(user.getEmail());
        persistentUser.setFirstName(user.getFirstName());
        persistentUser.setLastName(user.getLastName());
        persistentUser.setPassword(user.getPassword());
        this.userService.addUser(persistentUser);
    }
    
}
