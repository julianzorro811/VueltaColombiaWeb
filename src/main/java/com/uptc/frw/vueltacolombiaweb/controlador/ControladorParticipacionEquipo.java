package com.uptc.frw.vueltacolombiaweb.controlador;

import com.uptc.frw.vueltacolombiaweb.modelo.Etapa;
import com.uptc.frw.vueltacolombiaweb.modelo.ParticipacionEquipo;
import com.uptc.frw.vueltacolombiaweb.servicio.ServicioEtapa;
import com.uptc.frw.vueltacolombiaweb.servicio.ServicioParticipacionEquipo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("participacionEquipos")
public class ControladorParticipacionEquipo {

    private static final Logger logger = LoggerFactory.getLogger(ServicioParticipacionEquipo.class);

    @Autowired
    private ServicioParticipacionEquipo servicioParticipacionEquipo;

    @GetMapping
    public List<ParticipacionEquipo> obtenerParticipacionEquipos() {
        logger.info("\n📥 [GET] ====== CONSULTAR TODAS LAS PARTICIPACIONES DE EQUIPOS ======");
        List<ParticipacionEquipo> lista = servicioParticipacionEquipo.buscarParticipacionEquipo();
        logger.info("✅ Total de participaciones encontradas: {}", lista.size());
        logger.info("📄 Datos: {}", lista);
        logger.info("=================================================================\n");
        return lista;
    }

    @GetMapping("/{id}")
    public ParticipacionEquipo obtenerParticipacionEquipo(@PathVariable Long id) {
        logger.info("\n🔍 [GET] ====== CONSULTAR PARTICIPACIÓN DE EQUIPO POR ID ======");
        logger.info("🆔 ID recibido: {}", id);
        ParticipacionEquipo participacion = servicioParticipacionEquipo.obtenerParticipacionEquipoPorId(id);
        logger.info("📄 Participación encontrada: {}", participacion);
        logger.info("=============================================================\n");
        return participacion;
    }

    @PostMapping
    public ParticipacionEquipo guardarParticipacionEquipo(@RequestBody ParticipacionEquipo participacionEquipo) {
        logger.info("\n📝 [POST] ====== GUARDAR NUEVA PARTICIPACIÓN DE EQUIPO ======");
        logger.info("📥 Datos recibidos: {}", participacionEquipo);
        ParticipacionEquipo guardado = servicioParticipacionEquipo.guardarParticipacionEquipo(participacionEquipo);
        logger.info("✅ Participación guardada exitosamente: {}", guardado);
        logger.info("===========================================================\n");
        return guardado;
    }

    @PutMapping
    public ParticipacionEquipo actualizarParticipacionEquipo(@RequestBody ParticipacionEquipo participacionEquipo) {
        logger.info("\n✏️ [PUT] ====== ACTUALIZAR PARTICIPACIÓN DE EQUIPO ======");
        ParticipacionEquipo actual = servicioParticipacionEquipo.obtenerParticipacionEquipoPorId(participacionEquipo.getId());
        logger.info("📌 Datos actuales: {}", actual);
        logger.info("📥 Nuevos datos: {}", participacionEquipo);
        ParticipacionEquipo actualizado = servicioParticipacionEquipo.actualizarParticipacionEquipo(participacionEquipo);
        logger.info("✅ Actualización completada: {}", actualizado);
        logger.info("=========================================================\n");
        return actualizado;
    }

    @DeleteMapping
    public void borrarParticipacionEquipo(@RequestParam Long id) {
        logger.info("\n🗑️ [DELETE] ====== ELIMINAR PARTICIPACIÓN DE EQUIPO ======");
        logger.info("🆔 ID a eliminar: {}", id);
        servicioParticipacionEquipo.borrarParticionacionEquipo(id);
        logger.info("✅ Participación eliminada exitosamente");
        logger.info("=====================================================\n");
    }
}
