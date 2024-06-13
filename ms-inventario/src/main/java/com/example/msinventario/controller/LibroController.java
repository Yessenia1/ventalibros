package com.example.msinventario.controller;

import com.example.msinventario.entity.Libro;
import com.example.msinventario.service.LibroService;
import com.example.msinventario.util.PdfUtils;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/libro")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping
    public ResponseEntity<List<Libro>> listar() {
        return ResponseEntity.ok(libroService.listar());
    }

    @PostMapping
    public ResponseEntity<Libro> guardar(@RequestBody Libro producto) {
        return ResponseEntity.ok(libroService.guardar(producto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> buscarPOrId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok(libroService.buscarPorId(id).get());
    }

    @PutMapping
    public ResponseEntity<Libro> actualizar(@RequestBody Libro libro) {
        return ResponseEntity.ok(libroService.actualizar(libro));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Libro>> eliminar(@PathVariable(required = true) Integer id) {
        libroService.eliminar(id);
        return ResponseEntity.ok(libroService.listar());
    }
}
