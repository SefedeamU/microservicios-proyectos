package com.example.microservicio_proyectos.repository;

import com.example.microservicio_proyectos.model.UsuarioProyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioProyectoRepository extends JpaRepository<UsuarioProyecto, Long> {
}