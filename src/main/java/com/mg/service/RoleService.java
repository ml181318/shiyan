package com.mg.service;

import com.mg.pojo.Roles;

import java.util.List;

public interface RoleService {
    List<Roles> find(Roles roles);
    boolean addRole(Roles rolesr);
    boolean delRole(int rNo);
}
