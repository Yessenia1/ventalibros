package com.example.msinventario.service;

import com.example.msinventario.entity.Libro;

import java.util.List;
import java.util.Optional;

public interface LibroService {
    public List<Libro> listar();

    public Libro guardar(Libro producto);

    public Optional<Libro> buscarPorId(Integer id);

    public Libro actualizar(Libro producto);

    public void eliminar(Integer id);
}
