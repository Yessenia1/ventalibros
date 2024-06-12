package com.example.msbook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements com.example.msbook.service.BookService {
    @Autowired
    private com.example.msbook.repository.BookRepository bookRepository;
    @Override
    public List<com.example.msbook.entity.Book> listar() {
        return bookRepository.findAll();
    }

    @Override
    public com.example.msbook.entity.Book guardar(com.example.msbook.entity.Book book) {
        return bookRepository.save(book);
    }

    @Override
    public com.example.msbook.entity.Book buscarPorId(Integer id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public com.example.msbook.entity.Book editar(com.example.msbook.entity.Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void eliminar(Integer id) {
        bookRepository.deleteById(id);
    }
}
