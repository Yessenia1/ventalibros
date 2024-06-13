package com.example.msinventario.service;

import com.example.msinventario.entity.Inventario;

import java.util.List;
import java.util.Optional;

public interface InventarioService {

    public List<Inventario> listar();
    public Inventario guardar(Inventario inventario);
    public Inventario buscarPorId(Integer id);
    public Inventario editar(Inventario inventario);
    public void eliminar(Integer id);
}
