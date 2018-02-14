package com.seguritech.practicafinal.service.impl;

import com.seguritech.practicafinal.domain.Administrador;
import com.seguritech.practicafinal.repositories.AdministradorRepository;
import com.seguritech.practicafinal.service.AdministradorService;
import org.springframework.cache.annotation.Cacheable;
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
    @Cacheable("Administradores")
    public List<Administrador> findAll() {
        return administradorRepository.findAll();
    }

    @Override
    public Administrador findOne(Long id) {
        return administradorRepository.findOne(id);
    }

    @Override
    public void save(Administrador administrador) {
                 administradorRepository.save(administrador);
    }

    @Override
    public void delete(Long id) {
           administradorRepository.delete(id);
    }
}
