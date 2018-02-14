package com.seguritech.practicafinal.domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "PACIENTE")
public class Paciente extends Persona{


    @Column(name = "obra_social_id")
    @Enumerated(EnumType.ORDINAL)
    private ObraSocial obraSocial;

//    @ManyToOne()
//    @JoinColumn(name = "obra_social_id")
//    private ObraSocial obraSocial;


    public ObraSocial getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(ObraSocial obraSocial) {
        this.obraSocial = obraSocial;
    }


}
