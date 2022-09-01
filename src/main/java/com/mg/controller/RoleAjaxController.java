package com.mg.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mg.pojo.Roles;
import com.mg.service.RoleService;
import com.mg.tools.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ajaxRole")
public class RoleAjaxController {
    @Autowired
    RoleService roleService;

    @RequestMapping("/ajaxRoleMapping")
    public ServerResponse pagehelp(
            @RequestParam("curPage") Integer curPage,
            Roles roles
    ){
        PageHelper.startPage(curPage,2);
        List<Roles> list = roleService.find(roles);
        PageInfo page = new PageInfo(list);
        return ServerResponse.createBySuccess(page);
    }
}
