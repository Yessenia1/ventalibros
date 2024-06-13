package com.example.msinventario.service.impl;

import com.example.msinventario.entity.Libro;
import com.example.msinventario.repository.LibroRepository;
import com.example.msinventario.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {
    @Autowired
    private LibroRepository libroRepository;


    public List<Libro> listar() {
        return libroRepository.findAll();
    }

    @Override
    public Libro guardar(Libro producto) {
        return libroRepository.save(producto);
    }

    @Override
    public Optional<Libro> buscarPorId(Integer id) {
        return libroRepository.findById(id);
    }

    @Override
    public Libro actualizar(Libro producto) {
        return libroRepository.save(producto);
    }

    @Override
    public void eliminar(Integer id) {
        libroRepository.deleteById(id);
    }

}
