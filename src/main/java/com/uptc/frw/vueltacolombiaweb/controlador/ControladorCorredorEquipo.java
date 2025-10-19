package com.uptc.frw.vueltacolombiaweb.controlador;

import com.uptc.frw.vueltacolombiaweb.modelo.CorredorEquipo;
import com.uptc.frw.vueltacolombiaweb.modelo.ParticipacionEquipo;
import com.uptc.frw.vueltacolombiaweb.servicio.ServicioCorredor;
import com.uptc.frw.vueltacolombiaweb.servicio.ServicioCorredorEquipo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("corredorEquipos")
public class ControladorCorredorEquipo {

    private static final Logger logger = LoggerFactory.getLogger(ServicioCorredorEquipo.class);

    @Autowired
    private ServicioCorredorEquipo servicioCorredorEquipo;

    @GetMapping
    public List<CorredorEquipo> obtenerCorredoresEquipo() {
        logger.info("\n📥 [GET] ====== CONSULTAR TODOS LOS CORREDORES-EQUIPO ======");
        List<CorredorEquipo> lista = servicioCorredorEquipo.buscarCorredorEquipo();
        logger.info("✅ Total de registros encontrados: {}", lista.size());
        logger.info("📄 Datos: {}", lista);
        logger.info("==========================================================\n");
        return lista;
    }

    @GetMapping("/{id}")
    public CorredorEquipo obtenerCorredorEquipo(@PathVariable Long id) {
        logger.info("\n🔍 [GET] ====== CONSULTAR CORREDOR-EQUIPO POR ID ======");
        logger.info("🆔 ID recibido: {}", id);
        CorredorEquipo corredorEquipo = servicioCorredorEquipo.obtenerCorredorEquipoPorId(id);
        logger.info("📄 Registro encontrado: {}", corredorEquipo);
        logger.info("=======================================================\n");
        return corredorEquipo;
    }

    @PostMapping
    public CorredorEquipo guardarCorredorEquipo(@RequestBody CorredorEquipo corredorEquipo) {
        logger.info("\n📝 [POST] ====== GUARDAR NUEVO CORREDOR-EQUIPO ======");
        logger.info("📥 Datos recibidos: {}", corredorEquipo);
        CorredorEquipo guardado = servicioCorredorEquipo.guardarCorredorEquipo(corredorEquipo);
        logger.info("✅ Registro guardado exitosamente: {}", guardado);
        logger.info("=====================================================\n");
        return guardado;
    }

    @PutMapping
    public CorredorEquipo actualizarCorredorEquipo(@RequestBody CorredorEquipo corredorEquipo) {
        logger.info("\n✏️ [PUT] ====== ACTUALIZAR CORREDOR-EQUIPO ======");
        CorredorEquipo actual = servicioCorredorEquipo.obtenerCorredorEquipoPorId(corredorEquipo.getId());
        logger.info("📌 Datos actuales: {}", actual);
        logger.info("📥 Nuevos datos: {}", corredorEquipo);
        CorredorEquipo actualizado = servicioCorredorEquipo.actualizarCorredorEquipo(corredorEquipo);
        logger.info("✅ Actualización completada: {}", actualizado);
        logger.info("=================================================\n");
        return actualizado;
    }

    @DeleteMapping
    public void borrarCorredorEquipo(@RequestParam Long id) {
        logger.info("\n🗑️ [DELETE] ====== ELIMINAR CORREDOR-EQUIPO ======");
        logger.info("🆔 ID a eliminar: {}", id);
        servicioCorredorEquipo.borrarCorredorEquipo(id);
        logger.info("✅ Registro eliminado exitosamente");
        logger.info("===============================================\n");
    }
}
