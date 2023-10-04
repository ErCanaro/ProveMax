/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provemax.accesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import provemax.entidades.Compra;
import provemax.entidades.Producto;

/**
 *
 * @author Enzo Bulacio
 */
public class CompraData {
    private Connection con = null;
    private ProveedorData provData = new ProveedorData();

    public CompraData() {
        con = Conexion.getConexion();
    }

    public Connection getCon() {
        return con;
    }
    
    //buscarCompraPorID
    public Compra buscarCompraPorId(int idCompra) {
        Compra compra = new Compra();
        
        String sql =  "SELECT * from compra WHERE idCompra = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCompra);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                compra.setIdCompra(rs.getInt("idCompra"));
                compra.setProveedor(provData.buscarProveedorPorId(rs.getInt("idProveedor")));
                compra.setFecha(rs.getDate("fecha").toLocalDate());
                
            }else {
                JOptionPane.showMessageDialog(null, "No existe una compra con el ID " + idCompra);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla Compra");
        }
        return compra;
    }
    
    
    
    
    //altaCompra - Guardar compra
     public void altaCompra(Compra compra) {
        String sql = "INSERT INTO compra (idProveedor, fecha)"
                + " VALUES (?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, compra.getProveedor().getIdProveedor());
            ps.setDate(2, Date.valueOf(compra.getFecha()));
                      
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                compra.setIdCompra(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Compra agregado con el ID " + rs.getInt(1));
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla Compra");
        }
        
    }
    //bajaCompra - Borrado borrado
    //modificarCompra - Modificar Fecha y Proveedor
    //listarCompras - Listar todas las comprar
    //ListarComprasPorProveedor
    //ListarComprasPorFecha
    
    
}
