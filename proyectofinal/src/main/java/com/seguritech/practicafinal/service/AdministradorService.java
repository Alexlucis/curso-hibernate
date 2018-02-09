package com.seguritech.practicafinal.service;

import com.seguritech.practicafinal.domain.Administrador;

import java.util.List;

public interface AdministradorService {

    List<Administrador> findAll();

    Administrador findOne(Long id);

    void save(Administrador administrador);

    void delete(Long id);
}
