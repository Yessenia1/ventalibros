package com.example.msventa.entity;

import com.example.msventa.dto.CustomerDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fecha;
    private String total;

    @Transient
    private CustomerDto customerDto;
}
