package com.seguritech.practicafinal.service.impl;

import com.seguritech.practicafinal.domain.Medico;
import com.seguritech.practicafinal.repositories.MedicoRepository;
import com.seguritech.practicafinal.service.MedicoService;
import org.springframework.cache.annotation.Cacheable;
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
    @Cacheable("Medicos")
    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }

    @Override
    public Medico findOne(Long id) {
        return medicoRepository.findOne(id);
    }

    @Override
    public void save(Medico medico) {
        medicoRepository.save(medico);
    }

    @Override
    public void delete(Long id) {
        medicoRepository.delete(id);
    }
}
