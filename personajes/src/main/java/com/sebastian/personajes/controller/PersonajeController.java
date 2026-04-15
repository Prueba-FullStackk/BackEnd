package com.sebastian.personajes.controller;

import com.sebastian.personajes.model.Personaje;
import com.sebastian.personajes.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personajes")
@CrossOrigin(origins = "http://localhost:3000")
public class PersonajeController {

    @Autowired
    private PersonajeService service;

    //  Listar
    @GetMapping
    public List<Personaje> crear(@RequestParam(defaultValue = "fecha") String orden){
        return service.listar(orden);
    }

    //  Crear
    @PostMapping
    public Personaje crear (@RequestBody Personaje personaje) {
        return service.crear(personaje);
    }

    //  Obtener ID
    @GetMapping("/{id}")
    public Personaje obtener (@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    //  Actualizar
    @PutMapping("/{id}")
    public Personaje actualizar(@PathVariable Long id, @RequestBody Personaje personaje) {
        return service.actualizar(id, personaje);
    }

    //  Eliminar
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
