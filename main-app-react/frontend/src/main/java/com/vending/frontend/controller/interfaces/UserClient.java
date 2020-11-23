package com.vending.frontend.controller.interfaces;

import com.vending.frontend.models.UserDTO;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("users")
public interface UserClient {

    @GetMapping("/users")
    Map<String, ArrayList<UserDTO>> getAll();

    @GetMapping("/users/{id}")
    UserDTO getOne(@PathVariable Integer id);

    @PostMapping("/users")
    void addUser(@RequestBody UserDTO product);
    
}
