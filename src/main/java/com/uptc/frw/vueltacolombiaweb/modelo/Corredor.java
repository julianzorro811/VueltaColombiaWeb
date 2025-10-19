package com.uptc.frw.vueltacolombiaweb.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CORREDOR")
public class Corredor {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "PAIS_NACIMIENTO")
    private String paisNacimiento;

    @Column(name = "FECHA_NACIMIENTO")
    private String fechaNacimiento;

    @JsonIgnore
    @OneToMany(mappedBy = "corredor")
    private List<Resultado> resultados;

    @JsonIgnore
    @OneToMany(mappedBy = "corredor")
    private List<CorredorEquipo> corredorEquipos;

    public Corredor() {
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

    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(String paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Resultado> getResultados() {
        return resultados;
    }

    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }

    public List<CorredorEquipo> getCorredorEquipos() {
        return corredorEquipos;
    }

    public void setCorredorEquipos(List<CorredorEquipo> corredorEquipos) {
        this.corredorEquipos = corredorEquipos;
    }

    @Override
    public String toString() {
        return "Corredor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", paisNacimiento='" + paisNacimiento + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
