package com.seguritech.practicafinal.service.impl;

import com.seguritech.practicafinal.domain.Medico;
import com.seguritech.practicafinal.domain.repositories.MedicoRepository;
import com.seguritech.practicafinal.service.MedicoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MedicoServiceImpl implements MedicoService{

    private final MedicoRepository medicoRepository;

    public MedicoServiceImpl(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @Override
    public List<Medico> findAll() {
        return null;
    }

    @Override
    public Medico findOne(Long id) {
        return null;
    }

    @Override
    public void save(Medico medico) {

    }

    @Override
    public void delete(Long id) {

    }
}
