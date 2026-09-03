package com.example.Pipeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 🚨 VULNERABILIDAD INTENCIONAL PARA EL PIPELINE (SAST) 🚨
    @GetMapping("/buscar")
    public List<Map<String, Object>> buscarUsuario(@RequestParam String nombre) {
        // OWASP Top 10: Inyección SQL por concatenación directa
        String query = "SELECT * FROM usuarios WHERE nombre = '" + nombre + "'";
        return jdbcTemplate.queryForList(query);
    }
}