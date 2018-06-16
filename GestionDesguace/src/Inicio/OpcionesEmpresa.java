/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import Registro.Registro;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Adrián
 */
public class OpcionesEmpresa extends javax.swing.JDialog {

    /**
     * Creates new form OpcionesEmpresa
     */
    public static String elegido;
    PrincipalGestion intro = null;
    JFrame padre;

    public OpcionesEmpresa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        padre = (JFrame) parent;
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((pantalla.width / 2) - (this.getWidth() / 2), (pantalla.height / 2) - (this.getHeight() / 2));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnVMarca = new javax.swing.JButton();
        btnVPieza = new javax.swing.JButton();
        btnRecambio = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnVMarca.setText("Gestionar coches");
        btnVMarca.setActionCommand("Gestionar coches");
        btnVMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVMarcaActionPerformed(evt);
            }
        });

        btnVPieza.setText("Gestionar piezas");
        btnVPieza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVPiezaActionPerformed(evt);
            }
        });

        btnRecambio.setText("Gestionar recambios");
        btnRecambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecambioActionPerformed(evt);
            }
        });

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVPieza, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRecambio, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVMarca)
                .addGap(18, 18, 18)
                .addComponent(btnVPieza)
                .addGap(18, 18, 18)
                .addComponent(btnRecambio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVMarcaActionPerformed
        // TODO add your handling code here:
        setValor("Marca");
        try {
            intro = new PrincipalGestion();
        } catch (SQLException ex) {
            Logger.getLogger(OpcionesEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
        padre.setVisible(false);
        intro.setVisible(true);
        //this.setVisible(false);
    }//GEN-LAST:event_btnVMarcaActionPerformed

    private void btnVPiezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVPiezaActionPerformed
        // TODO add your handling code here:
        setValor("Pieza");
        try {
            intro = new PrincipalGestion();
        } catch (SQLException ex) {
            Logger.getLogger(OpcionesEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
        padre.setVisible(false);
        intro.setVisible(true);
        //this.setVisible(false);
    }//GEN-LAST:event_btnVPiezaActionPerformed

    private void btnRecambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecambioActionPerformed
        // TODO add your handling code here:
        setValor("Recambio");
        try {
            intro = new PrincipalGestion();
        } catch (SQLException ex) {
            Logger.getLogger(OpcionesEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
        padre.setVisible(false);
        intro.setVisible(true);
    }//GEN-LAST:event_btnRecambioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        //padre.dispose();
        //Registro r = new Registro();
        //r.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    public String getValor() {
        return elegido;
    }

    public static void setValor(String el) {
        OpcionesEmpresa.elegido = el;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRecambio;
    private javax.swing.JButton btnVMarca;
    private javax.swing.JButton btnVPieza;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
