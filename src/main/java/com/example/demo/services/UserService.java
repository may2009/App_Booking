package com.example.demo.services;
import com.example.demo.models.User;

import java.util.List;

public interface UserService {
    public List<User> getAll();
    public void addUser(User user);
    public void deleteuser(int id);
    public User GetOneUser(int id);


}