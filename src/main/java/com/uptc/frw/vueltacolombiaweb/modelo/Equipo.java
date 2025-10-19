package com.uptc.frw.vueltacolombiaweb.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "EQUIPO")
public class Equipo {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "FECHA_FUNDACION")
    private Date fechaFundacion;

    @JsonIgnore
    @OneToMany(mappedBy = "equipo")
    private List<ParticipacionEquipo> participacionEquipos;

    @JsonIgnore
    @OneToMany(mappedBy = "equipo")
    private List<CorredorEquipo> corredorEquipos;

    public Equipo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(Date fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
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
        return "Equipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaFundacion=" + fechaFundacion +
                '}';
    }
}
