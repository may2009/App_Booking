package com.example.demo.controller;

import com.example.demo.dao.PermissionRepo;
import com.example.demo.models.Page;
import com.example.demo.models.Permission;
import com.example.demo.services.BookingService;
import com.example.demo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class GlobalController {
    @Autowired
    private BookingService bookingService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private PermissionRepo permissionRepo;


    @GetMapping(value = {"/getAllMenu"})
    public @ResponseBody
    List<Permission> getAllMenu(){

        Pageable pageRequest = PageRequest.of(0,200);
        List<Permission> permission = permissionRepo.findAll(pageRequest).getContent();

        return permission;
    }



}