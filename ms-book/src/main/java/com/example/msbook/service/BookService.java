package com.example.msbook.service;

import java.util.List;

public interface BookService {

    public List<com.example.msbook.entity.Book> listar();
    public com.example.msbook.entity.Book guardar(com.example.msbook.entity.Book book);
    public com.example.msbook.entity.Book buscarPorId(Integer id);
    public com.example.msbook.entity.Book editar(com.example.msbook.entity.Book book);
    public void eliminar(Integer id);
}
