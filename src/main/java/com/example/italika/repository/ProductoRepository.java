package com.example.italika.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.italika.entity.Producto;

@Repository
public class ProductoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void crearProducto(Producto producto) {
        jdbcTemplate.update("EXEC sp_crear_producto ?, ?, ?, ?",
                producto.getNombre(), producto.getDescripcion(),
                producto.getPrecio(), producto.getCantidad());
    }

    public List<Producto> listarProductos() {
        return jdbcTemplate.query("EXEC sp_listar_productos",
        (rs, rowNum) -> new Producto(
                rs.getInt("id_producto"),       
                rs.getString("nombre"),         
                rs.getString("descripcion"),    
                rs.getBigDecimal("precio"),     
                rs.getInt("cantidad"),          
                rs.getString("estado")          
        ));
    }

    public Producto obtenerProducto(Integer id) {
        return jdbcTemplate.queryForObject("EXEC sp_obtener_producto ?",
                new Object[]{id},
                (rs, rowNum) -> new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getBigDecimal("precio"),
                        rs.getInt("cantidad"),
                        rs.getString("estado")
                ));
    }

    public void actualizarProducto(Producto producto) {
        jdbcTemplate.update("EXEC sp_actualizar_producto ?, ?, ?, ?, ?",
                producto.getIdProducto(), producto.getNombre(),
                producto.getDescripcion(), producto.getPrecio(), producto.getCantidad());
    }

    public void bloquearProducto(Integer id) {
        jdbcTemplate.update("EXEC sp_bloquear_producto ?", id);
    }
}