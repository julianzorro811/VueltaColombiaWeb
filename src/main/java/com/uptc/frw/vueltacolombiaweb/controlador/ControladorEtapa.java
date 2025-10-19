package com.uptc.frw.vueltacolombiaweb.controlador;

import com.uptc.frw.vueltacolombiaweb.modelo.Etapa;
import com.uptc.frw.vueltacolombiaweb.servicio.ServicioEquipo;
import com.uptc.frw.vueltacolombiaweb.servicio.ServicioEtapa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("etapas")
public class ControladorEtapa {

    private static final Logger logger = LoggerFactory.getLogger(ServicioEtapa.class);

    @Autowired
    private ServicioEtapa servicioEtapa;

    @GetMapping
    public List<Etapa> obtenerEtapas() {
        logger.info("\n📥 [GET] ====== CONSULTAR TODAS LAS ETAPAS ======");
        List<Etapa> etapas = servicioEtapa.buscarEtapa();
        logger.info("✅ Total de etapas encontradas: {}", etapas.size());
        logger.info("📄 Datos: {}", etapas);
        logger.info("===============================================\n");
        return etapas;
    }

    @GetMapping("/{id}")
    public Etapa obtenerEtapa(@PathVariable Long id) {
        logger.info("\n🔍 [GET] ====== CONSULTAR ETAPA POR ID ======");
        logger.info("🆔 ID recibido: {}", id);
        Etapa etapa = servicioEtapa.obtenerEtapaPorId(id);
        logger.info("📄 Etapa encontrada: {}", etapa);
        logger.info("===========================================\n");
        return etapa;
    }

    @PostMapping
    public Etapa guardarEtapa(@RequestBody Etapa etapa) {
        logger.info("\n📝 [POST] ====== GUARDAR NUEVA ETAPA ======");
        logger.info("📥 Datos recibidos: {}", etapa);
        Etapa guardada = servicioEtapa.guardarEtapa(etapa);
        logger.info("✅ Etapa guardada exitosamente: {}", guardada);
        logger.info("=========================================\n");
        return guardada;
    }

    @PutMapping
    public Etapa actualizarEtapa(@RequestBody Etapa etapa) {
        logger.info("\n✏️ [PUT] ====== ACTUALIZAR ETAPA ======");
        Etapa actual = servicioEtapa.obtenerEtapaPorId(etapa.getId());
        logger.info("📌 Datos actuales: {}", actual);
        logger.info("📥 Nuevos datos: {}", etapa);
        Etapa actualizada = servicioEtapa.actualizarEtapa(etapa);
        logger.info("✅ Actualización completada: {}", actualizada);
        logger.info("=======================================\n");
        return actualizada;
    }

    @DeleteMapping
    public void borrarEtapa(@RequestParam Long id) {
        logger.info("\n🗑️ [DELETE] ====== ELIMINAR ETAPA ======");
        logger.info("🆔 ID a eliminar: {}", id);
        servicioEtapa.borrarEtapa(id);
        logger.info("✅ Etapa eliminada exitosamente");
        logger.info("=====================================\n");
    }
}
