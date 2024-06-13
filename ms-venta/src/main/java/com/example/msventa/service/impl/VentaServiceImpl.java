package com.example.msventa.service.impl;

import com.example.msventa.entity.Venta;
import com.example.msventa.feign.CustomerFeign;
import com.example.msventa.repository.VentaRepository;
import com.example.msventa.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaServiceImpl implements VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private CustomerFeign customerFeign;

    @Override
    public List<Venta> listar() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta guardar(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public Venta actualizar(Venta venta) {
        return ventaRepository.save(venta);
    }


    @Override
    public Venta listarPorId(Integer id) {
        Venta venta = ventaRepository.findById(id).get();
        venta.setCustomer(customerFeign.listarPorId(venta.getCustomer()).getBody());
        return venta;
    }

    @Override
    public void eliminarPorId(Integer id) {
        ventaRepository.deleteById(id);
    }
}
