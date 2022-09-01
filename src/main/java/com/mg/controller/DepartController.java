package com.mg.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mg.pojo.Depart;
import com.mg.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class DepartController {
    @Autowired(required = false)
    DepartService departService;

    @RequestMapping("/depart")
    public ModelAndView dep(@RequestParam(value = "curPage",required = true, defaultValue = "1") Integer curPage){
        PageHelper.startPage(curPage,1);
        List<Depart> list = departService.find(new Depart());
        PageInfo page = new PageInfo(list);
        ModelAndView mv = new ModelAndView("depart");
        mv.addObject("dlist",page.getList());
        mv.addObject("page",page);
        return mv;
    }

    @RequestMapping("/seldepart")
    public ModelAndView seld(Depart depart,@RequestParam(value = "curPage",required = true,defaultValue = "1") Integer curPage){
        PageHelper.startPage(curPage,1);
        List list = departService.find(depart);
        PageInfo page = new PageInfo(list);
        ModelAndView mv = new ModelAndView("depart");
        mv.addObject("dlist",page.getList());
        mv.addObject("page",page);
        return mv;
    }

    @RequestMapping("/addDepart")
    public String adddep(){
        return "addDepart";
    }

    @RequestMapping("/addDepartMapping")
    public void addep(Depart depart, HttpServletResponse resp) throws IOException {
        if(departService.adddep(depart)){
            resp.getWriter().print(0);
        }else{
            resp.getWriter().print(1);
        }
    }

    @RequestMapping("/deldepart")
    public String delde(@RequestParam("dId") Integer dId){
        if(departService.deldep(dId)){
            return "redirect:/depart";
        }
        return "";
    }
}
