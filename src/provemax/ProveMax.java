/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provemax;

import provemax.accesoADatos.ProveedorData;
import provemax.entidades.Proveedor;

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
        
        ProveedorData pvdData = new ProveedorData();
        
//        pvdData.buscarProveedorPorId(9);

        for (Proveedor p : pvdData.listarProveedores()){
            System.out.println(p);
        }
        
    }
    
}
