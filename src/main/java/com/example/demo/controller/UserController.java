package com.example.demo.controller;
import com.example.demo.dao.PermissionRepo;
import com.example.demo.dao.UserRepo;
import com.example.demo.models.Permission;
import com.example.demo.models.User;
import com.example.demo.models.Users;
import com.example.demo.services.UserService;
import com.example.demo.services.UsersService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserService userServices;
    @Autowired
    private UsersService userService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PermissionRepo permissionRepo;
   @RequestMapping("/users")
    public ModelAndView welcome() {
        Map<String, Object> model = new HashMap<String, Object>();
        List<User> usr = userServices.getAll();


        model.put("All",usr);
       Permission permission = permissionRepo.findByPageId(1);
       model.put("permission",permission);
       if(!permission.getAfficher().equals("1")){
           return new ModelAndView("/error", model);
       }else {
           return new ModelAndView("/admin/users", model);
       }
    }
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String add(@ModelAttribute User user) throws JsonProcessingException {

        userServices.addUser(user);

        Permission permission = permissionRepo.findByPageId(1);
        if(!permission.getAjouter().equals("1")){
            return "error";
        }else {
            return "redirect:/admin/users";
        }
    }
    @RequestMapping(value="/getOneUseser", method = RequestMethod.GET)
    public @ResponseBody User getOneUseser(@RequestParam int id) throws
            JsonProcessingException {
        User usr = userServices.GetOneUser(id);

        return usr;
    }
    @RequestMapping(value="/deleteUser",method = RequestMethod.GET)
    public String deleteUser(HttpServletRequest id)
    {
        String idd = id.getParameter("id");
        int idint=0;
        if(idd != null && idd !="")
        {
            idint = Integer.parseInt(idd);
            userServices.deleteuser(idint);
        }
        Permission permission = permissionRepo.findByPageId(1);
        if(!permission.getSupprimer().equals("1")){
            return "error";
        }else {
            return "redirect:/admin/users";
        }
    }
}