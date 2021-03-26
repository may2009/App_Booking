package com.example.demo.controller;


import com.example.demo.dao.*;
import com.example.demo.models.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Controller
@RequestMapping("/admin")
public class HotelController {

    @Autowired
    private PermissionRepo permissionRepo;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private PageRepo pageRepo;
    @Autowired
    private HotelRepo hotelRepo;


    @GetMapping(value={"/hotel"})
    public ModelAndView permissions(){
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> model = new HashMap<String, Object>();

        Permission permission = permissionRepo.findByPageId(3);
        if(!permission.getAfficher().equals("1")){
            return new ModelAndView("/error", model);
        }else {
            List<Hotel> hotel = hotelRepo.findAll();
            model.put("hotel",hotel);
            model.put("permission",permission);
            return new ModelAndView("/admin/hotel", model);
        }
    }


    @RequestMapping(value="/addHotel", method = RequestMethod.POST)
    public String add(@ModelAttribute Hotel hotel) throws JsonProcessingException {

        hotelRepo.save(hotel);

        Permission permission = permissionRepo.findByPageId(3);
        if(!permission.getAjouter().equals("1")){
            return "error";
        }else {
            return "redirect:/admin/hotel";
        }
    }


    @RequestMapping(value="/getOneHotel", method = RequestMethod.GET)
    public @ResponseBody
    Optional<Hotel> getOneHotel(@RequestParam int id) {
        Optional<Hotel> hotel = hotelRepo.findById(id);

        return hotel;
    }
    @RequestMapping(value="/deleteHotel",method = RequestMethod.GET)
    public String deleteUser(HttpServletRequest id)
    {
        String idParam = id.getParameter("id");
        int idConvert=0;
        if(idParam != null && idParam !="")
        {
            idConvert = Integer.parseInt(idParam);
            hotelRepo.deleteById(idConvert);
        }
        Permission permission = permissionRepo.findByPageId(1);
        if(!permission.getSupprimer().equals("1")){
            return "error";
        }else {
            return "redirect:/admin/hotel";
        }
    }


    }