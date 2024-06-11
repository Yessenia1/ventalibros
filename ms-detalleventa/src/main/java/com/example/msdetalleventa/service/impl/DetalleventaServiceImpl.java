package com.example.msdetalleventa.service.impl;

import com.example.msdetalleventa.entity.Detalleventa;
import com.example.msdetalleventa.repository.DetalleventaRepository;
import com.example.msdetalleventa.service.DetalleventaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleventaServiceImpl implements DetalleventaService {
    @Autowired
    private DetalleventaRepository detalleventaRepository;

    @Override
    public List<Detalleventa> listar() {
        return detalleventaRepository.findAll();
    }

    @Override
    public Detalleventa guardar(Detalleventa detalleventa) {
        return detalleventaRepository.save(detalleventa);
    }

    @Override
    public Detalleventa actualizar(Detalleventa detalleventa) {
        return detalleventaRepository.save(detalleventa);
    }

    @Override
    public Optional<Detalleventa> listarPorId(Integer id) {
        return detalleventaRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        detalleventaRepository.deleteById(id);
    }
}
