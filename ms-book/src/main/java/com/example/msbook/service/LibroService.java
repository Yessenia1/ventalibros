package com.example.msbook.service;

import com.example.msbook.entity.Libro;

import java.util.List;

public interface LibroService {
    List<Libro> listar();
    Libro guardar(Libro libro);
    Libro editar(Libro libro, Integer id);
    void eliminar(Integer id);
}
