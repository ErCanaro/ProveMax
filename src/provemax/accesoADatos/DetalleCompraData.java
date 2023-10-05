
package provemax.accesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import provemax.entidades.DetalleCompra;
import provemax.entidades.Producto;
import provemax.entidades.Proveedor;


public class DetalleCompraData {
    private Connection con = null;
    private CompraData compraData = new CompraData();
    private ProductoData prodData = new ProductoData();
    private ProveedorData provData = new ProveedorData();

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
    public DetalleCompra buscarDetallePorId(int idDetalle) {
        String sql = "SELECT * from detalleCompra WHERE idDetalle = ?";
        DetalleCompra detalleCompra = new DetalleCompra();
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDetalle);
            
            ResultSet rs = ps.executeQuery();
                                   
            if (rs.next()) {
                detalleCompra.setIdDetalle(rs.getInt("idDetalle"));
                detalleCompra.setCantidad(rs.getInt("cantidad"));
                detalleCompra.setPrecioCosto(rs.getDouble("precioCosto"));
                detalleCompra.setProducto(prodData.buscarProductoPorId(rs.getInt(rs.getInt("idProducto"))));
                detalleCompra.setCompra(compraData.buscarCompraPorId(rs.getInt("idCompra")));
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla DetalleCompra");
        }
        return detalleCompra;
    }
    //Lista de Productos x Fecha
    public List<Producto> listaProductosPorFecha(LocalDate fecha) {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        
        String sql = "SELECT * FROM detallecompra dc JOIN compra ON dc.idCompra=compra.idCompra WHERE fecha = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fecha));
            
            ResultSet rs = ps.executeQuery();
                                   
            while (rs.next()) {
                Producto producto = prodData.buscarProductoPorId((rs.getInt("idProducto")));
                
                listaProductos.add(producto);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla DetalleCompra");
        }
        return listaProductos;
    }
    //Lista Productos por compra
    public List<Producto> listaProductosPorCompra(int idCompra) {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        
        String sql = "SELECT * FROM detallecompra WHERE idCompra = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCompra);
            
            ResultSet rs = ps.executeQuery();
                                   
            if (rs.next()) {
                Producto producto = prodData.buscarProductoPorId(rs.getInt("idProducto"));
                
                listaProductos.add(producto);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla DetalleCompra");
        }
        return listaProductos;
    }
    //Lista productos por Proveedor
    public List<Producto> listaProductosPorProveedor(int idProveedor) {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        
        String sql = "SELECT * FROM detallecompra dc JOIN compra ON dc.idCompra=compra.idCompra WHERE idProveedor = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProveedor);
            
            ResultSet rs = ps.executeQuery();
                                   
            if (rs.next()) {
                Producto producto = prodData.buscarProductoPorId(rs.getInt("idProducto"));
                
                listaProductos.add(producto);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla DetalleCompra");
        }
        return listaProductos;
    }
    
    //Lista Proveedores por producto
    public List<Proveedor> listaProveedoresPorProducto(int idProducto) {
        ArrayList<Proveedor> listaProveedores = new ArrayList<>();
        
        String sql = "SELECT * FROM detallecompra dc JOIN compra ON dc.idCompra=compra.idCompra WHERE idProducto = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProducto);
            
            ResultSet rs = ps.executeQuery();
                                   
            if (rs.next()) {
                Proveedor proveedor = provData.buscarProveedorPorId(rs.getInt("idProveedor"));
                
                listaProveedores.add(proveedor);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla DetalleCompra");
        }
        return listaProveedores;
    }
    
    //Lista Productos mas comprados entre fechas
     public Map<Producto, Integer> listaProductosMasCompradoEntre(LocalDate fechaInicio, LocalDate fechaFin) {
        Map<Producto, Integer> listaProductos = new LinkedHashMap<>();
        
        String sql = "SELECT *, SUM(cantidad) as total FROM detallecompra dc JOIN compra ON dc.idCompra=compra.idCompra "
                + "WHERE fecha >= ? AND fecha <= ? GROUP BY idProducto ORDER BY total DESC";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fechaInicio));
            ps.setDate(2, Date.valueOf(fechaFin));
            
            ResultSet rs = ps.executeQuery();
                                   
            while (rs.next()) {
                Producto producto = prodData.buscarProductoPorId(rs.getInt("idProducto"));
                int cant = rs.getInt("total");
                listaProductos.put(producto, cant);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla DetalleCompra");
        }
        return listaProductos;
    }
    
    
}
