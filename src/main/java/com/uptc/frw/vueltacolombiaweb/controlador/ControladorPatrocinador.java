package com.uptc.frw.vueltacolombiaweb.controlador;

import com.uptc.frw.vueltacolombiaweb.modelo.Edicion;
import com.uptc.frw.vueltacolombiaweb.modelo.Patrocinador;
import com.uptc.frw.vueltacolombiaweb.servicio.ServicioPatrocinador;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("patrocinadores")
public class ControladorPatrocinador {

    private static final Logger logger = LoggerFactory.getLogger(ServicioPatrocinador.class);

    @Autowired
    private ServicioPatrocinador servicioPatrocinador;

    @GetMapping
    public List<Patrocinador> obtenerPatrocinadores() {
        logger.info("\n📥 [GET] ====== CONSULTAR TODOS LOS PATROCINADORES ======");
        List<Patrocinador> patrocinadores = servicioPatrocinador.buscarPatrocinador();
        logger.info("✅ Total de patrocinadores encontrados: {}", patrocinadores.size());
        logger.info("📄 Datos: {}", patrocinadores);
        logger.info("========================================================\n");
        return patrocinadores;
    }

    @GetMapping("/{id}")
    public Patrocinador obtenerPatrocinador(@PathVariable Long id) {
        logger.info("\n🔍 [GET] ====== CONSULTAR PATROCINADOR POR ID ======");
        logger.info("🆔 ID recibido: {}", id);
        Patrocinador patrocinador = servicioPatrocinador.obtenerPatrocinadorPorId(id);
        logger.info("📄 Patrocinador encontrado: {}", patrocinador);
        logger.info("====================================================\n");
        return patrocinador;
    }

    @PostMapping
    public Patrocinador guardarPatrocinador(@RequestBody Patrocinador patrocinador) {
        logger.info("\n📝 [POST] ====== GUARDAR NUEVO PATROCINADOR ======");
        logger.info("📄 Datos recibidos: {}", patrocinador);
        Patrocinador guardado = servicioPatrocinador.guardarPatrocinador(patrocinador);
        logger.info("✅ Patrocinador guardado exitosamente: {}", guardado);
        logger.info("=================================================\n");
        return guardado;
    }

    @PostMapping("/lista")
    public List<Patrocinador> guardarPatrocinadores(@RequestBody List<Patrocinador> patrocinadores) {
        List<Patrocinador> guardados = servicioPatrocinador.guardarPatrocinadores(patrocinadores);
        return guardados;
    }

    @PutMapping
    public Patrocinador actualizarPatrocinador(@RequestBody Patrocinador patrocinador) {
        logger.info("\n✏️ [PUT] ====== ACTUALIZAR PATROCINADOR ======");
        Patrocinador actual = servicioPatrocinador.obtenerPatrocinadorPorId(patrocinador.getId());
        logger.info("📌 Datos actuales: {}", actual);
        logger.info("📥 Nuevos datos: {}", patrocinador);
        Patrocinador actualizado = servicioPatrocinador.actualizarPatrocinador(patrocinador);
        logger.info("✅ Actualización completada: {}", actualizado);
        logger.info("=============================================\n");
        return actualizado;
    }

    @DeleteMapping
    public void borrarPatrocinador(@RequestParam Long id) {
        logger.info("\n🗑️ [DELETE] ====== ELIMINAR PATROCINADOR ======");
        logger.info("🆔 ID a eliminar: {}", id);
        servicioPatrocinador.borrarPatrocinador(id);
        logger.info("✅ Patrocinador eliminado exitosamente");
        logger.info("===========================================\n");
    }
}
