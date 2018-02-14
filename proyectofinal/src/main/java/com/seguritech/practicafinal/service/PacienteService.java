package com.seguritech.practicafinal.service;

import com.seguritech.practicafinal.domain.ObraSocial;
import com.seguritech.practicafinal.domain.Paciente;
import com.seguritech.practicafinal.domain.Persona;

import java.util.List;

public interface PacienteService {

    List<Paciente> findAll();

    Paciente findOne(Long id);

    void save(Paciente paciente);

    void delete(Long id);

    List<Paciente> findByObraSocial(ObraSocial obraSocial);

    boolean exists(Persona persona);

}
