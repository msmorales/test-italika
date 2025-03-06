package com.example.italika.entity;


import java.math.BigDecimal;

public class Producto {
    private Integer idProducto;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer cantidad;
    private String estado;  // "ACTIVO" o "BLOQUEADO"

    // Constructor vacío (obligatorio para Spring y JDBC)
    public Producto() {
    }

    // Constructor con todos los atributos
    public Producto(Integer idProducto, String nombre, String descripcion, BigDecimal precio, Integer cantidad, String estado) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    // Getters y Setters
    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Método toString para depuración (opcional)
    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", estado='" + estado + '\'' +
                '}';
    }
}
