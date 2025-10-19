package com.uptc.frw.vueltacolombiaweb.servicio;

import com.uptc.frw.vueltacolombiaweb.modelo.Corredor;
import com.uptc.frw.vueltacolombiaweb.repositorio.RepositorioCorredor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServicioCorredor {
    @Autowired
    private RepositorioCorredor repositorioCorredor;

    public List<Corredor> buscarCorredor(){
        return repositorioCorredor.findAll();
    }
    public Corredor obtenerCorredoresPorId(Long id){
        Corredor corredor = repositorioCorredor.findById(id).orElse(null);
        return corredor;
    }

    public Corredor guardarCorredor(Corredor corredor){
        Corredor nuevoCorredor = repositorioCorredor.save(corredor);
        return nuevoCorredor;
    }

    public Corredor actualizarCorredor(Corredor corredor){
        Corredor nuevoCorredor = obtenerCorredoresPorId(corredor.getId());
        if(nuevoCorredor != null){
            nuevoCorredor.setNombre(corredor.getNombre());
            nuevoCorredor.setPaisNacimiento(corredor.getPaisNacimiento());
            nuevoCorredor.setFechaNacimiento(corredor.getFechaNacimiento());
            guardarCorredor(nuevoCorredor);
            return nuevoCorredor;
        }else{
            throw new RuntimeException("Corredor no encontrado");
        }
    }

    public void borrarCorredor(Long id){
        repositorioCorredor.deleteById(id);
    }
}
