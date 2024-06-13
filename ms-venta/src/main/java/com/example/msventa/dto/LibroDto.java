package com.example.msventa.dto;

import lombok.Data;

@Data
public class LibroDto {
    private Integer id;
    private String nombre;

    private InventarioDto categoria;
}
