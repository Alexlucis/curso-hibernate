package com.seguritech.practicafinal.service.impl;

import com.seguritech.practicafinal.domain.Persona;
import com.seguritech.practicafinal.repositories.PersonaRepository;
import com.seguritech.practicafinal.service.PersonaService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    @Cacheable("Personas")
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    @Override
    public Persona findOne(Long id) {
        return personaRepository.findOne(id);
    }
}
