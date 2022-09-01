package com.mg.service.impl;

import com.mg.mapper.DepartMapper;
import com.mg.pojo.Depart;
import com.mg.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartServiceImpl implements DepartService {
    @Autowired(required = false)
    DepartMapper departMapper;

    @Override
    public List<Depart> find(Depart depart) {
        return departMapper.find(depart);
    }

    @Override
    public boolean adddep(Depart depart) {
        return departMapper.adddep(depart);
    }

    @Override
    public boolean deldep(int dId) {
        return departMapper.deldep(dId);
    }
}
