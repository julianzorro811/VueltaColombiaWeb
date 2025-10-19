package com.uptc.frw.vueltacolombiaweb.servicio;

import com.uptc.frw.vueltacolombiaweb.modelo.Corredor;
import com.uptc.frw.vueltacolombiaweb.modelo.Etapa;
import com.uptc.frw.vueltacolombiaweb.modelo.Resultado;
import com.uptc.frw.vueltacolombiaweb.repositorio.RepositorioResultado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioResultado {
    @Autowired
    private RepositorioResultado repositorioResultado;

    @Autowired
    private ServicioEtapa servicioEtapa;

    @Autowired
    private ServicioCorredor servicioCorredor;

    public List<Resultado> buscarResultado(){
        return repositorioResultado.findAll();
    }
    public Resultado obtenerResultadoPorId(Long id){
        Resultado resultado = repositorioResultado.findById(id).orElse(null);
        return resultado;
    }

    public Resultado guardarResultado(Resultado resultado){
        Etapa etapa = servicioEtapa.obtenerEtapaPorId(resultado.getIdEtapa());
        resultado.setEtapa(etapa);
        Corredor corredor = servicioCorredor.obtenerCorredoresPorId(resultado.getIdCorredor());
        resultado.setCorredor(corredor);
        Resultado nuevoResultado =repositorioResultado.save(resultado);
        return (nuevoResultado);
    }

    public Resultado actualizarResultado(Resultado resultado){
        Etapa etapa = servicioEtapa.obtenerEtapaPorId(resultado.getIdEtapa());
        Corredor corredor = servicioCorredor.obtenerCorredoresPorId(resultado.getIdCorredor());
        Resultado nuevoResultado = obtenerResultadoPorId(resultado.getId());
        if(nuevoResultado != null){
            nuevoResultado.setEtapa(etapa);
            nuevoResultado.setCorredor(corredor);
            nuevoResultado.setPosicion(resultado.getPosicion());
            nuevoResultado.setTiempo(resultado.getTiempo());
            guardarResultado(nuevoResultado);
            return nuevoResultado;
        }else{
            throw new RuntimeException("Resultado no encontrado");
        }
    }

    public void borrarResultado(Long id){
        repositorioResultado.deleteById(id);
    }
}
