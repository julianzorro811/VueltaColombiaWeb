package com.uptc.frw.vueltacolombiaweb.servicio;

import com.uptc.frw.vueltacolombiaweb.modelo.Corredor;
import com.uptc.frw.vueltacolombiaweb.modelo.Patrocinador;
import com.uptc.frw.vueltacolombiaweb.repositorio.RepositorioPatrocinador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioPatrocinador {
    @Autowired
    private RepositorioPatrocinador repositorioPatrocinador;

    public List<Patrocinador> buscarPatrocinador(){
        return repositorioPatrocinador.findAll();
    }

    public Patrocinador obtenerPatrocinadorPorId(Long id){
        Patrocinador patrocinador = repositorioPatrocinador.findById(id).orElse(null);
        return patrocinador;
    }

    public Patrocinador guardarPatrocinador (Patrocinador patrocinador){
        Patrocinador nuevoPatrocinador = repositorioPatrocinador.save(patrocinador);
        return nuevoPatrocinador;
    }

    public List<Patrocinador> guardarPatrocinadores(List<Patrocinador> patrocinadores) {
        return repositorioPatrocinador.saveAll(patrocinadores);
    }
    public Patrocinador actualizarPatrocinador(Patrocinador patrocinador){
        Patrocinador nuevoPatrocinador = obtenerPatrocinadorPorId(patrocinador.getId());
        if(nuevoPatrocinador != null){
            nuevoPatrocinador.setNit(patrocinador.getNit());
            nuevoPatrocinador.setNombre(patrocinador.getNombre());
            guardarPatrocinador(nuevoPatrocinador);
            return nuevoPatrocinador;
        }else{
            throw new RuntimeException("Patrocinador no encontrado");
        }
    }

    public void borrarPatrocinador(Long id){
        repositorioPatrocinador.deleteById(id);
    }
}