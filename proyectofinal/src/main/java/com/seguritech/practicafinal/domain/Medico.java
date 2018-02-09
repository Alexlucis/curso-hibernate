package com.seguritech.practicafinal.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Entity
@DiscriminatorValue(value = "MEDICO")
public class Medico extends Persona {

    @Enumerated(EnumType.ORDINAL)
    private Especialidad especialidad_id;


    public Especialidad getEspecialidad_id() {
        return especialidad_id;
    }

    public void setEspecialidad_id(Especialidad especialidad_id) {
        this.especialidad_id = especialidad_id;
    }
}
