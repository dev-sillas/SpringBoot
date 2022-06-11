package com.teste.sillas.controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.teste.sillas.model.User;

@RestController
@RequestMapping("/users")
public class Usercontroller {



    private List<User> users  = new ArrayList<>();
    @GetMapping("/{Id}")
    public User user (@PathVariable("Id")long Id){
        System.out.println("O id é"+Id);
        
   Optional <User> UserFind= users.stream().filter(user -> user.getId()==Id).findFirst();
   if(UserFind.isPresent()){ 
   return UserFind.get();
}
return null;
    }

    @PostMapping("/")
    public User user(@RequestBody User user){
        users.add(user);
        return user;
    }

    @GetMapping("/list")
    public List <User> list(){
        return users;
    }

    
}
