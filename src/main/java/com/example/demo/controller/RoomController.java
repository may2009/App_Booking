package com.example.demo.controller;


import com.example.demo.dao.*;
import com.example.demo.models.*;
import com.example.demo.utility.FileUploadUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.Optional;


@Controller
@RequestMapping("/admin")
public class RoomController {

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
    @Autowired
    private  RoomRepo roomRepo;
    @Autowired
    private  ImageRoomRepo imageRoomRepo;


    @GetMapping(value={"/room"})
    public ModelAndView room(){
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> model = new HashMap<String, Object>();

        Permission permission = permissionRepo.findByPageId(3);
        if(!permission.getAfficher().equals("1")){
            return new ModelAndView("/error", model);
        }else {
            List<Room> room = roomRepo.findAll();
            List<Hotel> hotel = hotelRepo.findAll();
            model.put("room",room);
            model.put("hotel",hotel);
            model.put("permission",permission);
            return new ModelAndView("/admin/room", model);
        }
    }


    @RequestMapping(value="/addRoom", method = RequestMethod.POST)
        public String addRoom(@ModelAttribute Room room, @ModelAttribute Image_room image_room, @RequestParam("imageFile") MultipartFile[] imageFile) throws IOException {


        Room saveRoom = roomRepo.save(room);

        for (MultipartFile multipartFile : imageFile) {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());


        /*    if(!fileName.equals("")){
                image_room.setImage(fileName);
            }else{
                image_room.setImage(image_room.getImage());
            }*/

            Image_room image_room1 = new Image_room();

            image_room1.setImage(fileName);
            image_room1.setRoom(room);
            Image_room saveImageRoom = imageRoomRepo.save(image_room1);


            try {
                String uploadDir = "room-photos/" + saveImageRoom.getId();
                FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
            }catch (Exception e){


            }


        }





            return "redirect:/admin/room";

    }
    @RequestMapping(value="/getOneRoom", method = RequestMethod.GET)
    public @ResponseBody
    Room getOneRoom(@RequestParam int id) {
    Room room = roomRepo.getId(id);

        return room;
    }


    @RequestMapping(value="/getImagesRoom", method = RequestMethod.GET)
    public @ResponseBody
    List<Image_room> getImagesRoom(@RequestParam int id) {
    List<Image_room> imageRoom = imageRoomRepo.getByRoom(id);

        return imageRoom;
    }

    @RequestMapping(value="/getDeatilRoom", method = RequestMethod.GET)
    public @ResponseBody
    List<Image_room> getDeatilRoom(@RequestParam int id) {
        List<Image_room> imageRoom = imageRoomRepo.getByRoom(id);

        return imageRoom;
    }
    @RequestMapping(value="/deleteRoom",method = RequestMethod.GET)
    public String deleteRoom(HttpServletRequest id)
    {
        String idParam = id.getParameter("id");
        int idConvert=0;
        if(idParam != null && idParam !="")
        {
            idConvert = Integer.parseInt(idParam);
            roomRepo.deleteById(idConvert);
        }

            return "redirect:/admin/room";

    }

@RequestMapping(value="/deleteImage",method = RequestMethod.GET)
public @ResponseBody int deleteImage(HttpServletRequest id)
    {
        String idParam = id.getParameter("id");
        int idConvert=0;
        if(idParam != null && idParam !="")
        {
            idConvert = Integer.parseInt(idParam);
            imageRoomRepo.deleteById(idConvert);
        }

            return idConvert;

    }


    }