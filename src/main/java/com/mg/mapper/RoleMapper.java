package com.mg.mapper;

import com.mg.pojo.Roles;

import java.util.List;

public interface RoleMapper {
    List<Roles> find(Roles roles);
    boolean addRole(Roles roles);
    boolean delRole(int rNo);
}
