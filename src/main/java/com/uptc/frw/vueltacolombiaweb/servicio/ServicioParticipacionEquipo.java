package com.uptc.frw.vueltacolombiaweb.servicio;

import com.uptc.frw.vueltacolombiaweb.modelo.Edicion;
import com.uptc.frw.vueltacolombiaweb.modelo.Equipo;
import com.uptc.frw.vueltacolombiaweb.modelo.ParticipacionEquipo;
import com.uptc.frw.vueltacolombiaweb.modelo.Patrocinador;
import com.uptc.frw.vueltacolombiaweb.repositorio.RepositorioParticipacionEquipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioParticipacionEquipo {
    @Autowired
    private RepositorioParticipacionEquipo repositorioParticipacionEquipo;

    @Autowired
    private ServicioEdicion servicioEdicion;

    @Autowired
    private ServicioEquipo servicioEquipo;

    @Autowired
    private ServicioPatrocinador servicioPatrocinador;

    public List<ParticipacionEquipo> buscarParticipacionEquipo(){
        return repositorioParticipacionEquipo.findAll();
    }


    public ParticipacionEquipo obtenerParticipacionEquipoPorId(Long id){
        ParticipacionEquipo participacionEquipo = repositorioParticipacionEquipo.findById(id).orElse(null);
        return participacionEquipo;
    }

    public ParticipacionEquipo guardarParticipacionEquipo(ParticipacionEquipo participacionEquipo){
        Edicion edicion = servicioEdicion.obtenerEdicionesPorId(participacionEquipo.getIdEdicion());
        participacionEquipo.setEdicion(edicion);
        Equipo equipo = servicioEquipo.obtenerEquipoPorId(participacionEquipo.getIdEquipo());
        participacionEquipo.setEquipo(equipo);
        Patrocinador patrocinador = servicioPatrocinador.obtenerPatrocinadorPorId(participacionEquipo.getIdParticipador());
        participacionEquipo.setPatrocinador(patrocinador);
        ParticipacionEquipo nuevaParticipacionEquipo = repositorioParticipacionEquipo.save(participacionEquipo);
        return nuevaParticipacionEquipo;
    }

    public ParticipacionEquipo actualizarParticipacionEquipo(ParticipacionEquipo participacionEquipo){
        Edicion edicion = servicioEdicion.obtenerEdicionesPorId(participacionEquipo.getIdEdicion());
        Equipo equipo = servicioEquipo.obtenerEquipoPorId(participacionEquipo.getIdEdicion());
        Patrocinador patrocinador = servicioPatrocinador.obtenerPatrocinadorPorId(participacionEquipo.getIdParticipador());

        ParticipacionEquipo nuevaParticipacionEquipo = obtenerParticipacionEquipoPorId(participacionEquipo.getId());
        if(nuevaParticipacionEquipo != null){
            nuevaParticipacionEquipo.setEdicion(edicion);
            nuevaParticipacionEquipo.setEquipo(equipo);
            nuevaParticipacionEquipo.setPatrocinador(patrocinador);
            guardarParticipacionEquipo(nuevaParticipacionEquipo);
            return nuevaParticipacionEquipo;
        }else{
            throw new RuntimeException("Participación no encontrada");
        }
    }

    public void borrarParticionacionEquipo(Long id){
        repositorioParticipacionEquipo.deleteById(id);
    }
}
