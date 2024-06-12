package com.example.msinventario.controller;

import com.example.msinventario.entity.Inventario;
import com.example.msinventario.service.InventarioService;
import com.example.msinventario.util.PdfUtils;
import com.example.msinventario.util.UserExcelExporter;
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
@RequestMapping("/inventario")
public class InventarioController {
    @Autowired
    private InventarioService inventarioService;

    @GetMapping()
    public ResponseEntity<List<Inventario>> list() {
        return ResponseEntity.ok().body(inventarioService.listar());
    }
    @PostMapping()
    public ResponseEntity<Inventario> save(@RequestBody Inventario inventario){
        return ResponseEntity.ok(inventarioService.guardar(inventario));
    }
    @PutMapping()
    public ResponseEntity<Inventario> update(@RequestBody Inventario inventario){
        return ResponseEntity.ok(inventarioService.actualizar(inventario));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Inventario> listById(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok().body(inventarioService.listarPorId(id).get());
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id){
        inventarioService.eliminarPorId(id);
        return "Eliminacion Correcta";
    }

    @GetMapping("/pdf")
    public ResponseEntity<byte[]> exportPdf() throws IOException, DocumentException {
        // List<Map<String, Object>> queryResults = myService.executeQuery(request);
        ByteArrayOutputStream pdfStream = PdfUtils.generatePdfStream(inventarioService.listar()
        );
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=query_results.pdf");
        headers.setContentLength(pdfStream.size());
        return new ResponseEntity<>(pdfStream.toByteArray(), headers, HttpStatus.OK);
    }
    @GetMapping("/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Inventario> inventarios = inventarioService.listar();

        UserExcelExporter excelExporter = new UserExcelExporter(inventarios);

        excelExporter.export(response);
    }
}
