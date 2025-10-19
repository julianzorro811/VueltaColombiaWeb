package com.uptc.frw.vueltacolombiaweb.servicio;

import com.uptc.frw.vueltacolombiaweb.modelo.Edicion;
import com.uptc.frw.vueltacolombiaweb.modelo.Etapa;
import com.uptc.frw.vueltacolombiaweb.repositorio.RepositorioEdicion;
import com.uptc.frw.vueltacolombiaweb.repositorio.RepositorioEtapa;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioEtapa {
    @Autowired
    private RepositorioEtapa repositorioEtapa;
    @Autowired
    private RepositorioEdicion repositorioEdicion;
    @Autowired
    private ServicioEdicion servicioEdicion;

    public List<Etapa> buscarEtapa(){
        return repositorioEtapa.findAll();
    }
    public Etapa obtenerEtapaPorId(Long id){
        Etapa etapa = repositorioEtapa.findById(id).orElse(null);
        return etapa;
    }

    public Etapa guardarEtapa(Etapa etapa){
        Edicion edicion = servicioEdicion.obtenerEdicionesPorId(etapa.getIdEdicion());
        etapa.setEdicion(edicion);
        Etapa nuevaEtapa =repositorioEtapa.save(etapa);
        return (nuevaEtapa);
    }

    public Etapa actualizarEtapa(Etapa etapa){
        Edicion edicion = servicioEdicion.obtenerEdicionesPorId(etapa.getIdEdicion());
        Etapa nuevaEtapa = obtenerEtapaPorId(etapa.getId());
        if(nuevaEtapa != null){
            nuevaEtapa.setEdicion(edicion);
            nuevaEtapa.setNumeroEtapa(etapa.getNumeroEtapa());
            nuevaEtapa.setOrigen(etapa.getOrigen());
            nuevaEtapa.setDestino(etapa.getDestino());
            nuevaEtapa.setLongitudKm(etapa.getLongitudKm());
            nuevaEtapa.setTipo(etapa.getTipo());
            return repositorioEtapa.save(nuevaEtapa);
        }else{
            throw new RuntimeException("Etapa no encontrada");
        }
    }

    public void borrarEtapa(Long id){
        repositorioEtapa.deleteById(id);
    }
}
