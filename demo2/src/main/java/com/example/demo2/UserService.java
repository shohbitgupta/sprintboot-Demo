package com.example.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserService {

    @Autowired
    private UserRepository userService;
    private static HashMap<Integer,User> map = new HashMap<>();

    static {

        map.put(1,new User(1,"John",20));
        map.put(2,new User(2,"Jack",22));
        map.put(3,new User(3,"Abe",23));
        map.put(4,new User(4,"Dick",40));
    }


    public Optional<User> getUser(int id){
        String  iD = String.valueOf(id);
        return userService.findById(iD);
        //map.get(id);
    }

    public List<User> getUsers(){

        /*List<User> userList = new ArrayList<>();
        for (User u : map.values()){
            userList.add(u);
        }
        return userList;*/
        return userService.findAll();

    }

    public void saveUser(User u){
        //map.put(u.getId(),u);
        userService.save(u);
    }

    public User updateUser(User u){
        /*User oldUser = map.get(u.getId());
        if(oldUser!=null){
            map.put(u.getId(),u);
        }*/
        return userService.save(u);
    }

    public void deleteUser(User user) {
       userService.delete(user);
    }
}
