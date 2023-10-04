/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provemax;

import provemax.accesoADatos.CompraData;
import provemax.accesoADatos.ProductoData;
import provemax.accesoADatos.ProveedorData;
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
        CompraData compraData = new CompraData();
        
//        pvdData.buscarProveedorPorId(9);
//
//        for (Proveedor p : pvdData.listarProveedores()){
//            System.out.println(p);
//        }

//        for (Producto p : prodData.buscarProductoPorDescripcionContiene("ORA")) {
//            System.out.println(p);
//        }

        System.out.println(compraData.buscarCompraPorId(1));
        
    }
    
}
