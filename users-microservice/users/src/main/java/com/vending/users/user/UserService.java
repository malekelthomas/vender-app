package com.vending.users.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    /**
     *
     */
    private static final String DATA = "data";
    @Autowired
    private UserRepository userRepository;
    
    private static ArrayList<User> users = new ArrayList<>();

    private static Map<String, ArrayList<User>> usersData; 
    static {
        usersData = new HashMap<String, ArrayList<User>>();
        usersData.put(DATA, users);
    }
        

    public Map<String, ArrayList<User>> getAllUsers(){
        
        ArrayList<User> users = new ArrayList<>();
        userRepository.findAll()
        .forEach(users::add); //load products from database and add to products ArrayList
        Map<String, ArrayList<User>> usersData = new HashMap<String, ArrayList<User>>(); //reinit HashMap, add new Data
        {
            usersData = new HashMap<String, ArrayList<User>>();
            usersData.put(DATA, users);
        }
        return usersData;
    }

    public User getUser(Integer id){
        //return productsData.get(DATA).stream().filter(p -> p.getId().equals(id)).findFirst().get();
        User user = userRepository.findById(id)
        .orElse(null);

        return user;
    }


    public void addUser(User user){
        usersData.computeIfAbsent(DATA, k -> new ArrayList<>()).add(user);
        userRepository.save(user);
        System.out.println(usersData.get(DATA));

    }
}
