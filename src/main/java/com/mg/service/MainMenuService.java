package com.mg.service;

import com.mg.pojo.MainMenu;

import java.util.List;

public interface MainMenuService {
    List<MainMenu> find(Integer mno);
}
