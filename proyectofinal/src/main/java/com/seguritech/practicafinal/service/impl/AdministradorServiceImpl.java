package com.seguritech.practicafinal.service.impl;

import com.seguritech.practicafinal.domain.Administrador;
import com.seguritech.practicafinal.domain.repositories.AdministradorRepository;
import com.seguritech.practicafinal.service.AdministradorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdministradorServiceImpl implements AdministradorService {

    private final AdministradorRepository administradorRepository;

    public AdministradorServiceImpl(AdministradorRepository administradorRepository) {
        this.administradorRepository = administradorRepository;
    }

    @Override
    public List<Administrador> findAll() {
        return null;
    }

    @Override
    public Administrador findOne(Long id) {
        return null;
    }

    @Override
    public void save(Administrador administrador) {

    }

    @Override
    public void delete(Long id) {

    }
}
