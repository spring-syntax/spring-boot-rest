package com.bytechnology.rest.restlearning.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/users")
    public List<User> retriveAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User retriveUser(@PathVariable int id){
        return userService.findUser(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user){
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(user.getId()).toUri();

        return userService.save(user) ? ResponseEntity.created(location).build():ResponseEntity.noContent().build();
    }
}
