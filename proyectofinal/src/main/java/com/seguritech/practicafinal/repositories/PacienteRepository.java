package com.seguritech.practicafinal.repositories;

import com.seguritech.practicafinal.domain.ObraSocial;
import com.seguritech.practicafinal.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    List<Paciente> findByObraSocial(ObraSocial obraSocial);
}
