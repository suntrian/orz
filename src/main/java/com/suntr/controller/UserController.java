package com.suntr.controller;

import com.suntr.model.User;
import com.suntr.service.IUserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by suntr on 5/18/2017.
 */

@Scope("session")
@Controller
public class UserController {

    @Resource
    private IUserService userService;

    private User curUser;

    @PostConstruct
    public void init(){
        this.curUser = userService.selectAll().get(0);
    }

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("Hello World");
        return "success";
    }


    @RequestMapping("/user")
    public String getUser(HttpServletRequest request, Model model){
        User user = userService.getOneUserById(11);
        model.addAttribute("user", user);

        return "showUser";
    }

    @RequestMapping("/mav")
    public ModelAndView u(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name","WOCHA");
        mav.setViewName("mav");
        return mav;
    }

    @RequestMapping("/json")
    @ResponseBody
    public User get(){
        User user = userService.getOneUserById(11);
        System.out.println(user);
        return user;
    }

    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public String getjson(@PathVariable("id") Integer id, Model model ){
        User user = userService.getOneUserById(id);
        System.out.println(user);
        model.addAttribute(user);
        return "showUser";
    }

    @RequestMapping(value = "/gett/{id}",method = RequestMethod.GET)
    public String gett(@PathVariable("id") Integer id, Map<String, Object> map){
        User user = userService.getOneUserById(id);
        System.out.println(user);
        map.put("user", user);
        map.put("name",user.getName());
        return "showUser";
    }

}
