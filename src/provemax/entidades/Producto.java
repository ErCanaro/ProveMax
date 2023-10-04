/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provemax.entidades;

/**
 *
 * @author Enzo Bulacio
 */
public class Producto {
    private int idProducto;
    private String nombre;
    private String descripcion;
    private double precioActual;
    private int stock;
    private boolean estado;
    private int stockMinimo;

    public Producto() {
    }

    public Producto(String nombre, String descripcion, double precioActual, int stock, boolean estado, int stockMinimo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioActual = precioActual;
        this.stock = stock;
        this.estado = estado;
        this.stockMinimo = stockMinimo;
    }

    public Producto(int idProducto, String nombre, String descripcion, double precioActual, int stock, boolean estado, int stockMinimo) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioActual = precioActual;
        this.stock = stock;
        this.estado = estado;
        this.stockMinimo = stockMinimo;
    }

  

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
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

    public double getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(double precioActual) {
        this.precioActual = precioActual;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precioActual=" + precioActual + ", stock=" + stock + ", estado=" + estado + ", stockMinimo=" + stockMinimo + '}';
    }
    
    

    
    
}
