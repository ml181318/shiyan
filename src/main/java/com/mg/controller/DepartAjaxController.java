package com.mg.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mg.pojo.Depart;
import com.mg.service.DepartService;
import com.mg.tools.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("departajax")
public class DepartAjaxController {
    @Autowired
    DepartService departService;

    @RequestMapping("/dajax")
    public ServerResponse dajax(
            @RequestParam("curPage") Integer curPage, Depart depart
            ){
        PageHelper.startPage(curPage,1);
        List<Depart> list = departService.find(depart);
        PageInfo page = new PageInfo(list);
        return ServerResponse.createBySuccess(page);
    }

}
