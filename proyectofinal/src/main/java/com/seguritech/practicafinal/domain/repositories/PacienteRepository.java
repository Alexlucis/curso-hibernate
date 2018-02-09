package com.seguritech.practicafinal.domain.repositories;

import com.seguritech.practicafinal.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
