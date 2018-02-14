package com.seguritech.practicafinal.controllers;

import com.seguritech.practicafinal.domain.ObraSocial;
import com.seguritech.practicafinal.domain.Paciente;
import com.seguritech.practicafinal.service.PacienteService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping(value = "/paciente")
    public List<Paciente> listAll(){
        List<Paciente> pacientes = pacienteService.findAll();
        System.out.println(pacientes.size());
        return pacientes;
    }

    @GetMapping("/paciente/{id}")
    public ResponseEntity<Paciente> getPaciente(@PathVariable("id") Long id) {
        Paciente paciente = pacienteService.findOne(id);
        if (paciente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(paciente);
    }
    @GetMapping(value = "/paciente", params = {"obraSocial"})
    public List<Paciente> listAll(ObraSocial obraSocial) {
        List<Paciente> pacientes = pacienteService.findByObraSocial(obraSocial);
        return pacientes;
    }

    @PostMapping(value = "/paciente",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Paciente> create(@RequestBody Paciente paciente) throws URISyntaxException {
        if (paciente.getId() != null && paciente.getClave() == null) {
            return ResponseEntity.badRequest().header("X-error", "El id debe ser null y la clave no debe ser null").body(null);
        }
        pacienteService.save(paciente);
        return ResponseEntity.created(new URI("/paciente/" + paciente.getId())).body(paciente);
    }

    @PutMapping("/paciente")
    public ResponseEntity<Paciente> update(@RequestBody Paciente paciente) throws Exception {
        if (paciente.getId() == null) {
            return ResponseEntity.badRequest().header("X-error", "El id no debe ser null").body(null);
        }
        pacienteService.save(paciente);
        return ResponseEntity.ok().body(paciente);
    }

    @DeleteMapping("/paciente/{id}")
    public ResponseEntity<Paciente> delete(@PathVariable("id") Long id) {
        pacienteService.delete(id);
        return ResponseEntity.ok().build();
    }
}
