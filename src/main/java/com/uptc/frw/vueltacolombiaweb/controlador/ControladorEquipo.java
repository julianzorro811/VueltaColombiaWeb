package com.uptc.frw.vueltacolombiaweb.controlador;

import com.uptc.frw.vueltacolombiaweb.modelo.Equipo;
import com.uptc.frw.vueltacolombiaweb.servicio.ServicioEdicion;
import com.uptc.frw.vueltacolombiaweb.servicio.ServicioEquipo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("equipos")
public class ControladorEquipo {

    private static final Logger logger = LoggerFactory.getLogger(ServicioEquipo.class);

    @Autowired
    private ServicioEquipo servicioEquipo;

    @GetMapping
    public List<Equipo> obtenerEquipos() {
        logger.info("\n📥 [GET] ====== CONSULTAR TODOS LOS EQUIPOS ======");
        List<Equipo> equipos = servicioEquipo.buscarEquipo();
        logger.info("✅ Total de equipos encontrados: {}", equipos.size());
        logger.info("📄 Datos: {}", equipos);
        logger.info("===============================================\n");
        return equipos;
    }

    @GetMapping("/{id}")
    public Equipo obtenerEquipo(@PathVariable Long id) {
        logger.info("\n🔍 [GET] ====== CONSULTAR EQUIPO POR ID ======");
        logger.info("🆔 ID recibido: {}", id);
        Equipo equipo = servicioEquipo.obtenerEquipoPorId(id);
        logger.info("📄 Equipo encontrado: {}", equipo);
        logger.info("=============================================\n");
        return equipo;
    }

    @PostMapping
    public Equipo guardarEquipo(@RequestBody Equipo equipo) {
        logger.info("\n📝 [POST] ====== GUARDAR NUEVO EQUIPO ======");
        logger.info("📥 Datos recibidos: {}", equipo);
        Equipo guardado = servicioEquipo.guardarEquipo(equipo);
        logger.info("✅ Equipo guardado exitosamente: {}", guardado);
        logger.info("==========================================\n");
        return guardado;
    }

    @PutMapping
    public Equipo actualizarEquipo(@RequestBody Equipo equipo) {
        logger.info("\n✏️ [PUT] ====== ACTUALIZAR EQUIPO ======");
        Equipo actual = servicioEquipo.obtenerEquipoPorId(equipo.getId());
        logger.info("📌 Datos actuales: {}", actual);
        logger.info("📥 Nuevos datos: {}", equipo);
        Equipo actualizado = servicioEquipo.actualizarEquipo(equipo);
        logger.info("✅ Actualización completada: {}", actualizado);
        logger.info("========================================\n");
        return actualizado;
    }

    @DeleteMapping
    public void borrarEquipo(@RequestParam Long id) {
        logger.info("\n🗑️ [DELETE] ====== ELIMINAR EQUIPO ======");
        logger.info("🆔 ID a eliminar: {}", id);
        servicioEquipo.borrarEquipo(id);
        logger.info("✅ Equipo eliminado exitosamente");
        logger.info("=====================================\n");
    }

}
