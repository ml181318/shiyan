package com.mg.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mg.pojo.Roles;
import com.mg.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class RoleController {
    @Autowired(required = false)
    RoleService roleService;

    @RequestMapping("/")
    public String main(){
        return "index";
    }

//角色管理
    @RequestMapping("/role")
    public ModelAndView ro(Roles roles,@RequestParam(value = "curPage",required = true,defaultValue = "1") Integer curPage){
        PageHelper.startPage(curPage,2);
        List<Roles> list = roleService.find(new Roles());
        PageInfo page = new PageInfo(list);
        ModelAndView mv = new ModelAndView("role");
        mv.addObject("rlist",page.getList());
        mv.addObject("page",page);
        return mv;
    }

    @RequestMapping("/findRoleName")
    public ModelAndView findByname(Roles roles,@RequestParam(value = "crPage",required = true,defaultValue = "1") Integer curPage){
        PageHelper.startPage(curPage,2);
        List<Roles> list = roleService.find(roles);
        PageInfo page = new PageInfo(list);
        ModelAndView mv = new ModelAndView("role");
        mv.addObject("rlist",page.getList());
        mv.addObject("page",page);
        return mv;
    }

    //添加角色
    @RequestMapping("/addRole")
    public String addr(){
        return "editRole";
    }

    @RequestMapping("/addRoleMapping")
    public void addmap(Roles roles, HttpServletResponse resp) throws IOException {
        if(roleService.addRole(roles)) {
            resp.getWriter().print(0);
        }else{
            resp.getWriter().print(1);
        }
    }

    //删除
    @RequestMapping("/delRoleId")
    public String delro(@RequestParam("rNo") Integer rNo){
        if(roleService.delRole(rNo)){
            return "redirect:/role";
        }
        return "";
    }

    @RequestMapping("/user")
    public String uso(){
        return "user";
    }

    @RequestMapping("/schedule")
    public String sc(){
        return "schedule";
    }

    @RequestMapping("/404")
    public String ro4(){
        return "404";
    }

    @RequestMapping("/500")
    public String ro5(){
        return "500";
    }

    @RequestMapping("/updatapwd")
    public String pwd(){
        return "updatePwd";
    }

}
