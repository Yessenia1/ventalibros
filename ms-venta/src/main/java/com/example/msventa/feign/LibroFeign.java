package com.example.msventa.feign;

import com.example.msventa.dto.LibroDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-inventario-service",path = "/libro")
public interface LibroFeign {
    @GetMapping("/{id}")
    @CircuitBreaker(name = "libroListarPorIdCB", fallbackMethod = "fallbackLibroPorId")
    public ResponseEntity<LibroDto> buscarPorId(@PathVariable(required = true) Integer id);
    default ResponseEntity<LibroDto> fallbackLibroPorId(Integer id, Exception e) {
        return ResponseEntity.ok(new LibroDto());
    }
}
