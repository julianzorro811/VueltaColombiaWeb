package com.uptc.frw.vueltacolombiaweb.controlador;

import com.uptc.frw.vueltacolombiaweb.modelo.Corredor;
import com.uptc.frw.vueltacolombiaweb.modelo.Edicion;
import com.uptc.frw.vueltacolombiaweb.servicio.ServicioEdicion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ediciones")
public class ControladorEdicion {

    private static final Logger logger = LoggerFactory.getLogger(ServicioEdicion.class);

    @Autowired
    private ServicioEdicion servicioEdicion;

    @GetMapping
    public List<Edicion> obtenerEdiciones() {
        logger.info("\n📥 [GET] ====== CONSULTAR TODAS LAS EDICIONES ======");
        List<Edicion> ediciones = servicioEdicion.buscarEdiciones();
        logger.info("✅ Total de ediciones encontradas: {}", ediciones.size());
        logger.info("📄 Datos: {}", ediciones);
        logger.info("===============================================\n");
        return ediciones;
    }

    @GetMapping("/{id}")
    public Edicion obtenerEdicion(@PathVariable Long id) {
        logger.info("\n🔍 [GET] ====== CONSULTAR EDICIÓN POR ID ======");
        logger.info("🆔 ID recibido: {}", id);
        Edicion edicion = servicioEdicion.obtenerEdicionesPorId(id);
        logger.info("📄 Edición encontrada: {}", edicion);
        logger.info("=============================================\n");
        return edicion;
    }

    @PostMapping
    public Edicion guardarEdicion(@RequestBody Edicion edicion) {
        logger.info("\n📝 [POST] ====== GUARDAR NUEVA EDICIÓN ======");
        logger.info("📥 Datos recibidos: {}", edicion);
        Edicion guardada = servicioEdicion.guardarEdicion(edicion);
        logger.info("✅ Edición guardada exitosamente: {}", guardada);
        logger.info("===========================================\n");
        return guardada;
    }

    @PutMapping
    public Edicion actualizarEdicion(@RequestBody Edicion edicion) {
        logger.info("\n✏️ [PUT] ====== ACTUALIZAR EDICIÓN ======");
        Edicion actual = servicioEdicion.obtenerEdicionesPorId(edicion.getId());
        logger.info("📌 Datos actuales: {}", actual);
        logger.info("📥 Nuevos datos: {}", edicion);
        Edicion actualizada = servicioEdicion.actualizarEdicion(edicion);
        logger.info("✅ Actualización completada: {}", actualizada);
        logger.info("=========================================\n");
        return actualizada;
    }

    @DeleteMapping
    public void borrarEdicion(@RequestParam Long id) {
        logger.info("\n🗑️ [DELETE] ====== ELIMINAR EDICIÓN ======");
        logger.info("🆔 ID a eliminar: {}", id);
        servicioEdicion.borrarEdicion(id);
        logger.info("✅ Edición eliminada exitosamente");
        logger.info("=====================================\n");
    }
}
