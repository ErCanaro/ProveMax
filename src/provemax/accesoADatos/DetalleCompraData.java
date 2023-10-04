
package provemax.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import provemax.entidades.DetalleCompra;


public class DetalleCompraData {
    private Connection con = null;
    private CompraData compraData = new CompraData();
    private ProductoData prodData = new ProductoData();

    public DetalleCompraData() {
        con =  Conexion.getConexion();
    }
    
    //Alta Detalle
    public void altaDetalle(DetalleCompra detalle){
        String sql =  "INSET INTO detallecompra (cantidad, precioCosto, idCompra, idProducto)"
                + "VALUES (?,?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, detalle.getCantidad());
            ps.setDouble(2, detalle.getPrecioCosto());
            ps.setInt(3, detalle.getCompra().getIdCompra());
            ps.setInt(4, detalle.getProducto().getIdProducto());
            ps.executeUpdate();
            
            ResultSet rs =  ps.getGeneratedKeys();
            
            if (rs.next()) {
                detalle.setIdDetalle(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Detalle agregado");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla DetalleCompra");
        }
    }
    
    //Baja Detalla
    public void bajaDetalle(int idDetalle) {
        String sql =  "DELETE FROM detallecompra WHERE idDetalle = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idDetalle);
            
            int borrado = ps.executeUpdate();
                                   
            if (borrado == 1) {
               JOptionPane.showMessageDialog(null, "Detalle borrado");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla DetalleCompra");
        }
    }
    
    
    //Modificación Detalle
    public void modificarDetalle(DetalleCompra detalle) {
        String sql = "UPDATE detallecompra SET cantidad = ?, precioCosto = ?, idCompra = ?,"
                + " idProducto = ? WHERE idDetalle = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, detalle.getCantidad());
            ps.setDouble(2, detalle.getPrecioCosto());
            ps.setInt(3, detalle.getCompra().getIdCompra());
            ps.setInt(4, detalle.getProducto().getIdProducto());
            
            
            int modificado = ps.executeUpdate();
                                   
            if (modificado == 1) {
               JOptionPane.showMessageDialog(null, "Detalle modificado");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla DetalleCompra");
        }
        
    }
    
    //Buscar detalle por 1d
    //Lista Productos y Fecha
    //Lista Productos por compra
    //Lista Proveedores por producto
    //Lista Productos mas comprados entre fechas
    
    
    
}
