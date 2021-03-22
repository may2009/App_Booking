package com.example.demo.controller;


import com.example.demo.dao.PageRepo;
import com.example.demo.dao.PermissionRepo;
import com.example.demo.dao.RoleRepository;
import com.example.demo.dao.UserRepo;
import com.example.demo.models.*;
import com.example.demo.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Controller
@RequestMapping("/admin")
public class PermissionsController {

    @Autowired
    private PermissionRepo permissionRepo;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PageRepo pageRepo;
    @Autowired
    private UsersService userService;

    @GetMapping(value={"/permissions"})
    public ModelAndView permissions(){
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> model = new HashMap<String, Object>();
        List<Page> page = pageRepo.findAll();
        List<Permission> permission = permissionRepo.findAll();
        model.put("page",page);
        model.put("permission",permission);
        return new ModelAndView("/admin/permissions", model);
    }

    @GetMapping(value={"/get_checked_action"})
    public @ResponseBody List<Permission> get_checked_action(){

       List<Permission> permission = permissionRepo.findAll();

        return permission;
    }

    @PostMapping(value = {"/addpermission"})
    public @ResponseBody String addpermission(HttpServletRequest ajouter, HttpServletRequest  modifier, HttpServletRequest  supprimer, HttpServletRequest  afficher, HttpServletRequest page){

        int pageCast = Integer.parseInt(page.getParameter("page"));

       Permission permission = permissionRepo.findByPageId(pageCast);
        int totalPageInPermission = permissionRepo.findByPageTotal(pageCast);
        if (totalPageInPermission>=1){
            editPermission(permission,ajouter,modifier,supprimer,afficher,page);
        }else{
            insertPermission(ajouter,modifier,supprimer,afficher,page);
        }
        return "success";
    }

    public Permission insertPermission(HttpServletRequest ajouter,HttpServletRequest modifier,HttpServletRequest supprimer,HttpServletRequest afficher,HttpServletRequest page){
        Permission p = new Permission();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user = userService.findUserByUserName(auth.getName());


        String ajouterParam = ajouter.getParameter("ajouter");
        String modifierParam = modifier.getParameter("modifier");
        String supprimerParam = supprimer.getParameter("supprimer");
        String afficherParam = afficher.getParameter("afficher");

        int afficherConvert = Integer.parseInt(page.getParameter("page"));

        Page pageParam = pageRepo.getOne(afficherConvert);

        p.setPage(pageParam);
        p.setUsers(user);
        p.setAjouter(ajouterParam);
        p.setModifier(modifierParam);
        p.setSupprimer(supprimerParam);
        p.setAfficher(afficherParam);
        p.setTout("");

        Permission permission = permissionRepo.save(p);


        return  permission;


    }
    public void editPermission(Permission permission,HttpServletRequest ajouter,HttpServletRequest modifier,HttpServletRequest supprimer,HttpServletRequest afficher,HttpServletRequest page){

        permissionRepo.deleteById(permission.getId());
        insertPermission(ajouter,modifier,supprimer,afficher,page);
    }



    }