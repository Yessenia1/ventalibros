package com.example.msauth.service;

import com.example.msauth.entity.AuthUser;

public interface VinculacionService {
    public AuthUser vincularcliente (Integer id);
    public AuthUser vincularvendedor (Integer id);
}
