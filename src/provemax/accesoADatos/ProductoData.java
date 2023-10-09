
package provemax.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import provemax.entidades.Producto;


public class ProductoData {
    private Connection con;

    public ProductoData() {
        con = Conexion.getConexion();
    }

    public Connection getCon() {
        return con;
    }
    
    public Producto buscarProductoPorId(int idProducto) {
        Producto producto = new Producto();
        
        String sql =  "SELECT * from producto WHERE idProducto = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProducto);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getBoolean("estado"));
                producto.setStockMinimo(rs.getInt("stockMinimo"));
            }else {
                JOptionPane.showMessageDialog(null, "No existe un producto con el ID " + idProducto);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla Producto");
        }
        return producto;
    }
    
    public List<Producto> buscarProductoPorNombreCompleto(String nombre) {
        
        ArrayList<Producto> listaProductos = new ArrayList<>();
        String sql =  "SELECT * from producto WHERE nombre = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getBoolean("estado"));
                producto.setStockMinimo(rs.getInt("stockMinimo"));
                
                listaProductos.add(producto);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla Producto");
        }
        return listaProductos;
    }
    
    public List<Producto> buscarProductoPorNombreContiene(String nombre) {
        
        ArrayList<Producto> listaProductos = new ArrayList<>();
        String sql =  "SELECT * from producto WHERE nombre like ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%"+nombre+"%"); // LIKE %ora%
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getBoolean("estado"));
                producto.setStockMinimo(rs.getInt("stockMinimo"));
                
                listaProductos.add(producto);

           }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla Producto");
        }

        return listaProductos;
    }
    
    public List<Producto> buscarProductoPorDescripcionContiene(String descripcion) {
        
        ArrayList<Producto> listaProductos = new ArrayList<>();
        String sql =  "SELECT * from producto WHERE descripcion like ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%"+descripcion+"%");
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getBoolean("estado"));
                producto.setStockMinimo(rs.getInt("stockMinimo"));
                
                listaProductos.add(producto);

           }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla Producto");
        }

        return listaProductos;
    }
    
    public void altaProducto(Producto producto) {
        String sql = "INSERT INTO producto (nombre, descripcion, precioActual, stock, estado, stockMinimo)"
                + " VALUES (?,?,?,?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecioActual());
            ps.setInt(4, producto.getStock());
            ps.setBoolean(5, producto.isEstado());
            ps.setInt(6, producto.getStockMinimo());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                producto.setIdProducto(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Producto agregado con el ID " + rs.getInt(1));
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla Producto");
        }
        
    }
    
    public void bajaProducto(int idProducto) {
        String sql =  "UPDATE producto SET estado = ? WHERE idProducto = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 0);
            ps.setInt(2, idProducto);
            
            int modificado = ps.executeUpdate();
            
            if (modificado == 1) {
                JOptionPane.showMessageDialog(null, "El Producto con el ID "+ idProducto + " ha sido borrado");
            }      
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla Producto");
        }
    }
    
    public void restaurarProducto(int idProducto) {
        String sql =  "UPDATE producto SET estado = ? WHERE idProducto = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setInt(2, idProducto);
            
            int modificado = ps.executeUpdate();
            
            if (modificado == 1) {
                JOptionPane.showMessageDialog(null, "El Producto con el ID "+ idProducto + " ha sido restaurado");
            }      
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla Producto");
        }
    }
    
    public void modificarProdcuto(Producto producto) {
        String sql =  "UPDATE producto SET nombre = ?, descripcion = ?, precioActual = ?, stock = ? , stockMinimo = ? WHERE idProducto = ?";
        
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecioActual());
            ps.setInt(4, producto.getStock());
            ps.setInt(5, producto.getStockMinimo());
            ps.setInt(6, producto.getIdProducto());
            
            
            int modificado = ps.executeUpdate();
            
            if (modificado == 1) {
                JOptionPane.showMessageDialog(null, "El Producto con el ID "+ producto.getIdProducto() + " ha sido modificaco");
            }      
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla Producto");
        }
    }
        
    
    public List<Producto> listaProductosConStockMenorAlMinimo(){
        ArrayList<Producto> listaProductos = new ArrayList<>();
        
        String sql = "SELECT * FROM producto WHERE stock < stockMinimo";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getBoolean("estado"));
                producto.setStockMinimo(rs.getInt("stockMinimo"));
                
                listaProductos.add(producto);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla Producto");
        }
        
        return listaProductos;
    }
    
    
    public List<Producto> listaProductos(){
        ArrayList<Producto> listaProductos = new ArrayList<>();
        
        String sql = "SELECT * FROM producto";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getBoolean("estado"));
                producto.setStockMinimo(rs.getInt("stockMinimo"));
                
                listaProductos.add(producto);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla Producto");
        }
        
        return listaProductos;
    }
}
