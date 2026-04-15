package com.sebastian.personajes.service;

import com.sebastian.personajes.exception.RecursoNoEncontradoException;
import com.sebastian.personajes.model.Personaje;
import com.sebastian.personajes.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.PresentationDirection;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PersonajeService {

    @Autowired
    private PersonajeRepository repository;

    //  Listar Con Orden
    @Cacheable("personajes")
    public List<Personaje> listar(String orden){
        if ("nombre".equalsIgnoreCase(orden)) {
            return repository.findAll(Sort.by("nombre"));
        }
        return repository.findAll(Sort.by("fechaCreacion"));
    }

    //  Crear
    @CacheEvict(value = "personajes", allEntries = true)
    public Personaje crear(Personaje personaje){
        personaje.setFechaCreacion(LocalDateTime.now());
        return repository.save(personaje);
    }

    //  Obtener Con ID
    public Personaje obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new RecursoNoEncontradoException("Personaje no encontrado con ID: " + id));
    }

    //  Actualizar
    @CacheEvict(value = "personajes", allEntries = true)
    public Personaje actualizar(Long id, Personaje nuevo) {
        Personaje existente = obtenerPorId(id);

        existente.setNombre(nuevo.getNombre());
        existente.setIdentificacion(nuevo.getIdentificacion());
        existente.setImagen(nuevo.getImagen());
        existente.setRol(nuevo.getRol());
        existente.setDescripcion(nuevo.getDescripcion());

        return repository.save(existente);
    }

    //  Eliminar
    @CacheEvict(value = "personajes", allEntries = true)
    public void eliminar(Long id){
        Personaje personaje = obtenerPorId(id);
        repository.delete(personaje);
    }
}
