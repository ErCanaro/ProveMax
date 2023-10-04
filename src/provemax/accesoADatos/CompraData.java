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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import provemax.entidades.Compra;

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
            ps.executeUpdate();
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
     public void borrarCompra(int idCompra) {
         String sql = "DELETE FROM compra WHERE idCompra = ?";
         
          try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCompra);
                                  
            int borrado = ps.executeUpdate();
            if (borrado == 1 ){
                JOptionPane.showMessageDialog(null, "La Compra agregado con el ID " + idCompra + "ha sido eliminada");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla Compra");
        }
     }
     
     
    //modificarCompra - Modificar Fecha y Proveedor
     public void modificarCompra(Compra compra) {
        String sql =  "UPDATE compra SET proveedor = ?, fecha = ?";
        
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, compra.getProveedor().getIdProveedor());
            ps.setDate(2, Date.valueOf(compra.getFecha()));
           
            
            int modificado = ps.executeUpdate();
            
            if (modificado == 1) {
                JOptionPane.showMessageDialog(null, "La compra con el ID "+ compra.getIdCompra() + " ha sido modificaco");
            }      
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla Producto");
        }
    }
     
    //listarCompras - Listar todas las compras
     public List<Compra> listarCompras(){
         ArrayList<Compra> listaDeCompras = new ArrayList<>();
         
         String sql = "SELECT * FROM compra";
         
         try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery(); // idCOmpra idProveedor fecha
            
          while (rs.next()){
              Compra compra = new Compra();
              compra.setIdCompra(rs.getInt("idCompra"));
              compra.setProveedor(provData.buscarProveedorPorId(rs.getInt("idProveedor")));
              compra.setFecha(rs.getDate("fecha").toLocalDate());
              
              listaDeCompras.add(compra);
          }     
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla Producto");
        }
         return listaDeCompras;
     }
    //ListarComprasPorProveedor
     public List<Compra> listarComprasPorProveedor(int idProveedor){
         ArrayList<Compra> listaDeCompras = new ArrayList<>();
         
         String sql = "SELECT * FROM compra WHERE idProveedor = ?";
         
         try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProveedor);
            
            ResultSet rs = ps.executeQuery(); // idCOmpra idProveedor fecha
            
          while (rs.next()){
              Compra compra = new Compra();
              compra.setIdCompra(rs.getInt("idCompra"));
              compra.setProveedor(provData.buscarProveedorPorId(rs.getInt("idProveedor")));
              compra.setFecha(rs.getDate("fecha").toLocalDate());
              
              listaDeCompras.add(compra);
          }     
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla Producto");
        }
         return listaDeCompras;
     }
     
    //ListarComprasPorFecha
    public List<Compra> listarComprasPorFecha(LocalDate fecha){
         ArrayList<Compra> listaDeCompras = new ArrayList<>();
         
         String sql = "SELECT * FROM compra WHERE fecha = ?";
         
         try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fecha));
            
            ResultSet rs = ps.executeQuery(); // idCOmpra idProveedor fecha
            
          while (rs.next()){
              Compra compra = new Compra();
              compra.setIdCompra(rs.getInt("idCompra"));
              compra.setProveedor(provData.buscarProveedorPorId(rs.getInt("idProveedor")));
              compra.setFecha(rs.getDate("fecha").toLocalDate());
              
              listaDeCompras.add(compra);
          }     
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla Producto");
        }
         return listaDeCompras;
     }
    
}
