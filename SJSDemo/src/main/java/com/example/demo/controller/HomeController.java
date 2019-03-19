package com.example.demo.controller;



import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.AuthDao;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
 

@Controller

public class HomeController {
	@Autowired
	private AuthDao authdao;
	
    @RequestMapping("/main")
    public String main(Model model) {

        User user =getUserDetails();

        Set set = new HashSet();

         List<Role> roles = user.getRoles();

         for (Role role : roles) {

             set.addAll(role.getAuthoritys());

        }
         System.out.println(set);

   // model.addAttribute("authorities",set);
          model.addAttribute("authorities",authdao.findAll());

        

    return "index";

    }

    private  User getUserDetails() {

        SecurityContext ctx = SecurityContextHolder.getContext();   

        Authentication auth = ctx.getAuthentication();

        return (User)auth.getPrincipal();

    }

}
