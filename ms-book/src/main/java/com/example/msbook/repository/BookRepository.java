package com.example.msbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<com.example.msbook.entity.Book,Integer> {
}
