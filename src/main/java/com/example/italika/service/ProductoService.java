package com.example.italika.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.italika.entity.Producto;
import com.example.italika.repository.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

    public void crearProducto(Producto producto) {
        repository.crearProducto(producto);
    }

    public List<Producto> listarProductos() {
        return repository.listarProductos();
    }

    public Producto obtenerProducto(Integer id) {
        return repository.obtenerProducto(id);
    }

    public void actualizarProducto(Producto producto) {
        repository.actualizarProducto(producto);
    }

    public void bloquearProducto(Integer id) {
        repository.bloquearProducto(id);
    }
}