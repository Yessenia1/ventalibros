package com.example.mscustomer.service;

import com.example.mscustomer.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public List<Customer> listar();

    public Customer guardar(Customer customer);

    public Customer actualizar(Customer customer);

    public Optional<Customer> listarPorId(Integer id);

    public void eliminarPorId(Integer id);
}
