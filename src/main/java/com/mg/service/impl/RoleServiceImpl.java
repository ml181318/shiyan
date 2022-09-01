package com.mg.service.impl;

import com.mg.mapper.RoleMapper;
import com.mg.pojo.Roles;
import com.mg.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired(required = false)
    RoleMapper roleMapper;
    @Override
    public List<Roles> find(Roles roles) {
        return roleMapper.find(roles);
    }

    @Override
    public boolean addRole(Roles rolesr) {
        return roleMapper.addRole(rolesr);
    }

    @Override
    public boolean delRole(int rNo) {
        return roleMapper.delRole(rNo);
    }
}
