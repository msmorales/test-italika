package com.example.italika.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.italika.entity.Producto;
import com.example.italika.service.ProductoService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/productos")
@Tag(name = "Productos", description = "CRUD de productos")
public class ProductoController {

    @Autowired
    private ProductoService service;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> crearProducto(@RequestBody Producto producto) {
        service.crearProducto(producto);
        return ResponseEntity.ok("Producto creado correctamente.");
    }

    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos() {
        return ResponseEntity.ok(service.listarProductos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Integer id) {
        return ResponseEntity.ok(service.obtenerProducto(id));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> actualizarProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        producto.setIdProducto(id);
        service.actualizarProducto(producto);
        return ResponseEntity.ok("Producto actualizado correctamente.");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> bloquearProducto(@PathVariable Integer id) {
        service.bloquearProducto(id);
        return ResponseEntity.ok("Producto bloqueado correctamente.");
    }
}
