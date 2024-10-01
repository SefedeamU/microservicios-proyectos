package com.example.microservicio_proyectos.controller;

import com.example.microservicio_proyectos.model.UsuarioProyecto;
import com.example.microservicio_proyectos.service.UsuarioProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios_proyectos")
public class UsuarioProyectoController {

    @Autowired
    private UsuarioProyectoService usuarioProyectoService;

    @GetMapping
    public List<UsuarioProyecto> obtenerTodosLosUsuariosProyectos() {
        return usuarioProyectoService.obtenerTodosLosUsuariosProyectos();
    }

    @PostMapping
    public UsuarioProyecto crearUsuarioProyecto(@RequestBody UsuarioProyecto usuarioProyecto) {
        return usuarioProyectoService.crearUsuarioProyecto(usuarioProyecto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioProyecto> obtenerUsuarioProyectoPorId(@PathVariable Long id) {
        Optional<UsuarioProyecto> usuarioProyecto = usuarioProyectoService.obtenerUsuarioProyectoPorId(id);
        return usuarioProyecto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioProyecto> actualizarUsuarioProyecto(@PathVariable Long id, @RequestBody UsuarioProyecto usuarioProyectoActualizado) {
        try {
            UsuarioProyecto usuarioProyecto = usuarioProyectoService.actualizarUsuarioProyecto(id, usuarioProyectoActualizado);
            return ResponseEntity.ok(usuarioProyecto);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuarioProyecto(@PathVariable Long id) {
        usuarioProyectoService.eliminarUsuarioProyecto(id);
        return ResponseEntity.noContent().build();
    }
}