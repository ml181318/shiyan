package com.mg.service;

import com.mg.pojo.Depart;

import java.util.List;

public interface DepartService {
    List<Depart> find(Depart depart);
    boolean adddep(Depart depart);
    boolean deldep(int dId);
}
