package com.uptc.frw.vueltacolombiaweb.servicio;

import com.uptc.frw.vueltacolombiaweb.modelo.Corredor;
import com.uptc.frw.vueltacolombiaweb.modelo.CorredorEquipo;
import com.uptc.frw.vueltacolombiaweb.modelo.Edicion;
import com.uptc.frw.vueltacolombiaweb.modelo.Equipo;
import com.uptc.frw.vueltacolombiaweb.repositorio.RepositorioCorredorEquipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioCorredorEquipo {
    @Autowired
    private RepositorioCorredorEquipo repositorioCorredorEquipo;

    @Autowired
    private ServicioEquipo servicioEquipo;

    @Autowired
    private ServicioEdicion servicioEdicion;

    @Autowired
    private ServicioCorredor servicioCorredor;

    public List<CorredorEquipo> buscarCorredorEquipo() {
        return repositorioCorredorEquipo.findAll();
    }

    public CorredorEquipo obtenerCorredorEquipoPorId(Long id) {
        CorredorEquipo corredorEquipo = repositorioCorredorEquipo.findById(id).orElse(null);
        return corredorEquipo;
    }

    public CorredorEquipo guardarCorredorEquipo(CorredorEquipo corredorEquipo) {
        Equipo equipo = servicioEquipo.obtenerEquipoPorId(corredorEquipo.getIdEquipo());
        corredorEquipo.setEquipo(equipo);
        Edicion edicion = servicioEdicion.obtenerEdicionesPorId(corredorEquipo.getIdEdicion());
        corredorEquipo.setEdicion(edicion);
        Corredor corredor = servicioCorredor.obtenerCorredoresPorId(corredorEquipo.getIdCorredor());
        corredorEquipo.setCorredor(corredor);

        CorredorEquipo nuevoCorredorEquipo = repositorioCorredorEquipo.save(corredorEquipo);
        return nuevoCorredorEquipo;
    }

    public CorredorEquipo actualizarCorredorEquipo(CorredorEquipo corredorEquipo) {
        Equipo equipo = servicioEquipo.obtenerEquipoPorId(corredorEquipo.getIdEquipo());
        Edicion edicion = servicioEdicion.obtenerEdicionesPorId(corredorEquipo.getIdEdicion());
        Corredor corredor = servicioCorredor.obtenerCorredoresPorId(corredorEquipo.getIdCorredor());

        CorredorEquipo nuevoCorredorEquipo = obtenerCorredorEquipoPorId(corredorEquipo.getId());
        if (nuevoCorredorEquipo != null) {
            nuevoCorredorEquipo.setEquipo(equipo);
            nuevoCorredorEquipo.setEdicion(edicion);
            nuevoCorredorEquipo.setCorredor(corredor);
            guardarCorredorEquipo(nuevoCorredorEquipo);
            return nuevoCorredorEquipo;
        } else {
            throw new RuntimeException("Corredor - Equipo no encontrado");
        }
    }
    public void borrarCorredorEquipo(Long id){
        repositorioCorredorEquipo.deleteById(id);
    }
}
