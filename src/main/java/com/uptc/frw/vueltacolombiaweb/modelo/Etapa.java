package com.uptc.frw.vueltacolombiaweb.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ETAPA")
public class Etapa {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ID_EDICION", insertable = false, updatable = false)
    private long idEdicion;

    @Column(name = "NUMERO_ETAPA")
    private long numeroEtapa;

    @Column(name = "ORIGEN")
    private String origen;

    @Column(name = "DESTINO")
    private String destino;

    @Column(name = "LONGITUD_KM")
    private long longitudKm;

    @Column(name = "TIPO")
    private String tipo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_EDICION")
    private Edicion edicion;

    @JsonIgnore
    @OneToMany(mappedBy = "etapa")
    private List<Resultado> resultados;

    public Etapa() {
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

    public long getNumeroEtapa() {
        return numeroEtapa;
    }

    public void setNumeroEtapa(long numeroEtapa) {
        this.numeroEtapa = numeroEtapa;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public long getLongitudKm() {
        return longitudKm;
    }

    public void setLongitudKm(long longitudKm) {
        this.longitudKm = longitudKm;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Edicion getEdicion() {
        return edicion;
    }

    public void setEdicion(Edicion edicion) {
        this.edicion = edicion;
    }

    public List<Resultado> getResultados() {
        return resultados;
    }

    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }

    @Override
    public String toString() {
        return "Etapa{" +
                "id=" + id +
                ", idEdicion=" + idEdicion +
                ", numeroEtapa=" + numeroEtapa +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", longitudKm=" + longitudKm +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
