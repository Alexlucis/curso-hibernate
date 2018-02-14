package com.seguritech.practicafinal.controllers;

import com.seguritech.practicafinal.domain.Persona;
import com.seguritech.practicafinal.service.PersonaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }


    @GetMapping(value = "/persona")
    public List<Persona> findAllPersonas() {
        List<Persona> personas = personaService.findAll();
        return personas;
    }

}
