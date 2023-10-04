
package provemax.accesoADatos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import provemax.entidades.Proveedor;

public class ProveedorData {
    private Connection con = null;

    public ProveedorData() {
        con = Conexion.getConexion();
    }

    public Connection getCon() {
        return con;
    }
    
    public void guardarProveedor(Proveedor p) {
        String sql = "INSERT INTO proveedor (razonSocial, domicilio, telefono, estado)"
                     + " VALUES (?,?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ps.setString(1, p.getRazonSocial());
             ps.setString(2, p.getDomicilio());
             ps.setString(3, p.getTelefono());
             ps.setBoolean(4, p.isEstado());
             
             ps.executeUpdate();
             
             ResultSet rs = ps.getGeneratedKeys();
             if (rs.next()){
                p.setIdProveedor(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Proveedor agregado satisfactoriamente con el ID" + rs.getInt(1));
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla Proveedor");
        }
    }
    
    public void modificarProveedor(Proveedor p) {
        String sql = "UPDATE proveedor SET razonSocial = ?, domicilio = ?, telefono = ?, estado = ?"
                     + "WHERE idProveedor = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
             ps.setString(1, p.getRazonSocial());
             ps.setString(2, p.getDomicilio());
             ps.setString(3, p.getTelefono());
             ps.setBoolean(4, p.isEstado());
             ps.setInt(5, p.getIdProveedor());
             
             int modificado = ps.executeUpdate();

             if (modificado == 1){
                    JOptionPane.showMessageDialog(null, "Proveedor modificado satisfactoriamente");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla Proveedor");
        }
    }
    
    public void borrarProveedor(int idProveedor){
        String sql = "UPDATE proveedor SET estado = ? WHERE idProveedor = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 0);
            ps.setInt(2, idProveedor);
            
            int modificado = ps.executeUpdate();
            
            if (modificado == 1) {
                JOptionPane.showMessageDialog(null, "El Proveedor con el ID "+ idProveedor + " ha sido borrado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla Proveedor");
        }
    }
    
    public void restaurarProveedor(int idProveedor){
        String sql = "UPDATE proveedor SET estado = ? WHERE idProveedor = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setInt(2, idProveedor);
            
            int modificado = ps.executeUpdate();
            
            if (modificado == 1) {
                JOptionPane.showMessageDialog(null, "El Proveedor con el ID "+ idProveedor + " ha sido borrado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla Proveedor");
        }
    }
    
    public List<Proveedor> listarProveedores() {
        List<Proveedor> listaProveedores = new ArrayList<>();
        
        String sql =  "SELECT * FROM proveedor";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs =  ps.executeQuery();
            
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt("idProveedor"));
                proveedor.setRazonSocial(rs.getString("razonSocial"));
                proveedor.setDomicilio(rs.getString("domicilio"));
                proveedor.setTelefono(rs.getString("telefono"));
                proveedor.setEstado(rs.getBoolean("estado"));
            
                listaProveedores.add(proveedor);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla Proveedor");
        }
        return listaProveedores;
    }
    
    public Proveedor buscarProveedorPorId(int idProveedor){
        String sql =  "SELECT * FROM proveedor WHERE idProveedor = ?";
        Proveedor proveedor = new Proveedor();
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProveedor);
            ResultSet rs =  ps.executeQuery();
            

            if (rs.next()) {
                proveedor.setIdProveedor(rs.getInt("idProveedor"));
                proveedor.setRazonSocial(rs.getString("razonSocial"));
                proveedor.setDomicilio(rs.getString("domicilio"));
                proveedor.setTelefono(rs.getString("telefono"));
                proveedor.setEstado(rs.getBoolean("estado"));
                
                //System.out.println(proveedor);
            } else {
                JOptionPane.showMessageDialog(null, "No se econtró un porveedor con este ID");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla Proveedor");
        }

        return proveedor;
    }
    

    
}
