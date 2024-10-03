package com.example.microservicio_proyectos.service;

import com.example.microservicio_proyectos.model.UsuarioProyecto;
import com.example.microservicio_proyectos.repository.UsuarioProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioProyectoService {

    @Autowired
    private UsuarioProyectoRepository usuarioProyectoRepository;

    public UsuarioProyecto crearUsuarioProyecto(UsuarioProyecto usuarioProyecto) {
        return usuarioProyectoRepository.save(usuarioProyecto);
    }

    public List<UsuarioProyecto> obtenerTodosLosUsuariosProyectos() {
        return usuarioProyectoRepository.findAll();
    }

    public List<UsuarioProyecto> obtenerUsuariosPorProyectoId(Long proyectoId) {
        return usuarioProyectoRepository.findByProyectoId(proyectoId);
    }

    public Optional<UsuarioProyecto> obtenerUsuarioProyectoPorId(Long id) {
        return usuarioProyectoRepository.findById(id);
    }

    public UsuarioProyecto actualizarUsuarioProyecto(Long id, UsuarioProyecto usuarioProyectoActualizado) {
        return usuarioProyectoRepository.findById(id)
                .map(usuarioProyecto -> {
                    usuarioProyecto.setUsuarioId(usuarioProyectoActualizado.getUsuarioId());
                    usuarioProyecto.setProyecto(usuarioProyectoActualizado.getProyecto());
                    usuarioProyecto.setRolId(usuarioProyectoActualizado.getRolId());
                    return usuarioProyectoRepository.save(usuarioProyecto);
                })
                .orElseThrow(() -> new RuntimeException("UsuarioProyecto no encontrado"));
    }

    public void eliminarUsuarioProyecto(Long id) {
        usuarioProyectoRepository.deleteById(id);
    }
}