package com.example.Pipeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UsuarioController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/buscar")
    public List<Map<String, Object>> buscarUsuario(@RequestParam String nombre) {
        // CÓDIGO SEGURO: Uso de consultas parametrizadas (?) para evitar Inyección SQL
        String sql = "SELECT * FROM usuarios WHERE nombre = ?";

        // JdbcTemplate se encarga de sanitizar el parámetro 'nombre' de forma segura
        return jdbcTemplate.queryForList(sql, nombre);
    }
}