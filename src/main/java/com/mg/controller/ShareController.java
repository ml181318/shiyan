package com.mg.controller;

import com.mg.pojo.MainMenu;
import com.mg.service.MainMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/share")
public class ShareController {
    @Autowired
    MainMenuService mainMenuService;

    @RequestMapping("/shareInfo")
    public ModelAndView share(){
        ModelAndView mv = new ModelAndView("shareRole");
        List<MainMenu> list = mainMenuService.find(null);
        mv.addObject("rlist",list);
        return mv;
    }

    public void say(){
        System.out.println("你好呀");
    }
}
