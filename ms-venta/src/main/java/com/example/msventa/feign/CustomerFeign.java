package com.example.msventa.feign;

import com.example.msventa.dto.CustomerDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-customer-service",path = "/customer")
public interface CustomerFeign {
    @GetMapping("/{id}")
    @CircuitBreaker(name = "productoListarPorIdCB", fallbackMethod = "fallbackProductoPorId")
    public ResponseEntity<CustomerDto> listarPorId(@PathVariable(required = true) CustomerDto id);
    default ResponseEntity<CustomerDto> fallbackProductoPorId(Integer id, Exception e) {
        return ResponseEntity.ok(new CustomerDto());
    }
}
