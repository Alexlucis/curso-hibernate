package com.seguritech.practicafinal.domain;

import javax.persistence.*;


@Entity
@DiscriminatorValue(value = "MEDICO")
public class Medico extends Persona {

    @Column(name = "especialidad_id")
    @Enumerated(EnumType.ORDINAL)
    private Especialidad especialidad;

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidadId(Especialidad especialidadId) {
        this.especialidad = especialidadId;
    }
}
