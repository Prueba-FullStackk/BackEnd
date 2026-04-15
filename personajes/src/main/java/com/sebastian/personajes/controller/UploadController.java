package com.sebastian.personajes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@RestController
@RequestMapping("/api/upload")
@CrossOrigin(origins = "*")
public class UploadController {

    @PostMapping
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {

        try {
            System.out.println("Entró al endpoint");

            //  Validar archivo
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("Archivo vacío");
            }

            //  Ruta ABSOLUTA (FIX DEFINITIVO)
            String uploadPath = System.getProperty("user.dir") + File.separator + "uploads";

            File dir = new File(uploadPath);
            if (!dir.exists()) {
                boolean created = dir.mkdirs();
                System.out.println("Carpeta creada: " + created);
            }

            //  Nombre único
            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

            File dest = new File(dir, fileName);

            // Guardar archivo
            file.transferTo(dest);

            // Retornar URL
            String url = "http://localhost:8080/uploads/" + fileName;

            System.out.println("Archivo subido correctamente: " + url);

            return ResponseEntity.ok(url);

        } catch (Exception e) {
            System.out.println("ERROR AL SUBIR ARCHIVO");
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al subir archivo: " + e.getMessage());
        }
    }
}