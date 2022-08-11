package com.revature.ecomm.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping
public class UserServlet {
    private final UserService userServices;
    @Autowired
    public UserServlet(UserService userServices){
        this.userServices = userServices;
    }
    @GetMapping("/homepage")
    public @ResponseBody String test(){
        return "Welcome to Ecomm!";
    }
    @GetMapping("findAllUsers")
    public ResponseEntity<List> findAllUsers(){
        return new ResponseEntity<>(userServices.findAll(), HttpStatus.FOUND);
    }
    @GetMapping("findUser")
    public ResponseEntity<User> findUser(@RequestParam String id){
        User user = userServices.readById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User newUser = userServices.create(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    @PutMapping("/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User newUser = userServices.update(user);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }
    @DeleteMapping("/deleteUser")
public <username> void deleteUser(@RequestParam String username){
    boolean newUser = userServices.delete(username);
    }
}
