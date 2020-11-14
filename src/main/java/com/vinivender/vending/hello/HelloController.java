package com.vinivender.vending.hello;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    List<String> names = Arrays.asList("Maleke");
    @RequestMapping("/hello")
    public List<String> sayHi(){
        return names;
    }

    
}
