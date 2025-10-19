package com.uptc.frw.vueltacolombiaweb.controlador;

import com.uptc.frw.vueltacolombiaweb.modelo.Etapa;
import com.uptc.frw.vueltacolombiaweb.modelo.Resultado;
import com.uptc.frw.vueltacolombiaweb.servicio.ServicioPatrocinador;
import com.uptc.frw.vueltacolombiaweb.servicio.ServicioResultado;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("resultados")
public class ControladorResultado {

    private static final Logger logger = LoggerFactory.getLogger(ServicioResultado.class);
    @Autowired
    private ServicioResultado servicioResultado;

    @GetMapping
    public List<Resultado> obtenerResultados() {
        logger.info("\n📥 [GET] ====== CONSULTAR TODOS LOS RESULTADOS ======");
        List<Resultado> resultados = servicioResultado.buscarResultado();
        logger.info("✅ Total de resultados encontrados: {}", resultados.size());
        logger.info("📄 Datos: {}", resultados);
        logger.info("===================================================\n");
        return resultados;
    }

    @GetMapping("/{id}")
    public Resultado obtenerResultado(@PathVariable Long id) {
        logger.info("\n🔍 [GET] ====== CONSULTAR RESULTADO POR ID ======");
        logger.info("🆔 ID recibido: {}", id);
        Resultado resultado = servicioResultado.obtenerResultadoPorId(id);
        logger.info("📄 Resultado encontrado: {}", resultado);
        logger.info("================================================\n");
        return resultado;
    }

    @PostMapping
    public Resultado guardarResultado(@RequestBody Resultado resultado) {
        logger.info("\n📝 [POST] ====== GUARDAR NUEVO RESULTADO ======");
        logger.info("📥 Datos recibidos: {}", resultado);
        Resultado guardado = servicioResultado.guardarResultado(resultado);
        logger.info("✅ Resultado guardado exitosamente: {}", guardado);
        logger.info("=============================================\n");
        return guardado;
    }

    @PutMapping
    public Resultado actualizarResultado(@RequestBody Resultado resultado) {
        logger.info("\n✏️ [PUT] ====== ACTUALIZAR RESULTADO ======");
        Resultado actual = servicioResultado.obtenerResultadoPorId(resultado.getId());
        logger.info("📌 Datos actuales: {}", actual);
        logger.info("📥 Nuevos datos: {}", resultado);
        Resultado actualizado = servicioResultado.actualizarResultado(resultado);
        logger.info("✅ Actualización completada: {}", actualizado);
        logger.info("==========================================\n");
        return actualizado;
    }

    @DeleteMapping
    public void borrarResultado(@RequestParam Long id) {
        logger.info("\n🗑️ [DELETE] ====== ELIMINAR RESULTADO ======");
        logger.info("🆔 ID a eliminar: {}", id);
        servicioResultado.borrarResultado(id);
        logger.info("✅ Resultado eliminado exitosamente");
        logger.info("=====================================\n");
    }
}
