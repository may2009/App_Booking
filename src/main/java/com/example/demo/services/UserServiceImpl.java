package com.example.demo.services;
import com.example.demo.dao.UserRepo;
import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Value("${demo.url}")
    private String url;
    @Autowired
    UserRepo userRepo;
    @Override
    public List<User> getAll() {
       /* final String uri = url+ "/getAllRest";
        RestTemplate restTemplate = new RestTemplate();
        User[] result = restTemplate.getForObject(uri, User[].class);
        return result;*/

        return userRepo.getAll();

    }
    @Override
    public void addUser(User user) {
       /* final String uri = url+ "/addUserRest/"+user;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(uri, User.class);*/

        userRepo.save(user);

    }
    @Override
    public void deleteuser(int id) {
      /*  final String uri = url+"/deleteUserRest/"+id;
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.put(uri,User.class);*/
        userRepo.deleteById(id);

    }
    @Override
    public User GetOneUser(int id) {
       /* final String uri = url+ "/GetOneUserRest/"+id;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;*/

        return userRepo.getOneUser(id);
    }
}