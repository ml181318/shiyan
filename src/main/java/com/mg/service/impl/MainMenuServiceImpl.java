package com.mg.service.impl;

import com.mg.mapper.MainMenuMapper;
import com.mg.pojo.MainMenu;
import com.mg.service.MainMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainMenuServiceImpl implements MainMenuService {
    @Autowired(required = false)
    MainMenuMapper mainMenuMapper;
    @Override
    public List<MainMenu> find(Integer mno) {
        return mainMenuMapper.find(mno);
    }
}
