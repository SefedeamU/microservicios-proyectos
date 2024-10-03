package com.example.microservicio_proyectos.controller;

import com.example.microservicio_proyectos.model.Proyecto;
import com.example.microservicio_proyectos.model.UsuarioProyecto;
import com.example.microservicio_proyectos.service.ProyectoService;
import com.example.microservicio_proyectos.service.UsuarioProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @Autowired
    private UsuarioProyectoService usuarioProyectoService;

    @GetMapping
    public List<Proyecto> obtenerTodosLosProyectos() {
        return proyectoService.obtenerTodosLosProyectos();
    }

    @PostMapping
    public Proyecto crearProyecto(@RequestBody Proyecto proyecto, @RequestParam Long usuarioId) {
        UsuarioProyecto usuarioProyecto = new UsuarioProyecto();
        usuarioProyecto.setUsuarioId(usuarioId);
        usuarioProyecto.setProyecto(proyecto);
        usuarioProyectoService.crearUsuarioProyecto(usuarioProyecto);

        return proyectoService.crearProyecto(proyecto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> obtenerProyectoPorId(@PathVariable Long id) {
        Optional<Proyecto> proyecto = proyectoService.obtenerProyectoPorId(id);
        return proyecto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proyecto> actualizarProyecto(@PathVariable Long id, @RequestBody Proyecto proyectoActualizado) {
        try {
            Proyecto proyecto = proyectoService.actualizarProyecto(id, proyectoActualizado);
            return ResponseEntity.ok(proyecto);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProyecto(@PathVariable Long id) {
        proyectoService.eliminarProyecto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/usuarios")
    public ResponseEntity<List<UsuarioProyecto>> obtenerUsuariosPorProyecto(@PathVariable Long id) {
        List<UsuarioProyecto> usuariosProyectos = usuarioProyectoService.obtenerUsuariosPorProyectoId(id);
        return ResponseEntity.ok(usuariosProyectos);
    }
}