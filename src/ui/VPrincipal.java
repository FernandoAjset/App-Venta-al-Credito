/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Dimension;

/**
 *
 * @author fernando
 */
public class VPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VPrincipal
     */
    public VPrincipal() {
        initComponents();
        this.setSize(new Dimension(650, 550));
        this.setMinimumSize(new Dimension(500, 400));
        jMenuReportes.setVisible(false);
        jMenuReportes.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenuProductos = new javax.swing.JMenu();
        jMenuItemCrearProducto = new javax.swing.JMenuItem();
        jMenuItemActualizarStock = new javax.swing.JMenuItem();
        jMenuItemActualizarProducto = new javax.swing.JMenuItem();
        jMenuClientes = new javax.swing.JMenu();
        jMenuItemCrearCliente = new javax.swing.JMenuItem();
        jMenuItemEditarCliente = new javax.swing.JMenuItem();
        jMenuTransacciones = new javax.swing.JMenu();
        jMenuItemVenta = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuReportes = new javax.swing.JMenu();
        jMenuItemDeudores = new javax.swing.JMenuItem();
        jMenuItemMejorCliente = new javax.swing.JMenuItem();
        jMenuItemSaldos = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jMenuProductos.setText("Productos");

        jMenuItemCrearProducto.setText("Crear Producto");
        jMenuItemCrearProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCrearProductoActionPerformed(evt);
            }
        });
        jMenuProductos.add(jMenuItemCrearProducto);

        jMenuItemActualizarStock.setText("Ingresar Stock");
        jMenuItemActualizarStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemActualizarStockActionPerformed(evt);
            }
        });
        jMenuProductos.add(jMenuItemActualizarStock);

        jMenuItemActualizarProducto.setText("Actualizar Producto");
        jMenuItemActualizarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemActualizarProductoActionPerformed(evt);
            }
        });
        jMenuProductos.add(jMenuItemActualizarProducto);

        jMenuBar2.add(jMenuProductos);

        jMenuClientes.setText("Clientes");

        jMenuItemCrearCliente.setText("Crear cliente");
        jMenuItemCrearCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCrearClienteActionPerformed(evt);
            }
        });
        jMenuClientes.add(jMenuItemCrearCliente);

        jMenuItemEditarCliente.setText("Editar cliente");
        jMenuItemEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEditarClienteActionPerformed(evt);
            }
        });
        jMenuClientes.add(jMenuItemEditarCliente);

        jMenuBar2.add(jMenuClientes);

        jMenuTransacciones.setText("Transacciones");

        jMenuItemVenta.setText("Nueva venta");
        jMenuItemVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVentaActionPerformed(evt);
            }
        });
        jMenuTransacciones.add(jMenuItemVenta);

        jMenuItem1.setText("Buscar factura/contrato");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuTransacciones.add(jMenuItem1);

        jMenuBar2.add(jMenuTransacciones);

        jMenuReportes.setText("Reportes");

        jMenuItemDeudores.setText("Deudores");
        jMenuReportes.add(jMenuItemDeudores);

        jMenuItemMejorCliente.setText("Consulta del mejor / peor cliente");
        jMenuReportes.add(jMenuItemMejorCliente);

        jMenuItemSaldos.setText("Saldos");
        jMenuReportes.add(jMenuItemSaldos);

        jMenuBar2.add(jMenuReportes);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCrearProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCrearProductoActionPerformed
        ui.IngresoP obj = new ui.IngresoP();
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItemCrearProductoActionPerformed

    private void jMenuItemActualizarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemActualizarStockActionPerformed
        ui.IngresarStock obj = new ui.IngresarStock();
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItemActualizarStockActionPerformed

    private void jMenuItemCrearClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCrearClienteActionPerformed
        ui.IngresoC obj = new ui.IngresoC();
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItemCrearClienteActionPerformed

    private void jMenuItemVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVentaActionPerformed
        ui.Venta obj = new ui.Venta();
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItemVentaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        ui.BuscarFactura obj = new ui.BuscarFactura();
        obj.setVisible(true);

        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItemActualizarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemActualizarProductoActionPerformed
        ActualizarProducto nuevo = new ActualizarProducto();
        nuevo.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItemActualizarProductoActionPerformed

    private void jMenuItemEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEditarClienteActionPerformed
        ActualizarCliente nuevo = new ActualizarCliente();
        nuevo.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItemEditarClienteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VPrincipal().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenu jMenuClientes;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemActualizarProducto;
    private javax.swing.JMenuItem jMenuItemActualizarStock;
    private javax.swing.JMenuItem jMenuItemCrearCliente;
    private javax.swing.JMenuItem jMenuItemCrearProducto;
    private javax.swing.JMenuItem jMenuItemDeudores;
    private javax.swing.JMenuItem jMenuItemEditarCliente;
    private javax.swing.JMenuItem jMenuItemMejorCliente;
    private javax.swing.JMenuItem jMenuItemSaldos;
    private javax.swing.JMenuItem jMenuItemVenta;
    private javax.swing.JMenu jMenuProductos;
    private javax.swing.JMenu jMenuReportes;
    private javax.swing.JMenu jMenuTransacciones;
    // End of variables declaration//GEN-END:variables
}
