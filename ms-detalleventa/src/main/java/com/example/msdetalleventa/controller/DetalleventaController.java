package com.example.msdetalleventa.controller;

import com.example.msdetalleventa.entity.Detalleventa;
import com.example.msdetalleventa.service.DetalleventaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalleventa")
public class DetalleventaController {
    @Autowired
    private DetalleventaService detalleventaService;

    @GetMapping()
    public ResponseEntity<List<Detalleventa>> list() {
        return ResponseEntity.ok().body(detalleventaService.listar());
    }
    @PostMapping()
    public ResponseEntity<Detalleventa> save(@RequestBody Detalleventa detalleventa){
        return ResponseEntity.ok(detalleventaService.guardar(detalleventa));
    }
    @PutMapping()
    public ResponseEntity<Detalleventa> update(@RequestBody Detalleventa detalleventa){
        return ResponseEntity.ok(detalleventaService.actualizar(detalleventa));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Detalleventa> listById(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok().body(detalleventaService.listarPorId(id).get());
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id){
        detalleventaService.eliminarPorId(id);
        return "Eliminacion Correcta";
    }
}
