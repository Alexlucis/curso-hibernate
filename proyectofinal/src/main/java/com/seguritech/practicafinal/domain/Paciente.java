package com.seguritech.practicafinal.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "PACIENTE")
public class Paciente extends Persona{

    private Long obra_social_id;

    public Long getObra_social_id() {
        return obra_social_id;
    }

    public void setObra_social_id(Long obra_social_id) {
        this.obra_social_id = obra_social_id;
    }
}
