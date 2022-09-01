package com.mg.pojo;

import lombok.Data;

import java.util.List;

@Data
public class MainMenu {
    private Integer mNo;
    private String mName;
    private List<SonMenu> lists;
    private List<ShareRole> listsr;
}
