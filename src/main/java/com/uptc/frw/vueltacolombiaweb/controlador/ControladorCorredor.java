package com.uptc.frw.vueltacolombiaweb.controlador;

import com.uptc.frw.vueltacolombiaweb.modelo.Corredor;
import com.uptc.frw.vueltacolombiaweb.servicio.ServicioCorredor;
import com.uptc.frw.vueltacolombiaweb.servicio.ServicioPatrocinador;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("corredores")
public class ControladorCorredor {

    private static final Logger logger = LoggerFactory.getLogger(ServicioCorredor.class);

    @Autowired
    private ServicioCorredor servicioCorredor;

    @GetMapping
    public List<Corredor> obtenerCorredores() {
        logger.info("\n📥 [GET] ====== CONSULTAR TODOS LOS CORREDORES ======");
        List<Corredor> corredores = servicioCorredor.buscarCorredor();
        logger.info("✅ Total de corredores encontrados: {}", corredores.size());
        logger.info("📄 Datos: {}", corredores);
        logger.info("====================================================\n");
        return corredores;
    }

    @GetMapping("/{id}")
    public Corredor obtenerCorredor(@PathVariable Long id) {
        logger.info("\n🔍 [GET] ====== CONSULTAR CORREDOR POR ID ======");
        logger.info("🆔 ID recibido: {}", id);
        Corredor corredor = servicioCorredor.obtenerCorredoresPorId(id);
        logger.info("📄 Corredor encontrado: {}", corredor);
        logger.info("================================================\n");
        return corredor;
    }

    @PostMapping
    public Corredor guardarCorredor(@RequestBody Corredor corredor) {
        logger.info("\n📝 [POST] ====== GUARDAR NUEVO CORREDOR ======");
        logger.info("📥 Datos recibidos: {}", corredor);
        Corredor guardado = servicioCorredor.guardarCorredor(corredor);
        logger.info("✅ Corredor guardado exitosamente: {}", guardado);
        logger.info("==============================================\n");
        return guardado;
    }

    @PutMapping
    public Corredor actualizarCorredor(@RequestBody Corredor corredor) {
        logger.info("\n✏️ [PUT] ====== ACTUALIZAR CORREDOR ======");
        Corredor actual = servicioCorredor.obtenerCorredoresPorId(corredor.getId());
        logger.info("📌 Datos actuales: {}", actual);
        logger.info("📥 Nuevos datos: {}", corredor);
        Corredor actualizado = servicioCorredor.actualizarCorredor(corredor);
        logger.info("✅ Actualización completada: {}", actualizado);
        logger.info("===========================================\n");
        return actualizado;
    }

    @DeleteMapping
    public void borrarCorredor(@RequestParam Long id) {
        logger.info("\n🗑️ [DELETE] ====== ELIMINAR CORREDOR ======");
        logger.info("🆔 ID a eliminar: {}", id);
        servicioCorredor.borrarCorredor(id);
        logger.info("✅ Corredor eliminado exitosamente");
        logger.info("======================================\n");
    }

}
