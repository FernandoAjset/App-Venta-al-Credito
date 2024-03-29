/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domain.MetodosProducto;
import domain.Producto;
import java.awt.Cursor;
import javax.swing.JOptionPane;

/**
 *
 * @author ferna
 */
public class IngresoP extends javax.swing.JFrame {

    public IngresoP() {
        initComponents();
        setLocationRelativeTo(null);
        bmenu.setOpaque(false);
        bmenu.setContentAreaFilled(false);
        bmenu.setBorderPainted(false);
        bmenu.setCursor(new Cursor(HAND_CURSOR));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        producto = new javax.swing.JLabel();
        nproducto = new javax.swing.JTextField();
        precio = new javax.swing.JLabel();
        pproducto = new javax.swing.JTextField();
        jButtonIngresar = new javax.swing.JButton();
        unidades = new javax.swing.JLabel();
        uproducto = new javax.swing.JTextField();
        bmenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        producto.setText("Nombre del producto");

        precio.setText("Precio del producto");

        jButtonIngresar.setText("Ingresar");
        jButtonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIngresarActionPerformed(evt);
            }
        });

        unidades.setText("Unidades a Ingresar");

        bmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/home.png"))); // NOI18N
        bmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(producto)
                    .addComponent(nproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(uproducto, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(unidades, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                        .addComponent(bmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pproducto, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(precio, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(113, 113, 113))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(producto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(unidades)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(precio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonIngresar)
                    .addComponent(bmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 458, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 326, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngresarActionPerformed
        // TODO add your handling code here:
        Producto nuevoProducto = new Producto();
        try {
            int codigoNuevo = MetodosProducto.CodigoUltimo() + 1;
            int cantidadInicial = Integer.parseInt(uproducto.getText());
            double precioProducto = Double.parseDouble(pproducto.getText());
            if (cantidadInicial >= 0 && precioProducto >= 0) {
                nuevoProducto.setCodigoProducto(codigoNuevo);
                nuevoProducto.setNombreProducto(nproducto.getText());
                nuevoProducto.setPrecioProducto(precioProducto);

                MetodosProducto.GrabarNuevoProducto(nuevoProducto);
                MetodosProducto.GrabarStockInicial(nuevoProducto, cantidadInicial);
                JOptionPane.showMessageDialog(null, "SE INGRESO PRODUCTO CON EXITO\n" + "CODIGO PRODUCTO: " + codigoNuevo);
                nproducto.setText("");
                uproducto.setText("");
                pproducto.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "El Precio del producto o la cantidad de unidades no puede ser menor a cero");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL INGRESAR DATOS, VERIFIQUE");
        }
    }//GEN-LAST:event_jButtonIngresarActionPerformed


    private void bmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmenuActionPerformed
        // TODO add your handling code here:
        nproducto.setText("");
        uproducto.setText("");
        pproducto.setText("");
        ui.VPrincipal mostrar = new ui.VPrincipal();
        mostrar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bmenuActionPerformed

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
            java.util.logging.Logger.getLogger(IngresoP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresoP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresoP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresoP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresoP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bmenu;
    private javax.swing.JButton jButtonIngresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nproducto;
    private javax.swing.JTextField pproducto;
    private javax.swing.JLabel precio;
    private javax.swing.JLabel producto;
    private javax.swing.JLabel unidades;
    private javax.swing.JTextField uproducto;
    // End of variables declaration//GEN-END:variables
}
