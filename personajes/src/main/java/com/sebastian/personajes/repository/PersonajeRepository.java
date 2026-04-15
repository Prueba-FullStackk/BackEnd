package com.sebastian.personajes.repository;

import com.sebastian.personajes.model.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonajeRepository extends JpaRepository<Personaje, Long> {

}

