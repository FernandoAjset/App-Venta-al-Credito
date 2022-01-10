/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domain.MetodosCliente;
import domain.MetodosDocumentos;
import java.awt.Cursor;
import java.awt.Dimension;
import static java.awt.Frame.HAND_CURSOR;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author ferna
 */
public class BuscarFactura extends javax.swing.JFrame {

    public static String nombre;
    public static int nfactura = 0;
    public static int codigoCliente = 0;

    /**
     * Creates new form BuscarFactura
     */
    public BuscarFactura() {
        this.setSize(new Dimension(800, 700));
        this.setMinimumSize(new Dimension(800, 700));
        initComponents();
        cargarClientes();
        verfactura.setEnabled(false);
        tablafacturas.setEnabled(false);
        vercontrato.setEnabled(false);
        setLocationRelativeTo(null);
                        bmenu.setOpaque(false);
        bmenu.setContentAreaFilled(false);
        bmenu.setBorderPainted(false);
        bmenu.setCursor(new Cursor(HAND_CURSOR));
    }

    private void cargarClientes() {
        DefaultTableModel modelo = (DefaultTableModel) jTableClientes.getModel();
        ArrayList<Vector> listadoClientes = MetodosCliente.MostrarClientes();
        int cont = 0;
        modelo.setRowCount(0);
        while (cont < listadoClientes.size()) {
            modelo.addRow(listadoClientes.get(cont));
            cont++;
        }
    }

    public void cargarFacturas(int idCliente) {
        DefaultTableModel modelo = (DefaultTableModel) tablafacturas.getModel();
        modelo.setRowCount(0);
        ArrayList<Vector> listadoFacturas = new ArrayList();
        listadoFacturas = MetodosDocumentos.MostrarTodasFacturas(idCliente);
        int cont = 0;
        while (cont < listadoFacturas.size()) {
            modelo.addRow(listadoFacturas.get(cont));
            cont++;
        }
    }

    public void limpiartabla() {
        DefaultTableModel modelo = (DefaultTableModel) tablafacturas.getModel();
        int a = tablafacturas.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            modelo.removeRow(modelo.getRowCount() - 1);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedConsultaDocumentos = new javax.swing.JTabbedPane();
        jPanelBuscarFactura = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        facturaSeleccionada = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ccliente = new javax.swing.JTextField();
        panelfacturascliente = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablafacturas = new javax.swing.JTable();
        buscar = new javax.swing.JButton();
        verfactura = new javax.swing.JButton();
        vercontrato = new javax.swing.JButton();
        bmenu = new javax.swing.JButton();
        jPanelMostrarClientes = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jLabelTitle = new javax.swing.JLabel();
        jLabelClienteSeleccionado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTabbedConsultaDocumentos.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("INGRESAR EL CODIGO DEL CLIENTE PARA VER LAS FACTURAS QUE POSEE");

        facturaSeleccionada.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        facturaSeleccionada.setForeground(new java.awt.Color(255, 0, 0));
        facturaSeleccionada.setText("No. Factura: ");

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PARA BUSCAR UNA FACTURA");

        jLabel1.setText("Codigo Cliente:");

        tablafacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No. FACTURA", "ID CLIENTE", "NOMBRE"
            }
        ));
        tablafacturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablafacturasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablafacturas);

        javax.swing.GroupLayout panelfacturasclienteLayout = new javax.swing.GroupLayout(panelfacturascliente);
        panelfacturascliente.setLayout(panelfacturasclienteLayout);
        panelfacturasclienteLayout.setHorizontalGroup(
            panelfacturasclienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelfacturasclienteLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelfacturasclienteLayout.setVerticalGroup(
            panelfacturasclienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelfacturasclienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        buscar.setText("BUSCAR");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        verfactura.setText("Ver Factura");
        verfactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verfacturaActionPerformed(evt);
            }
        });

        vercontrato.setText("Ver Contrato");
        vercontrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vercontratoActionPerformed(evt);
            }
        });

        bmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/home.png"))); // NOI18N
        bmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBuscarFacturaLayout = new javax.swing.GroupLayout(jPanelBuscarFactura);
        jPanelBuscarFactura.setLayout(jPanelBuscarFacturaLayout);
        jPanelBuscarFacturaLayout.setHorizontalGroup(
            jPanelBuscarFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBuscarFacturaLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(verfactura, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(vercontrato, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(bmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
            .addGroup(jPanelBuscarFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelBuscarFacturaLayout.createSequentialGroup()
                    .addGap(0, 48, Short.MAX_VALUE)
                    .addGroup(jPanelBuscarFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelBuscarFacturaLayout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addGroup(jPanelBuscarFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelBuscarFacturaLayout.createSequentialGroup()
                                    .addGap(84, 84, 84)
                                    .addComponent(ccliente, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanelBuscarFacturaLayout.createSequentialGroup()
                            .addGap(222, 222, 222)
                            .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelBuscarFacturaLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(jPanelBuscarFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(panelfacturascliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanelBuscarFacturaLayout.createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addComponent(facturaSeleccionada, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGap(0, 48, Short.MAX_VALUE)))
        );
        jPanelBuscarFacturaLayout.setVerticalGroup(
            jPanelBuscarFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBuscarFacturaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelBuscarFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verfactura, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vercontrato, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBuscarFacturaLayout.createSequentialGroup()
                .addGap(0, 485, Short.MAX_VALUE)
                .addComponent(bmenu))
            .addGroup(jPanelBuscarFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelBuscarFacturaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(6, 6, 6)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(1, 1, 1)
                    .addGroup(jPanelBuscarFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ccliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelBuscarFacturaLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(10, 10, 10)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addGroup(jPanelBuscarFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelfacturascliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelBuscarFacturaLayout.createSequentialGroup()
                            .addGap(280, 280, 280)
                            .addComponent(facturaSeleccionada, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 91, Short.MAX_VALUE)))
        );

        jTabbedConsultaDocumentos.addTab("Buscar Documento", jPanelBuscarFactura);

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Apellido", "Direccion", "NIT", "Telefono"
            }
        ));
        jTableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableClientes);

        jLabelTitle.setText("SELECCIONE UN CLIENTE PARA BUSCAR SUS DOCUMENTOS.");

        jLabelClienteSeleccionado.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabelClienteSeleccionado.setForeground(new java.awt.Color(255, 51, 51));
        jLabelClienteSeleccionado.setText("CODIGO SELECCIONADO: ");

        javax.swing.GroupLayout jPanelMostrarClientesLayout = new javax.swing.GroupLayout(jPanelMostrarClientes);
        jPanelMostrarClientes.setLayout(jPanelMostrarClientesLayout);
        jPanelMostrarClientesLayout.setHorizontalGroup(
            jPanelMostrarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMostrarClientesLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanelMostrarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
                    .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelClienteSeleccionado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanelMostrarClientesLayout.setVerticalGroup(
            jPanelMostrarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMostrarClientesLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabelTitle)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelClienteSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        jTabbedConsultaDocumentos.addTab("Mostrar Clientes", jPanelMostrarClientes);

        getContentPane().add(jTabbedConsultaDocumentos);
        jTabbedConsultaDocumentos.setBounds(0, 0, 730, 570);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
        boolean existe;
        try {
            int id = Integer.parseInt(ccliente.getText());
            if ((nfactura == 0) && (ccliente.getText().length() == 0)) {
                JOptionPane.showMessageDialog(null, "INGRESE UN CAMPO PARA BUSCAR FACTURA");
                verfactura.setEnabled(false);
                vercontrato.setEnabled(false);
                tablafacturas.setEnabled(false);
                ccliente.setText("");
                ccliente.requestFocus();
                nfactura = 0;
                facturaSeleccionada.setText("");
                limpiartabla();
            }
            if ((ccliente.getText().length() != 0)) {
                id = Integer.parseInt(ccliente.getText());
                if (domain.MetodosCliente.ExisteCodigoCliente(id) == true) {
                    JOptionPane.showMessageDialog(null, "CODIGO DE CLIENTE CORRECTO, SE MOSTRARAN SUS FACTURAS");
                    cargarFacturas(id);
                    tablafacturas.setEnabled(true);
                    verfactura.setEnabled(true);
                    vercontrato.setEnabled(true);
                    nfactura = 0;
                    facturaSeleccionada.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "ID DE CLIENTE NO EXISTE");
                    verfactura.setEnabled(false);
                    vercontrato.setEnabled(false);
                    tablafacturas.setEnabled(false);
                    ccliente.setText("");
                    ccliente.requestFocus();
                    nfactura = 0;
                    facturaSeleccionada.setText("");
                    limpiartabla();
                }
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL INGRESAR DATOS, VERIFIQUE");
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void verfacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verfacturaActionPerformed
        boolean existeFactura = MetodosDocumentos.ExisteFactura(nfactura);
        if (existeFactura) {
            VerFactura factura = new VerFactura();
            factura.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "ASEGURESE DE HABER SELECCIONADO UNA FACTURA");
        }
    }//GEN-LAST:event_verfacturaActionPerformed

    private void vercontratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vercontratoActionPerformed
        boolean existeFactura = MetodosDocumentos.ExisteFactura(nfactura);
        if (existeFactura) {
            VerContrato contrato = new VerContrato();
            contrato.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "ASEGURESE DE HABER SELECCIONADO UNA FACTURA");
        }
    }//GEN-LAST:event_vercontratoActionPerformed

    private void tablafacturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablafacturasMouseClicked
        int seleccionar = tablafacturas.rowAtPoint(evt.getPoint());
        String aux = String.valueOf(tablafacturas.getValueAt(seleccionar, 0));
        nombre = String.valueOf(tablafacturas.getValueAt(seleccionar, 2));
        nfactura = Integer.parseInt(aux);
        facturaSeleccionada.setText("Factura seleccionada: " + String.valueOf(tablafacturas.getValueAt(seleccionar, 0)));
    }//GEN-LAST:event_tablafacturasMouseClicked

    private void jTableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientesMouseClicked
        int seleccionar = jTableClientes.rowAtPoint(evt.getPoint());
        String aux = String.valueOf(jTableClientes.getValueAt(seleccionar, 0));
        codigoCliente = Integer.parseInt(aux);
        jLabelClienteSeleccionado.setText("CODIGO SELECCIONADO: " + String.valueOf(jTableClientes.getValueAt(seleccionar, 0)));
        if (codigoCliente != 0) {
            ccliente.setText(String.valueOf(codigoCliente));
            limpiartabla();
            nfactura = 0;
            verfactura.setEnabled(false);
            vercontrato.setEnabled(false);
            facturaSeleccionada.setText("");
        }
    }//GEN-LAST:event_jTableClientesMouseClicked

    private void bmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmenuActionPerformed
        limpiartabla();
        ccliente.setText("");
        facturaSeleccionada.setText("");
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
            java.util.logging.Logger.getLogger(BuscarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarFactura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bmenu;
    private javax.swing.JButton buscar;
    private javax.swing.JTextField ccliente;
    private javax.swing.JLabel facturaSeleccionada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelClienteSeleccionado;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanelBuscarFactura;
    private javax.swing.JPanel jPanelMostrarClientes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedConsultaDocumentos;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JPanel panelfacturascliente;
    private javax.swing.JTable tablafacturas;
    private javax.swing.JButton vercontrato;
    private javax.swing.JButton verfactura;
    // End of variables declaration//GEN-END:variables
}
