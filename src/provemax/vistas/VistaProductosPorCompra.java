/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provemax.vistas;

import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import provemax.accesoADatos.CompraData;
import provemax.accesoADatos.DetalleCompraData;
import provemax.accesoADatos.ProductoData;
import provemax.accesoADatos.ProveedorData;
import provemax.entidades.Compra;
import provemax.entidades.DetalleCompra;
import provemax.entidades.Proveedor;

/**
 *
 * @author Enzo Bulacio
 */
public class VistaProductosPorCompra extends javax.swing.JInternalFrame {
    private DefaultTableModel modeloTablaProveedores = new DefaultTableModel();
    private DefaultTableModel modeloTablaCompras = new DefaultTableModel();
    private DefaultTableModel modeloTablaDC = new DefaultTableModel();
    private DefaultTableModel modeloTablaDCTotal = new DefaultTableModel();
    
    private DefaultComboBoxModel modeloCB = new DefaultComboBoxModel();
    private DetalleCompraData dcData = new DetalleCompraData();
    private ProductoData prodData = new ProductoData();
    private CompraData compraData = new CompraData();
    private ProveedorData provData = new ProveedorData();
    private TextAutoCompleter ac;
    private ArrayList<Compra> listaCompras = new ArrayList<>(compraData.listarCompras());
    
    /**
     * Creates new form VistaComprasPorProveedor
     */
    public VistaProductosPorCompra() {
        initComponents();
//        inicializarTablaProveedores();
//        cargarAutoCompleter();
        formatearTablaCompras();
        formatearTablaDetalleCompra();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTCompras = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTDetalleCompras = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTDetalleComprasTotal = new javax.swing.JTable();

        setClosable(true);
        setTitle("Productos por Compra");
        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Productos por Compra");

        jLabel2.setText("Selecciona un Proveedor");

        jTFBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFBusquedaKeyReleased(evt);
            }
        });

        jTCompras.setAutoCreateRowSorter(true);
        jTCompras.setModel(new javax.swing.table.DefaultTableModel(
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
        jTCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTComprasMouseReleased(evt);
            }
        });
        jTCompras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTComprasKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTCompras);

        jTDetalleCompras.setAutoCreateRowSorter(true);
        jTDetalleCompras.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTDetalleCompras);

        jLabel3.setText("Detalle de Compra");

        jScrollPane4.setBackground(new java.awt.Color(255, 51, 51));
        jScrollPane4.setBorder(null);

        jTDetalleComprasTotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jTDetalleComprasTotal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTDetalleComprasTotal.getTableHeader().setResizingAllowed(false);
        jTDetalleComprasTotal.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTDetalleComprasTotal);
        if (jTDetalleComprasTotal.getColumnModel().getColumnCount() > 0) {
            jTDetalleComprasTotal.getColumnModel().getColumn(0).setResizable(false);
            jTDetalleComprasTotal.getColumnModel().getColumn(1).setResizable(false);
            jTDetalleComprasTotal.getColumnModel().getColumn(2).setResizable(false);
            jTDetalleComprasTotal.getColumnModel().getColumn(3).setResizable(false);
        }

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
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(48, 48, 48)
                                    .addComponent(jTFBusqueda))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel3))
                        .addGap(0, 31, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBusquedaKeyReleased
        filtrarComprasPorBusqueda();
    }//GEN-LAST:event_jTFBusquedaKeyReleased

    private void jTComprasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTComprasMouseReleased
        cargarTablaDetalleCompras();
    }//GEN-LAST:event_jTComprasMouseReleased

    private void jTComprasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTComprasKeyReleased
        cargarTablaDetalleCompras();
    }//GEN-LAST:event_jTComprasKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTCompras;
    private javax.swing.JTable jTDetalleCompras;
    private javax.swing.JTable jTDetalleComprasTotal;
    private javax.swing.JTextField jTFBusqueda;
    // End of variables declaration//GEN-END:variables

//    private void cargarAutoCompleter(){
//        ac = new TextAutoCompleter(jTFBusqueda);
//        for (Proveedor p : provData.listarProveedores()){
//            ac.addItem(p.getRazonSocial());
//        }
//    }
    

    private void formatearTablaCompras(){
        modeloTablaCompras.setColumnIdentifiers(new Object [] {"Código", "Proveedor", "Fecha"});
        
        for (Compra c : compraData.listarCompras()){
            modeloTablaCompras.addRow(new Object [] {c.getIdCompra(), c.getProveedor().getRazonSocial(), c.getFecha()});
        }
        
        
        jTCompras.setModel(modeloTablaCompras);
        jTCompras.getColumnModel().getColumn(0).setPreferredWidth(15);
        jTCompras.getColumnModel().getColumn(1).setPreferredWidth(45);
        jTCompras.getColumnModel().getColumn(2).setPreferredWidth(40);
         
    }
    
     private void formatearTablaDetalleCompra(){
         DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
         centerRenderer.setHorizontalAlignment(SwingConstants.RIGHT); // Centro
         modeloTablaDC.setColumnIdentifiers(new Object[]{"Código", "Producto", "Cantidad", "Costo", "SubTotal"});
         modeloTablaDCTotal.setColumnCount(5);
         modeloTablaDCTotal.setRowCount(1);
         jTDetalleComprasTotal.setModel(modeloTablaDCTotal);
         jTDetalleComprasTotal.setTableHeader(null);
         jTDetalleComprasTotal.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
         jTDetalleComprasTotal.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

         jTDetalleCompras.setModel(modeloTablaDC);
         jTDetalleCompras.getColumnModel().getColumn(0).setPreferredWidth(48);
         jTDetalleCompras.getColumnModel().getColumn(1).setPreferredWidth(180);
         jTDetalleCompras.getColumnModel().getColumn(2).setPreferredWidth(90);
         jTDetalleCompras.getColumnModel().getColumn(3).setPreferredWidth(90);
         jTDetalleCompras.getColumnModel().getColumn(4).setPreferredWidth(90);
         jTDetalleCompras.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
         jTDetalleCompras.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
         jTDetalleCompras.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

         
    }

     private void filtrarComprasPorBusqueda(){
        modeloTablaCompras.setRowCount(0);
        for (Compra c : listaCompras){
            if (c.getProveedor().getRazonSocial().toLowerCase().contains(jTFBusqueda.getText().toLowerCase())
                ||c.getFecha().toString().toLowerCase().contains(jTFBusqueda.getText().toLowerCase())){
                modeloTablaCompras.addRow(new Object[] {c.getIdCompra(), c.getProveedor().getRazonSocial(), c.getFecha()});
            }
        }
        jTCompras.setModel(modeloTablaCompras);
    }
    
    
   
        private void cargarTablaDetalleCompras(){
        double total =0;
        modeloTablaDC.setRowCount(0);
        modeloTablaDCTotal.setRowCount(0);
        for (DetalleCompra dc : dcData.listarDetalleCompraPorCompra((int)jTCompras.getValueAt(jTCompras.getSelectedRow(), 0))){
            modeloTablaDC.addRow(new Object [] {dc.getProducto().getIdProducto(), dc.getProducto().getNombre(), dc.getCantidad(), dc.getPrecioCosto(), ((int)dc.getCantidad() *(double) dc.getPrecioCosto())});
            total +=((int)dc.getCantidad() *(double) dc.getPrecioCosto());
        }
        
        modeloTablaDCTotal.addRow(new Object [] {">>",">>",">>", "TOTAL", total});
        
    }
    
    private void limpiarTablaDetalle(){
        modeloTablaDC.setRowCount(0);
        modeloTablaDCTotal.setRowCount(0);
    }
}
