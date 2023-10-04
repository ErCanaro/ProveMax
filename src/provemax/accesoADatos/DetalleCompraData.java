
package provemax.accesoADatos;

import java.sql.Connection;


public class DetalleCompraData {
    private Connection con = null;
    private CompraData compraData = new CompraData();
    private ProductoData prodData = new ProductoData();

    public DetalleCompraData() {
        con =  Conexion.getConexion();
    }
    
    //Alta Detalle
    //Baja Detalla
    //Modificación Detalle
    //Buscar detalle por 1d
    //Lista Productos y Fecha
    //Lista Productos por compra
    //Lista Proveedores por producto
    //Lista Productos mas comprados entre fechas
    
    
    
}
