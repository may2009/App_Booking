package com.example.demo.controller;

import com.example.demo.dao.BookingRepo;
import com.example.demo.dao.PermissionRepo;
import com.example.demo.models.Booking;
import com.example.demo.models.Permission;
import com.example.demo.models.User;
import com.example.demo.services.BookingService;
import com.example.demo.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class GlobalController {
    @Autowired
    private BookingService bookingService;
    @Autowired
    private UserService userService;
    @Autowired
    private PermissionRepo permissionRepo;

    @PostConstruct
    public void init() {
        System.out.println("init system yassine");
    }



}