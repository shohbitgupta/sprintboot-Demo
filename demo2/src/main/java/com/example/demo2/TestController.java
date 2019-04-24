package com.example.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private  UserService userService;

    @GetMapping(value = "/hi/{name}")
    public String sayHi(@PathVariable("name") String name){
        return "hello "+name;
    }

    @GetMapping(value = "/user/{id}")
    public String getUser(@PathVariable("id") int id){
        return userService.getUser(id).toString();
    }

    @GetMapping(value = "/users")
    public List<User> getAllUser(){
        return userService.getUsers();
    }

    @PostMapping(value = "/user/")
    public  void saveUser(@RequestBody User u){
        userService.saveUser(u);
    }

    @PutMapping(value = "/user/")
    public User updateUser(@RequestBody User u){
        return userService.updateUser(u);
    }

    @DeleteMapping(value = "/user/")
    public String deleteUser(@RequestBody User u) {
        userService.deleteUser(u);
        return "success";
    }


}
