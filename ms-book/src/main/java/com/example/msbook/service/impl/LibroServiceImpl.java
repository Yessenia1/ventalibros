package com.example.msbook.service.impl;

import com.example.msbook.entity.Libro;
import com.example.msbook.repository.LibroRepository;
import com.example.msbook.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {
    @Autowired
    private LibroRepository libroRepository;

    @Override
    public List<Libro> listar() {
        return libroRepository.findAll();
    }

    @Override
    public Libro guardar(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Libro editar(Libro libro, Integer id) {
        if (libroRepository.existsById(id)) {
            libro.setId(id);
            return libroRepository.save(libro);
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        libroRepository.deleteById(id);
    }
}
