package com.example.microservicio_proyectos.service;


import com.example.microservicio_proyectos.model.Proyecto;
import com.example.microservicio_proyectos.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.example.microservicio_proyectos.Dto.TareaDto;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoService {

    private final WebClient.Builder webClientBuilder;

    public ProyectoService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public List<TareaDto> obtenerTareasPorProyecto(Long proyectoId) {
        return webClientBuilder.build()
                .get()
                .uri("http://microservicio_tareas/tareas?proyectoId=" + proyectoId)
                .retrieve()
                .bodyToFlux(TareaDto.class)
                .collectList()
                .block();
    }

    @Autowired
    private ProyectoRepository proyectoRepository;

    public Proyecto crearProyecto(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    public List<Proyecto> obtenerTodosLosProyectos() {
        return proyectoRepository.findAll();
    }

    public Optional<Proyecto> obtenerProyectoPorId(Long id) {
        return proyectoRepository.findById(id);
    }

    public Proyecto actualizarProyecto(Long id, Proyecto proyectoActualizado) {
        return proyectoRepository.findById(id)
                .map(proyecto -> {
                    proyecto.setNombre(proyectoActualizado.getNombre());
                    proyecto.setDescripcion(proyectoActualizado.getDescripcion());
                    proyecto.setFechaInicio(proyectoActualizado.getFechaInicio());
                    proyecto.setFechaFin(proyectoActualizado.getFechaFin());
                    proyecto.setEstado(proyectoActualizado.getEstado());
                    proyecto.setPrioridad(proyectoActualizado.getPrioridad());
                    return proyectoRepository.save(proyecto);
                })
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
    }

    public void eliminarProyecto(Long id) {
        proyectoRepository.deleteById(id);
    }
}