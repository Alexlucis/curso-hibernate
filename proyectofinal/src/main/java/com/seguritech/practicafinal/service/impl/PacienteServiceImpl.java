package com.seguritech.practicafinal.service.impl;

import com.seguritech.practicafinal.domain.ObraSocial;
import com.seguritech.practicafinal.domain.Paciente;
import com.seguritech.practicafinal.domain.Persona;
import com.seguritech.practicafinal.repositories.PacienteRepository;
import com.seguritech.practicafinal.service.PacienteService;
import org.springframework.cache.annotation.Cacheable;
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
        return pacienteRepository.findAll();

    }

    @Override
    public Paciente findOne(Long id) {
        return pacienteRepository.findOne(id);
    }

    @Override
    public void save(Paciente paciente) {
           pacienteRepository.save(paciente);
    }

    @Override
    public void delete(Long id) {
        pacienteRepository.delete(id);
    }

    @Override
    public List<Paciente> findByObraSocial(ObraSocial obraSocial) {
        return pacienteRepository.findByObraSocial(obraSocial);
    }

    @Override
    public boolean exists(Persona persona) {
        if(persona != null){
            return true;
        }
        return false;
    }
}
