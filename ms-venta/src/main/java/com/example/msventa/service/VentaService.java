package com.example.msventa.service;

import com.example.msventa.entity.Venta;

import java.util.Dictionary;
import java.util.List;
import java.util.Optional;

public interface VentaService {
    public List<Venta> listar();

    public Venta guardar(Venta pedido);

    public Optional<Venta> buscarPorId(Integer id);

    public Venta actualizar(Venta pedido);

    public void eliminar(Integer id);
}
