package com.example.msauth.service.impl;

import com.example.msauth.entity.AuthUser;
import com.example.msauth.repository.AuthUserRepository;
import com.example.msauth.service.VinculacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VinculacionServiceImpl implements VinculacionService {
    @Autowired
    AuthUserRepository authRepository;
    @Override
    public AuthUser vincularcliente (Integer id) {

    }
    @Override
    public AuthUser vincularvendedor (Integer id){

    }
}
