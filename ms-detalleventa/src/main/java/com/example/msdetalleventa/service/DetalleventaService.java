package com.example.msdetalleventa.service;

import com.example.msdetalleventa.entity.Detalleventa;

import java.util.List;
import java.util.Optional;

public interface DetalleventaService {
    public List<Detalleventa> listar();

    public Detalleventa guardar(Detalleventa detalleventa);

    public Detalleventa actualizar(Detalleventa detalleventa);

    public Optional<Detalleventa> listarPorId(Integer id);

    public void eliminarPorId(Integer id);
}
