package com.seguritech.practicafinal.service.impl;

import com.seguritech.practicafinal.domain.Paciente;
import com.seguritech.practicafinal.domain.repositories.PacienteRepository;
import com.seguritech.practicafinal.service.PacienteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public List<Paciente> findAll() {
        return null;
    }

    @Override
    public Paciente findOne(Long id) {
        return null;
    }

    @Override
    public void save(Paciente paciente) {

    }

    @Override
    public void delete(Long id) {

    }
}
