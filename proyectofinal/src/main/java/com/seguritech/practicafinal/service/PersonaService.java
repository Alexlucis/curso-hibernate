package com.seguritech.practicafinal.service;

import com.seguritech.practicafinal.domain.Persona;

import java.util.List;

public interface PersonaService {

    List<Persona> findAll();

    Persona findOne(Long id);


}
