package com.example.mscustomer.controller;

import com.example.mscustomer.entity.Customer;
import com.example.mscustomer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public ResponseEntity<List<Customer>> list() {
        return ResponseEntity.ok().body(customerService.listar());
    }
    @PostMapping()
    public ResponseEntity<Customer> save(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.guardar(customer));
    }
    @PutMapping()
    public ResponseEntity<Customer> actualizar(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.actualizar(customer));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> listarPorId(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok().body(customerService.listarPorId(id).get());
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id){
        customerService.eliminarPorId(id);
        return "Eliminacion Correcta";
    }
}
