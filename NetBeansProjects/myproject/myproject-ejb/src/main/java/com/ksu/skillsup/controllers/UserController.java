/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ksu.skillsup.controllers;

/**
 *
 * @author ksu
 */

    
import com.ksu.skillsup.model.Contact;
import com.ksu.skillsup.service.ContactService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class UserController {
 
    @Autowired
    private ContactService userService;
  

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ModelAndView getUsersView() {
        ModelAndView mv= new ModelAndView("usersView");
        mv.addObject("usersModel", userService.getAllContacts());
        return mv;
    }
     

    @RequestMapping(value = "/usersList", method = RequestMethod.GET)
    public @ResponseBody Collection <Contact> getUsersRest() {
        return userService.getAllContacts();
    }
}
    

