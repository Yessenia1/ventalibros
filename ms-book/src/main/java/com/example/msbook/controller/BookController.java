package com.example.msbook.controller;

import com.example.msbook.util.PdfUtils;
import com.example.msbook.util.UserExcelExporter;
import com.itextpdf.text.DocumentException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private com.example.msbook.service.BookService bookService;

    @GetMapping
    public ResponseEntity<List<com.example.msbook.entity.Book>> listar() {
        return ResponseEntity.ok(bookService.listar());
    }

    @PostMapping
    public ResponseEntity<com.example.msbook.entity.Book> guardar(@RequestBody com.example.msbook.entity.Book book) {
        return ResponseEntity.ok(bookService.guardar(book));
    }

    @GetMapping("/{id}")
    public ResponseEntity<com.example.msbook.entity.Book> buscarPorId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok(bookService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<com.example.msbook.entity.Book> editar(@PathVariable(required = true) Integer id,
                                                                     @RequestBody com.example.msbook.entity.Book book) {
        book.setId(id);
        return ResponseEntity.ok(bookService.editar(book));

    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable(required = true) Integer id) {
        bookService.eliminar(id);
        return "Eliminacion correcta";
    }


}