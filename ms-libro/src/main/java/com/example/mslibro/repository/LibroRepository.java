package com.example.mslibro.repository;

import com.example.mslibro.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Integer>{
}
