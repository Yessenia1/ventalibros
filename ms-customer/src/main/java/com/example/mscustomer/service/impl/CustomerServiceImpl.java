package com.example.mscustomer.service.impl;

import com.example.mscustomer.entity.Customer;
import com.example.mscustomer.repository.CustomerRepository;
import com.example.mscustomer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> listar() {
        return customerRepository.findAll();
    }

    @Override
    public Customer guardar(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer actualizar(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> listarPorId(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        customerRepository.deleteById(id);
    }
}
