package com.seguritech.practicafinal.controllers;

import com.seguritech.practicafinal.domain.Medico;
import com.seguritech.practicafinal.service.MedicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping(value = "/medico")
    public List<Medico> listAll() {
        List<Medico> medicos = medicoService.findAll();
        System.out.println(medicos.size());
        return medicos;
    }

    @GetMapping("/medico/{id}")
    public ResponseEntity<Medico> getMedico(@PathVariable("id") Long id) {
        Medico medico = medicoService.findOne(id);
        if (medico == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(medico);
    }

    @PostMapping("/medico")
    public ResponseEntity<Medico> create(@RequestBody Medico medico) throws URISyntaxException {
        if (medico.getId() != null && medico.getClave() == null) {
            return ResponseEntity.badRequest().header("X-error", "El id debe ser null y la clave no debe ser null").body(null);
        }
        medicoService.save(medico);
        return ResponseEntity.created(new URI("/rol/" + medico.getId())).body(medico);
    }

    @PutMapping("/medico")
    public ResponseEntity<Medico> update(@RequestBody Medico medico) throws Exception {
        if (medico.getId() == null) {
            return ResponseEntity.badRequest().header("X-error", "El id no debe ser null").body(null);
        }
        medicoService.save(medico);
        return ResponseEntity.ok().body(medico);
    }

    @DeleteMapping("/medico/{id}")
    public ResponseEntity<Medico> delete(@PathVariable("id") Long id) {
        medicoService.delete(id);
        return ResponseEntity.ok().build();
    }

}
