package com.uptc.frw.vueltacolombiaweb.servicio;

import com.uptc.frw.vueltacolombiaweb.modelo.Corredor;
import com.uptc.frw.vueltacolombiaweb.modelo.Edicion;
import com.uptc.frw.vueltacolombiaweb.repositorio.RepositorioEdicion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioEdicion {
    @Autowired
    private RepositorioEdicion repositorioEdicion;

    public List<Edicion> buscarEdiciones(){
        return repositorioEdicion.findAll();
    }
    public Edicion obtenerEdicionesPorId(Long id){
        Edicion edicion = repositorioEdicion.findById(id).orElse(null);
        return edicion;
    }

    public Edicion guardarEdicion(Edicion edicion){
        Edicion nuevaEdicion = repositorioEdicion.save(edicion);
        return nuevaEdicion;
    }

    public Edicion actualizarEdicion(Edicion edicion){
        Edicion nuevaEdicion = obtenerEdicionesPorId(edicion.getId());
        if(nuevaEdicion != null){
            nuevaEdicion.setAnio(edicion.getAnio());
            nuevaEdicion.setFechaInicio(edicion.getFechaInicio());
            nuevaEdicion.setFechaFin(edicion.getFechaInicio());
            guardarEdicion(nuevaEdicion);
            return nuevaEdicion;
        }else{
            throw new RuntimeException("Edicion no encontrada");
        }
    }

    public void borrarEdicion(Long id){
        repositorioEdicion.deleteById(id);
    }
}
