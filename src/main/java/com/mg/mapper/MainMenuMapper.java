package com.mg.mapper;

import com.mg.pojo.MainMenu;

import java.util.List;

public interface MainMenuMapper {
    List<MainMenu> find(Integer mno);
}
