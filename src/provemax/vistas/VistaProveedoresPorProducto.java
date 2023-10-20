/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provemax.vistas;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import provemax.accesoADatos.DetalleCompraData;
import provemax.accesoADatos.ProductoData;
import provemax.accesoADatos.ProveedorData;
import provemax.entidades.Producto;
import provemax.entidades.Proveedor;

/**
 *
 * @author Enzo Bulacio
 */
public class VistaProveedoresPorProducto extends javax.swing.JInternalFrame {
    private ProductoData prodData = new ProductoData();
    private ProveedorData provData = new ProveedorData();
    private DetalleCompraData dcData = new DetalleCompraData();
    private DefaultTableModel modeloTablaProductos = new DefaultTableModel();
    private DefaultTableModel modeloTablaProveedores = new DefaultTableModel();
    private ArrayList<Producto> listaProductos = new ArrayList<>(prodData.listaProductos());
    /**
     * Creates new form VistaProveedoresPorProducto
     */
    public VistaProveedoresPorProducto() {
        initComponents();
        inicializarTablaProductos();
        inicializarTablaProveedores();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTFBusqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProductos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTProveedores = new javax.swing.JTable();

        setClosable(true);
        setTitle("Proveedores por Producto");
        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Proveedores por Producto");

        jLabel2.setText("Buscar Producto");

        jTFBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFBusquedaKeyReleased(evt);
            }
        });

        jTProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTProductosMouseReleased(evt);
            }
        });
        jTProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTProductosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTProductos);

        jTProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTProveedores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jTFBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 63, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBusquedaKeyReleased
      filtrarProductosPorBusqueda();
    }//GEN-LAST:event_jTFBusquedaKeyReleased

    private void jTProductosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProductosMouseReleased
        cargarTablaProveedores();
    }//GEN-LAST:event_jTProductosMouseReleased

    private void jTProductosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTProductosKeyReleased
        cargarTablaProveedores();
    }//GEN-LAST:event_jTProductosKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFBusqueda;
    private javax.swing.JTable jTProductos;
    private javax.swing.JTable jTProveedores;
    // End of variables declaration//GEN-END:variables
    
     private void inicializarTablaProductos(){
        modeloTablaProductos.setColumnIdentifiers(new Object [] {"Código", "Nombre", "Descripción", "Precio Actual", "Stock"});
        
        modeloTablaProductos.setRowCount(0);
        for (Producto p : prodData.listaProductos()) {
            modeloTablaProductos.addRow(new Object [] {p.getIdProducto(), p.getNombre(), p.getDescripcion(), p.getPrecioActual(),p.getStock()});
        }
         jTProductos.setModel(modeloTablaProductos);
         jTProductos.setAutoCreateRowSorter(true);
         jTProductos.getColumnModel().getColumn(0).setPreferredWidth(25);
         jTProductos.getColumnModel().getColumn(1).setPreferredWidth(100);
         jTProductos.getColumnModel().getColumn(2).setPreferredWidth(135);
         jTProductos.getColumnModel().getColumn(3).setPreferredWidth(60);
         jTProductos.getColumnModel().getColumn(4).setPreferredWidth(25);
         jTProductos.setDefaultEditor(Object.class, null);
    }

     
         private void inicializarTablaProveedores(){
        modeloTablaProveedores.setColumnIdentifiers(new Object [] {"Código", "Razón Social", "Domicilio", "Teléfono"});

         jTProveedores.setModel(modeloTablaProveedores);
         jTProveedores.setAutoCreateRowSorter(true);
         jTProveedores.getColumnModel().getColumn(0).setPreferredWidth(25);
         jTProveedores.getColumnModel().getColumn(1).setPreferredWidth(100);
         jTProveedores.getColumnModel().getColumn(2).setPreferredWidth(135);
         jTProveedores.getColumnModel().getColumn(3).setPreferredWidth(60);
         jTProveedores.setDefaultEditor(Object.class, null);
    }

     private void filtrarProductosPorBusqueda(){
        modeloTablaProductos.setRowCount(0);
        for (Producto p : listaProductos) {
            if (p.getNombre().toLowerCase().contains(jTFBusqueda.getText().toLowerCase())
                    || p.getDescripcion().toLowerCase().contains(jTFBusqueda.getText().toLowerCase())) {
                modeloTablaProductos.addRow(new Object[]{p.getIdProducto(), p.getNombre(), p.getDescripcion(), p.getPrecioActual(), p.getStock()});
            }
        }
        jTProductos.setModel(modeloTablaProductos);
    }
     
    private void cargarTablaProveedores(){
        modeloTablaProveedores.setRowCount(0);
        int idProducto = (int)jTProductos.getValueAt(jTProductos.getSelectedRow(), 0);
        for (Proveedor p : dcData.listaProveedoresPorProducto(idProducto)){
            modeloTablaProveedores.addRow(new Object []{p.getIdProveedor(), p.getRazonSocial(), p.getDomicilio(), p.getTelefono()});
        }
        jTProveedores.setModel(modeloTablaProveedores);
    }
}