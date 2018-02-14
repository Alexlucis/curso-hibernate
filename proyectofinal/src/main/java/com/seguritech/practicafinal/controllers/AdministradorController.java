package com.seguritech.practicafinal.controllers;

import com.seguritech.practicafinal.domain.Administrador;
import com.seguritech.practicafinal.service.AdministradorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class AdministradorController {

    private final AdministradorService administradorService;

    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @GetMapping(value = "/administrador")
    public List<Administrador> listAll() {
        List<Administrador> administradores = administradorService.findAll();
        System.out.println(administradores.size());
        return administradores;
    }

    @GetMapping("/administrador/{id}")
    public ResponseEntity<Administrador> getAdministrador(@PathVariable("id") Long id) {
        Administrador administrador = administradorService.findOne(id);
        if (administrador == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(administrador);
    }

    @PostMapping("/administrador")
    public ResponseEntity<Administrador> create(@RequestBody Administrador administrador) throws URISyntaxException {
        if (administrador.getId() != null && administrador.getClave() == null) {
            return ResponseEntity.badRequest().header("X-error", "El id debe ser null y la clave no debe ser null").body(null);
        }
        administradorService.save(administrador);
        return ResponseEntity.created(new URI("/rol/" + administrador.getId())).body(administrador);
    }

    @PutMapping("/administrador")
    public ResponseEntity<Administrador> update(@RequestBody Administrador administrador) throws Exception {
        if (administrador.getId() == null) {
            return ResponseEntity.badRequest().header("X-error", "El id no debe ser null").body(null);
        }
        administradorService.save(administrador);
        return ResponseEntity.ok().body(administrador);
    }

    @DeleteMapping("/administrador/{id}")
    public ResponseEntity<Administrador> delete(@PathVariable("id") Long id) {
        administradorService.delete(id);
        return ResponseEntity.ok().build();
    }
}
