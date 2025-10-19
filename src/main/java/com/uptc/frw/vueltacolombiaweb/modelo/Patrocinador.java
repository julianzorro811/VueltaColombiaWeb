package com.uptc.frw.vueltacolombiaweb.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "PATROCINADOR")
public class Patrocinador {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NIT")
    private long nit;

    @Column(name = "NOMBRE")
    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "patrocinador")
    private List<ParticipacionEquipo> participacionEquipos;

    public Patrocinador() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNit() {
        return nit;
    }

    public void setNit(long nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ParticipacionEquipo> getParticipacionEquipos() {
        return participacionEquipos;
    }

    public void setParticipacionEquipos(List<ParticipacionEquipo> participacionEquipos) {
        this.participacionEquipos = participacionEquipos;
    }

    @Override
    public String toString() {
        return "Patrocinador{" +
                "id=" + id +
                ", nit=" + nit +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
