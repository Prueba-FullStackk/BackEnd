package com.sebastian.personajes.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "personaje")
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(length = 50)
    private String nombre;

    @Column(length = 50)
    private String identificacion;

    private String imagen;

    @Column(length = 50)
    private String rol;

    @Column(length = 500)
    private String descripcion;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    // Constructor vacío
    public Personaje() {}

    // Getters y Setters
    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getIdentificacion() { return identificacion; }

    public void setIdentificacion(String identificacion) { this.identificacion = identificacion; }

    public String getImagen() { return imagen; }

    public void setImagen(String imagen) { this.imagen = imagen; }

    public String getRol() { return rol; }

    public void setRol(String rol) { this.rol = rol; }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }

    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
}