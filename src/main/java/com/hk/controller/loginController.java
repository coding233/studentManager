package com.hk.controller;

import com.hk.Service.UserService;
import com.hk.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class loginController {
    @Autowired
    private UserService userServiceImpl;

    @GetMapping
    public String loginPage(){
        return "login";
    }

    //提交
    @PostMapping("/login")
    public String login(@RequestParam String uname, @RequestParam String password,
                        HttpSession session){
        User user=userServiceImpl.CheckUser(uname,password);
        if(user!=null){
            user.setPassword(null);
            session.setAttribute("user",user);
            return "index";
        }else{
            return "redirect:/";
        }
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/zhuce")
    public String zhuce(){
        return "zhuce";
    }

    @PostMapping("/insert")
    public String insZhuce(@RequestParam String uname, @RequestParam String password){
        User user=new User();
        user.setUname(uname);
        user.setPassword(password);
        userServiceImpl.insUser(user);
        return "login";
    }
}
