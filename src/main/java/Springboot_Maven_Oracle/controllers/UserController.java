package Springboot_Maven_Oracle.controllers;


import Springboot_Maven_Oracle.domain.User;
import Springboot_Maven_Oracle.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServices userServices;


    @GetMapping("/all")
    public ModelAndView user(ModelMap model){

            User user = new User();
            model.addAttribute("user", user);
            model.addAttribute("userdata", userServices.findAllUsers());

            return new ModelAndView("User", model);

    }


    @PostMapping("/all")
    public Object addUser(@Valid User user, BindingResult bindingResult, ModelMap model){

        if (bindingResult.hasErrors()) {

            model.addAttribute("user",user);
            model.addAttribute("userdata", userServices.findAllUsers());
            return new ModelAndView("User",model);

        }else {


            if (user.getId() == null) {
                userServices.saveUser(user);
                return new ModelAndView("redirect:/user/all");
            } else {

                userServices.update(user);
                return new ModelAndView("redirect:/user/all");

            }
        }


    }


    @GetMapping("/all/{id}")
    public ModelAndView update( ModelMap model, @PathVariable Integer id){

        User user=  userServices.findById(id);

        model.addAttribute("user", user);
        model.addAttribute("userdata", userServices.findAllUsers());

        return new ModelAndView ("User",model);


    }


    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Integer id){

        userServices.delete(id);

        return new ModelAndView("redirect:/user/all");

    }



}
