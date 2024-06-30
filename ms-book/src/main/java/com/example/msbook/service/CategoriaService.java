package com.example.msbook.service;

import com.example.msbook.entity.Categoria;

import java.util.List;

public interface CategoriaService {
    public List<Categoria> listar();
    public Categoria guardar(Categoria categoria);
    public Categoria editar(Categoria categoria, Integer id);
    public void eliminar(Integer id);


}
