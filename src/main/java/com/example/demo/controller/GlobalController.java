package com.example.demo.controller;

import com.example.demo.dao.PermissionRepo;
import com.example.demo.services.BookingService;
import com.example.demo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/admin")
public class GlobalController {
    @Autowired
    private BookingService bookingService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private PermissionRepo permissionRepo;

    @PostConstruct
    public void init() {
        System.out.println("init system yassine");
    }



}