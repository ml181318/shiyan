package com.mg.mapper;

import com.mg.pojo.Depart;

import java.util.List;

public interface DepartMapper {
    List<Depart> find(Depart depart);
    boolean adddep(Depart depart);
    boolean deldep(int dId);
}
