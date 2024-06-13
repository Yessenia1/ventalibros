package com.example.msventa.controller;

import com.example.msventa.entity.Venta;
import com.example.msventa.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venta")
public class VentaController {
    @Autowired
    private VentaService ventaService;

    @GetMapping
    public ResponseEntity<List<Venta>> listar() {
        return ResponseEntity.ok(ventaService.listar());
    }

    @PostMapping
    public ResponseEntity<Venta> guardar(@RequestBody Venta venta) {
        return ResponseEntity.ok(ventaService.guardar(venta));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> buscarPOrId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok(ventaService.buscarPorId(id).get());
    }

    @PutMapping
    public ResponseEntity<Venta> actualizar(@RequestBody Venta venta) {
        return ResponseEntity.ok(ventaService.actualizar(venta));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Venta>> eliminar(@PathVariable(required = true) Integer id) {
        ventaService.eliminar(id);
        return ResponseEntity.ok(ventaService.listar());
    }
}
