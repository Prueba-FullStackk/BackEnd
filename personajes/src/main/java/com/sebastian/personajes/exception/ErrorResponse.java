package com.sebastian.personajes.exception;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public class ErrorResponse {

    private String mensaje;
    private int status;
    private LocalDateTime fecha;

    public ErrorResponse(String mensaje, int status) {
        this.mensaje = mensaje;
        this.status = status;
        this.fecha = LocalDateTime.now();
    }

    public String getMensaje() {
        return mensaje;
    }

    public int getStatus() {
        return status;
    }

    public LocalDateTime getFecha(){
        return fecha;
    }
}
