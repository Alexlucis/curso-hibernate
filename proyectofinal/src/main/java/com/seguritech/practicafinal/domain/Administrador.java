package com.seguritech.practicafinal.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "ADMINISTRADOR")
public class Administrador extends Persona {


}
