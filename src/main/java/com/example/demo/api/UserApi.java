package com.example.demo.api;
import com.example.demo.dao.UserRepo;
import com.example.demo.models.User;
import com.example.demo.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*@CrossOrigin(origins = "http://localhost:8081")*/
@RestController
@RequestMapping("/api")
public class UserApi {
    @Autowired
    UserRepo userRepo;

    @Autowired
    private UserService userServices;
    @GetMapping(value = "/getAllRest")
    public List<User> getAll(){

        return  userServices.getAll();
    }
    @PutMapping(value = "/addUserRest")
    public void addUserRest(@RequestBody User user) throws JsonProcessingException {
        userServices.addUser(user);
    }
    @PutMapping(value = "/deleteUserRest/{id}")
    public void deleteUserRest(@PathVariable int id) throws
            JsonProcessingException {
        userServices.deleteuser(id);
    }
    @GetMapping(value = "/GetOneUserRest/{id}")
    public User GetOneUserRest(@PathVariable int id){

        return userServices.GetOneUser(id);
    }
}