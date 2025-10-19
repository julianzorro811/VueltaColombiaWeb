package com.uptc.frw.vueltacolombiaweb.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "CORREDOR_EQUIPO")
public class CorredorEquipo {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ID_EQUIPO", insertable = false, updatable = false)
    private long idEquipo;

    @Column(name = "ID_EDICION", insertable = false, updatable = false)
    private long idEdicion;

    @Column(name = "ID_CORREDOR", insertable = false, updatable = false)
    private long idCorredor;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_EQUIPO")
    private Equipo equipo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_EDICION")
    private Edicion edicion;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_CORREDOR")
    private Corredor corredor;

    public CorredorEquipo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(long idEquipo) {
        this.idEquipo = idEquipo;
    }

    public long getIdEdicion() {
        return idEdicion;
    }

    public void setIdEdicion(long idEdicion) {
        this.idEdicion = idEdicion;
    }

    public long getIdCorredor() {
        return idCorredor;
    }

    public void setIdCorredor(long idCorredor) {
        this.idCorredor = idCorredor;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Edicion getEdicion() {
        return edicion;
    }

    public void setEdicion(Edicion edicion) {
        this.edicion = edicion;
    }

    public Corredor getCorredor() {
        return corredor;
    }

    public void setCorredor(Corredor corredor) {
        this.corredor = corredor;
    }

    @Override
    public String toString() {
        return "CorredorEquipo{" +
                "id=" + id +
                ", idEquipo=" + idEquipo +
                ", idEdicion=" + idEdicion +
                ", idCorredor=" + idCorredor +
                '}';
    }
}
