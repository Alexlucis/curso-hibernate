package com.seguritech.practicafinal.repositories;

import com.seguritech.practicafinal.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona,Long>{

}
