package com.uptc.frw.vueltacolombiaweb.servicio;

import com.uptc.frw.vueltacolombiaweb.modelo.Equipo;
import com.uptc.frw.vueltacolombiaweb.repositorio.RepositorioEquipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioEquipo {
    @Autowired
    private RepositorioEquipo repositorioEquipo;
    public List<Equipo> buscarEquipo(){
        return repositorioEquipo.findAll();
    }

    public Equipo obtenerEquipoPorId(Long id){
        Equipo equipo = repositorioEquipo.findById(id).orElse(null);
        return equipo;
    }

    public Equipo guardarEquipo(Equipo equipo){
        Equipo nuevoEquipo = repositorioEquipo.save(equipo);
        return nuevoEquipo;
    }

    public Equipo actualizarEquipo(Equipo equipo){
        Equipo nuevoEquipo = obtenerEquipoPorId(equipo.getId());
        if(nuevoEquipo != null){
            nuevoEquipo.setNombre(equipo.getNombre());
            nuevoEquipo.setFechaFundacion(equipo.getFechaFundacion());
            guardarEquipo(nuevoEquipo);
            return nuevoEquipo;
        }else{
            throw new RuntimeException("Equipo no encontrado");
        }
    }
    public void borrarEquipo(Long id){
        repositorioEquipo.deleteById(id);
    }
}
