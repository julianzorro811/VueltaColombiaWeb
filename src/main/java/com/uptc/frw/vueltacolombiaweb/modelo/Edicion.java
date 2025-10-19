package com.uptc.frw.vueltacolombiaweb.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "EDICION")
public class Edicion {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ANIO")
    private long anio;

    @Column(name = "FECHA_INICIO")
    private Date fechaInicio;

    @Column(name = "FECHA_FIN")
    private Date fechaFin;

    @JsonIgnore
    @OneToMany(mappedBy = "edicion")
    private List<Etapa> etapas;

    @JsonIgnore
    @OneToMany(mappedBy = "edicion")
    private List<ParticipacionEquipo> participacionEquipos;

    @JsonIgnore
    @OneToMany(mappedBy = "edicion")
    private List<CorredorEquipo> corredorEquipos;

    public Edicion() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAnio() {
        return anio;
    }

    public void setAnio(long anio) {
        this.anio = anio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<Etapa> getEtapas() {
        return etapas;
    }

    public void setEtapas(List<Etapa> etapas) {
        this.etapas = etapas;
    }

    public List<ParticipacionEquipo> getParticipacionEquipos() {
        return participacionEquipos;
    }

    public void setParticipacionEquipos(List<ParticipacionEquipo> participacionEquipos) {
        this.participacionEquipos = participacionEquipos;
    }

    public List<CorredorEquipo> getCorredorEquipos() {
        return corredorEquipos;
    }

    public void setCorredorEquipos(List<CorredorEquipo> corredorEquipos) {
        this.corredorEquipos = corredorEquipos;
    }

    @Override
    public String toString() {
        return "Edicion{" +
                "id=" + id +
                ", anio=" + anio +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                '}';
    }
}
