package com.example.demo.controller;

import com.example.demo.dao.ClientRepo;
import com.example.demo.dao.PermissionRepo;
import com.example.demo.dao.UserRepository;
import com.example.demo.models.Client;
import com.example.demo.models.Permission;
import com.example.demo.services.ClientService;
import com.example.demo.services.UsersService;
import com.example.demo.utility.FileUploadUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UsersController {


    @Value("${demo.url}")
    private String baseUrl;

    @Autowired
    private ClientService clientServices;
    @Autowired
    private UsersService userService;
    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PermissionRepo permissionRepo;
   @RequestMapping("/home")
    public ModelAndView home() {
        Map<String, Object> model = new HashMap<String, Object>();

            model.put("name_page","about.jsp");
           return new ModelAndView("/users/index", model);

    }

    @RequestMapping("/about")
    public ModelAndView about() {
        Map<String, Object> model = new HashMap<String, Object>();

        model.put("name_page","home.jsp");

        return new ModelAndView("/users/index", model);

    }

}