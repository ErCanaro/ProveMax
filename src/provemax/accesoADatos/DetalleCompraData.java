
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
        String sql =  "INSERT INTO detallecompra (cantidad, precioCosto, idCompra, idProducto)"
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
                detalleCompra.setProducto(prodData.buscarProductoPorId(rs.getInt("idProducto")));
                detalleCompra.setCompra(compraData.buscarCompraPorId(rs.getInt("idCompra")));
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla DetalleCompra {Buscar DETALLA POR ID}");
        }
        return detalleCompra;
    }
//    //Lista de Productos x Fecha
//    public List<Double[]> listaProductosPorFecha(LocalDate fecha) {
//        ArrayList<Double[]> listaDetalleCompras = new ArrayList<>();
//        String sql = "SELECT producto.idProducto,SUM(cantidad) AS cantidadTotal," 
//                + "AVG(precioCosto) AS 'precioPromedio' ,SUM(stock+cantidad) AS stockTotal " 
//                + "FROM detallecompra dc JOIN compra ON dc.idCompra=compra.idCompra " 
//                + "JOIN producto ON dc.idProducto=producto.idProducto WHERE fecha = ? "
//                + "GROUP BY dc.idProducto";
//        
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setDate(1, Date.valueOf(fecha));
//            
//            ResultSet rs = ps.executeQuery();
//                                   
//            while (rs.next()) {
//                Double[] datos = {rs.getDouble("idProducto") , rs.getDouble("cantidadTotal"), rs.getDouble("precioPromedio"), rs.getDouble("stockTotal")};
//                                
//                listaDetalleCompras.add(datos);
//            }
//            ps.close();
//            
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla DetalleCompra" + ex);
//        }
//        return listaDetalleCompras;
//    }
//    
//    public List<DetalleCompra> listaProductosPorFecha2(LocalDate fecha) {
//        ArrayList<DetalleCompra> listaDetalleCompras = new ArrayList<>();
//        
//        String sql = "SELECT * FROM detallecompra dc JOIN compra ON dc.idCompra=compra.idCompra WHERE fecha = ?";
//        
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setDate(1, Date.valueOf(fecha));
//            
//            ResultSet rs = ps.executeQuery();
//                                   
//            while (rs.next()) {
//                DetalleCompra detalleCompra = new DetalleCompra();
//                
//                detalleCompra.setProducto(prodData.buscarProductoPorId(rs.getInt("idProducto")));
//                detalleCompra.setCantidad(rs.getInt("cantidad"));
//                detalleCompra.setPrecioCosto(rs.getDouble("precioCosto"));
//                detalleCompra.setCompra(compraData.buscarCompraPorId(rs.getInt("idCompra")));
//                detalleCompra.setIdDetalle(rs.getInt("idDetalleCompra"));
//                
//                listaDetalleCompras.add(detalleCompra);
//            }
//            ps.close();
//            
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla DetalleCompra");
//        }
//        return listaDetalleCompras;
//    }
    
     //Lista de Productos x Fecha
    public List<Double[]> listaProductosPorFecha(LocalDate fecha) {
        ArrayList<Double[]> listaProductos = new ArrayList<>();
        String sql = "SELECT producto.idProducto, compra.idProveedor, cantidad, precioCosto "
                + "FROM detallecompra dc JOIN compra ON dc.idCompra=compra.idCompra "
                + "JOIN producto ON dc.idProducto=producto.idProducto WHERE fecha = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fecha));
            
            ResultSet rs = ps.executeQuery();
                                   
            while (rs.next()) {
                Double[] datos = {rs.getDouble("idProducto") , rs.getDouble("idProveedor"), rs.getDouble("cantidad"), rs.getDouble("precioCosto")};
                                
                listaProductos.add(datos);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla DetalleCompra" + ex);
        }
        return listaProductos;
    }
    
    //Lista Productos por compra
    public List<Producto> listarProductosPorCompra(int idCompra) {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        
        String sql = "SELECT * FROM detallecompra WHERE idCompra = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCompra);
            
            ResultSet rs = ps.executeQuery();
                                   
            while (rs.next()) {
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
    public List<DetalleCompra> listarDetalleCompraPorCompra(int idCompra) {
        ArrayList<DetalleCompra> listaDetalleCompras = new ArrayList<>();
        
        String sql = "SELECT * FROM detallecompra dc JOIN compra ON dc.idCompra=compra.idCompra WHERE dc.idCompra = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCompra);
            
            ResultSet rs = ps.executeQuery();
                                   
            while (rs.next()) {
                DetalleCompra dc = buscarDetallePorId(rs.getInt("idDetalle"));
                
                listaDetalleCompras.add(dc);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla DetalleCompra AQUI ES");
        }
        return listaDetalleCompras;
    }
    
    //Lista productos por Proveedor
    
    public List<Producto> listarProductosPorProveedor(int idProveedor) {
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
    
     public ArrayList<Integer[]> listarMasComprados(LocalDate f1, LocalDate f2, int cantidad){
        ArrayList<Integer []> listaProductos = new ArrayList<>();
        
         
         String sql = "SELECT idProducto, SUM(cantidad) as cantidad FROM detallecompra dc Join compra ON dc.idCompra=compra.idCompra "
                 + "WHERE compra.fecha >= ? AND compra.fecha <= ? GROUP BY dc.idProducto ORDER by cantidad DESC LIMIT ?";
         
         try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(f1));
            ps.setDate(2, Date.valueOf(f2));
            ps.setInt(3, cantidad);
            ResultSet rs = ps.executeQuery(); // idCOmpra idProveedor fecha
            
          while (rs.next()){
              Integer [] datos = {rs.getInt("idProducto"), rs.getInt("cantidad")};
              listaProductos.add(datos);
          }     
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla Producto");
        }
        
        return listaProductos;
    }
    
}
