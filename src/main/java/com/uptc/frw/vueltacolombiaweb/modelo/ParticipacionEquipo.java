package com.uptc.frw.vueltacolombiaweb.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "PARTICIPACION_EQUIPO")
public class ParticipacionEquipo {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ID_EDICION", insertable = false, updatable = false)
    private long idEdicion;

    @Column(name = "ID_EQUIPO", insertable = false, updatable = false)
    private long idEquipo;

    @Column(name = "ID_PATROCINADOR", insertable = false, updatable = false)
    private long idParticipador;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_EDICION")
    private Edicion edicion;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_PATROCINADOR")
    private Patrocinador patrocinador;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_EQUIPO")
    private Equipo equipo;

    public ParticipacionEquipo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdEdicion() {
        return idEdicion;
    }

    public void setIdEdicion(long idEdicion) {
        this.idEdicion = idEdicion;
    }

    public long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(long idEquipo) {
        this.idEquipo = idEquipo;
    }

    public long getIdParticipador() {
        return idParticipador;
    }

    public void setIdParticipador(long idParticipador) {
        this.idParticipador = idParticipador;
    }

    public Edicion getEdicion() {
        return edicion;
    }

    public void setEdicion(Edicion edicion) {
        this.edicion = edicion;
    }

    public Patrocinador getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(Patrocinador patrocinador) {
        this.patrocinador = patrocinador;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "ParticipacionEquipo{" +
                "id=" + id +
                ", idEdicion=" + idEdicion +
                ", idEquipo=" + idEquipo +
                ", idParticipador=" + idParticipador +
                '}';
    }
}
