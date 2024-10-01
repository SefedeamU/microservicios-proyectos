package com.example.microservicio_proyectos.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "usuarios_proyectos")
@Data
public class UsuarioProyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @ManyToOne
    @JoinColumn(name = "proyecto_id", nullable = false)
    private Proyecto proyecto;

    @Column(name = "rol_id", nullable = false)
    private Long rolId;
}