/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provemax;

import java.time.LocalDate;
import java.util.Map;
import provemax.accesoADatos.DetalleCompraData;
import provemax.entidades.Producto;

/**
 *
 * @author Enzo Bulacio
 */
public class ProveMax {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Proveedor p = new Proveedor("La Estrella", "Via Láctea", "03 03 456", true);
        
        //ProveedorData pvdData = new ProveedorData();
        //ProductoData prodData = new ProductoData();
        //for (Producto p : prodData.listaProductosConStockMenorAlMinimo()) {
        //    System.out.println(p);
        //}
        //CompraData compraData  =  new CompraData();
       //Producto producto = new Producto("Juguera", "Hace jugo", 12536.84, 18, true);
//        System.out.println(compraData.buscarCompraPorId(1));
        
        //CompraData compraData = new CompraData();
        //Proveedor prove = pvdData.buscarProveedorPorId(1);
        //Compra comprita = new Compra(prove, LocalDate.of(2023,10,1));
        
       
       
        //System.out.println(comprita);
//        pvdData.buscarProveedorPorId(9);
//
//        for (Proveedor p : pvdData.listarProveedores()){
//            System.out.println(p);
//        }

//        System.out.println(prodData.buscarProductoPorNombreCompleto("Juguera"));
//        for (Producto p : prodData.buscarProductoPorNombreContiene("rod")) {
//            System.out.println(p);
//        }

//        for (Producto p : prodData.buscarProductoPorDescripcionContiene("ora")){
//            System.out.println(p);
//        }
            
        
        //System.out.println(compraData.buscarCompraPorId(1));
        
        
        
        DetalleCompraData dcd = new DetalleCompraData();
        
//        for (Producto p : dcd.listaProductosPorFecha(LocalDate.of(2023,10, 1))){
//            System.out.println(p);
//        }
        
        for (Map.Entry<Producto, Integer> pv : dcd.listaProductosMasCompradoEntre(LocalDate.of(2023,10,1), LocalDate.of(2023,10,6)).entrySet()){
             System.out.println(pv.getKey().getNombre() + "  =  " + pv.getValue());
        }

    }
    
    
}
