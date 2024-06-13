package com.example.msventa.service.impl;

import com.example.msventa.entity.Venta;
import com.example.msventa.entity.VentaDetalle;
import com.example.msventa.feign.CustomerFeign;
import com.example.msventa.feign.LibroFeign;
import com.example.msventa.repository.VentaRepository;
import com.example.msventa.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaServiceImpl implements VentaService {
    @Autowired
    VentaRepository ventaRepository;
    @Autowired
    private CustomerFeign customerFeign;
    @Autowired
    private LibroFeign libroFeign;
    @Override
    public List<Venta> listar() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta guardar(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public Optional<Venta> buscarPorId(Integer id) {
        Venta venta = ventaRepository.findById(id).get();
        venta.setCustomerDto(customerFeign.busacarPorId(venta.getCustomerDto().getId()).getBody());
        /*for (PedidoDetalle pedidoDetalle: pedido.getDetalle()){
            pedidoDetalle.setProductoDto(productoFeign.buscarPOrId(ventaDetalle.getLibroId()).getBody());
        }*/
        List<VentaDetalle>ventaDetalles = venta.getDetalle().stream().map(ventaDetalle -> {
            ventaDetalle.setLibroDto(libroFeign.buscarPorId(ventaDetalle.getLibroId()).getBody());
            return ventaDetalle;
        }).toList();
        venta.setDetalle(ventaDetalles);
        return ventaRepository.findById(id);
    }

    @Override
    public Venta actualizar(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public void eliminar(Integer id) {
        ventaRepository.deleteById(id);

    }
}
