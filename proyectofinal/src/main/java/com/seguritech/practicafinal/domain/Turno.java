package com.seguritech.practicafinal.domain;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "turnos")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "turno_id")
    private Long turnoId;

    @Column(name = "medico_id")
    private Long medicoId;

    @Column(name = "paciente_id")
    private Long pacienteId;

    @Column(name = "obra_social_id")
    private Long obraSocialId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_turno")
    private Date fechaTurno;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_solicitud_turno")
    private Date fechaSolicitudTurno;

    private String estado;

    public Long getObraSocialId() {
        return obraSocialId;
    }

    public void setObraSocialId(Long obraSocialId) {
        this.obraSocialId = obraSocialId;
    }

    public Long getTurnoId() {
        return turnoId;
    }

    public void setTurnoId(Long turnoId) {
        this.turnoId = turnoId;
    }

    public Long getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Long medicoId) {
        this.medicoId = medicoId;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Date getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(Date fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public Date getFechaSolicitudTurno() {
        return fechaSolicitudTurno;
    }

    public void setFechaSolicitudTurno(Date fechaSolicitudTurno) {
        this.fechaSolicitudTurno = fechaSolicitudTurno;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

