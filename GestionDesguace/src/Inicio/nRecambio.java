/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import Conexion.ConexionBD;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.help.HelpSetException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Adrián
 */
public class nRecambio extends javax.swing.JDialog {

    /**
     * Creates new form nRecambio
     */
    Connection conexion = ConexionBD.conexion();
    Statement s;
    PrincipalGestion pg;
    JFrame padre;

    public nRecambio(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((pantalla.width / 2) - (this.getWidth() / 2), (pantalla.height / 2) - (this.getHeight() / 2));
        rellenoJC();
        padre = (JFrame) parent;
        /*if (pg.getAccion() == "Modificar") {
            System.out.println("Modificar");
            rellenoJCM();
        }*/
        ImageIcon volver = new ImageIcon("iconos/volver.png");
        ImageIcon volverDef = new ImageIcon(volver.getImage().getScaledInstance(30, 20, Image.SCALE_DEFAULT));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbMarca = new javax.swing.JComboBox<>();
        cbModelo = new javax.swing.JComboBox<>();
        cbPieza = new javax.swing.JComboBox<>();
        cbTipo = new javax.swing.JComboBox<>();
        cbDesguace = new javax.swing.JComboBox<>();
        txtCantidad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnAñadir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Marca");

        jLabel2.setText("Modelo");

        jLabel3.setText("Tipo");

        jLabel4.setText("Pieza");

        jLabel5.setText("Desguaces");

        jLabel6.setText("Cantidad");

        cbMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMarcaActionPerformed(evt);
            }
        });

        cbModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbModeloActionPerformed(evt);
            }
        });

        cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoActionPerformed(evt);
            }
        });

        jLabel8.setText("Precio");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(7, 7, 7)))
                        .addGap(103, 103, 103)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbMarca, javax.swing.GroupLayout.Alignment.TRAILING, 0, 130, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbModelo, 0, 127, Short.MAX_VALUE)
                                .addGap(3, 3, 3))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                        .addGap(114, 114, 114)
                        .addComponent(cbTipo, 0, 127, Short.MAX_VALUE)
                        .addGap(3, 3, 3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(9, 9, 9))
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(23, 23, 23))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(27, 27, 27)))
                        .addGap(90, 90, 90)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbPieza, javax.swing.GroupLayout.Alignment.TRAILING, 0, 127, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbDesguace, 0, 124, Short.MAX_VALUE)
                                    .addComponent(txtCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                                .addGap(3, 3, 3)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cbMarca))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cbModelo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTipo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cbPieza))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cbDesguace))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtCantidad))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtPrecio))
                .addContainerGap())
        );

        btnAñadir.setText("Añadir Recambio");
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAñadir, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAñadir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(61, 61, 61))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(240, 240, 240))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
        // TODO add your handling code here: 
        try {
            s = conexion.createStatement();

            int a_motor = 0;
            int a_pieza = 0;
            int a_desguace = 0;
            ResultSet rs = s.executeQuery("SELECT mo.P_Motor \n"
                    + "                    FROM modelo m , motor mo , modelomotor mm \n"
                    + "                    WHERE mo.P_Motor= mm.A_Motor\n"
                    + "                    AND mm.A_Modelo = m.P_Modelo \n"
                    + "                    AND m.Nombre ='" + cbModelo.getSelectedItem().toString() + "'");
            while (rs.next()) {
                a_motor = rs.getInt(1);
            }
            System.out.println(a_motor);
            ResultSet rs2 = s.executeQuery("SELECT  p.P_Pieza "
                    + "                    FROM pieza p "
                    + "                    WHERE  p.Nombre = '" + cbPieza.getSelectedItem().toString() + "'");
            while (rs2.next()) {
                a_pieza = rs2.getInt(1);
            }
            ResultSet rs3 = s.executeQuery("SELECT  d.P_Desguace "
                    + "                    FROM desguace d "
                    + "                    WHERE  d.Nombre = '" + cbDesguace.getSelectedItem().toString() + "'");
            while (rs3.next()) {
                a_desguace = rs3.getInt(1);
            }
            System.out.println(a_motor + " " + a_pieza + " " + a_desguace);
            String insertinto = "INSERT INTO recambio VALUES(null , " + a_motor + " , " + a_pieza + " , " + a_desguace + " , " + txtCantidad.getText().toString() + " , " + txtPrecio.getText().toString() + ");";
            System.out.println(insertinto);
            s.executeUpdate(insertinto);

            this.dispose();
            pg = new PrincipalGestion();
            pg.setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(NModificar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(nRecambio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HelpSetException ex) {
            Logger.getLogger(nRecambio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAñadirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        padre.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMarcaActionPerformed
        // TODO add your handling code here:
        System.out.println("IOE");
        String[] modelos;
        try {
            s = conexion.createStatement();
            cbModelo.removeAllItems();
            int numModelo = 0;
            int i = 0;
            String consulta = "SELECT m.Nombre "
                    + "FROM modelo m , marca ma "
                    + "WHERE m.A_Marca= ma.P_Marca "
                    + "AND ma.Nombre ='" + cbMarca.getSelectedItem().toString() + "'";

            ResultSet rs = s.executeQuery(consulta);
            while (rs.next()) {
                numModelo++;
            }
            modelos = new String[numModelo];
            ResultSet rs2 = s.executeQuery(consulta);
            while (rs2.next()) {
                modelos[i] = rs2.getString(1);
                i++;
            }
            for (int j = 0; j < modelos.length; j++) {
                cbModelo.addItem(modelos[j]);
            }

        } catch (SQLException ex) {
            Logger.getLogger(nRecambio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbMarcaActionPerformed

    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed
        // TODO add your handling code here:
        try {
            s = conexion.createStatement();
            cbPieza.removeAllItems();
            int numPieza = 0;
            int i = 0;
            ResultSet rs = s.executeQuery("SELECT p.`Nombre`\n"
                    + "    FROM tipo t, pieza p\n"
                    + "    WHERE p.`A_Tipo`=t.`P_Tipo`\n"
                    + "    AND t.`Nombre` = '" + cbTipo.getSelectedItem().toString() + "'");
            while (rs.next()) {
                numPieza++;
            }
            String[] piezas = new String[numPieza];
            ResultSet rs2 = s.executeQuery("SELECT p.`Nombre`\n"
                    + "    FROM tipo t, pieza p\n"
                    + "    WHERE p.`A_Tipo`=t.`P_Tipo`\n"
                    + "    AND t.`Nombre` = '" + cbTipo.getSelectedItem().toString() + "'");
            while (rs2.next()) {
                piezas[i] = rs2.getString(1);
                i++;
            }
            for (int j = 0; j < piezas.length; j++) {
                //System.out.println(marcas[j]);
                cbPieza.addItem(piezas[j]);
            }

        } catch (SQLException ex) {
            Logger.getLogger(nRecambio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbTipoActionPerformed

    private void cbModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbModeloActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_cbModeloActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAñadir;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> cbDesguace;
    private javax.swing.JComboBox<String> cbMarca;
    private javax.swing.JComboBox<String> cbModelo;
    private javax.swing.JComboBox<String> cbPieza;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
    public void rellenoJCM() {
        btnAñadir.setVisible(false);
        System.out.println("Botones cambiados");
        try {
            s = conexion.createStatement();
            System.out.println("Empezamos consulta");
            String relleno = "SELECT t.`Nombre` , p.Nombre , ma.`Nombre` , mo.`Nombre`, mot.`Codigo` , d.`Nombre`, r.`CantidadDisponible` ,r.`Precio`\n"
                    + "                    FROM recambio r , marca ma , modelo mo , motor mot , modelomotor mm, desguace d , pieza p , tipo t\n"
                    + "                    WHERE r.`A_Motor` = mot.`P_Motor`\n"
                    + "                    AND r.`A_Pieza` = p.`P_Pieza`\n"
                    + "                    AND r.`A_Desguace` = d.`P_Desguace`\n"
                    + "                    AND mm.`A_Motor` = mot.`P_Motor`\n"
                    + "                    AND mm.`A_Modelo` = mo.`P_Modelo`\n"
                    + "                    AND mo.`A_Marca` = ma.`P_Marca`\n"
                    + "                    AND p.`A_Tipo` = t.`P_Tipo`\n"
                    + "                    AND r.`P_Recambio` =" + pg.getNombre();

            ResultSet rs = s.executeQuery(relleno);

            while (rs.next()) {
                //System.out.println(rs.getString(1)+"-"+rs.getString(2)+"-"+rs.getString(3)+"-"+rs.getString(4)+"-"+rs.getString(5)+"-");

                cbTipo.setSelectedItem(rs.getString(1));
                cbPieza.setSelectedItem(rs.getString(2));
                //cbModelo.setSelectedItem(rs.getString(4));

                //cbDesguace.setSelectedItem(rs.getString(6));
                /* System.out.println("Cantiodad: " + rs.getInt(7));
                txtCantidad.setText(rs.getInt(7) + "");
                System.out.println("Precio: " + rs.getInt(8));
                txtPrecio.setText(rs.getDouble(8) + "");*/
                System.out.println("BUCLE");
            }

        } catch (SQLException ex) {
            Logger.getLogger(nRecambio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void rellenoJC() {
        try {

            s = conexion.createStatement();
            //Marcas
            int numMarca = 0;
            int i = 0;
            ResultSet rs = s.executeQuery("SELECT m.Nombre "
                    + "FROM marca m");
            while (rs.next()) {
                numMarca++;
            }
            String[] marcas = new String[numMarca];
            ResultSet rs2 = s.executeQuery("SELECT m.Nombre "
                    + "FROM marca m");
            while (rs2.next()) {
                marcas[i] = rs2.getString(1);
                i++;
            }
            for (int j = 0; j < marcas.length; j++) {
                //System.out.println(marcas[j]);
                cbMarca.addItem(marcas[j]);
            }
            //Tipos
            int numTipo = 0;
            i = 0;
            ResultSet rs3 = s.executeQuery("SELECT t.Nombre "
                    + "FROM tipo t");
            while (rs3.next()) {
                numTipo++;
            }
            String[] tipos = new String[numTipo];
            ResultSet rs4 = s.executeQuery("SELECT t.Nombre "
                    + "FROM tipo t");
            while (rs4.next()) {
                tipos[i] = rs4.getString(1);
                i++;
            }
            for (int j = 0; j < tipos.length; j++) {
                //System.out.println(marcas[j]);
                cbTipo.addItem(tipos[j]);
            }
            //Desguaces
            int numDesguace = 0;
            i = 0;
            ResultSet rs5 = s.executeQuery("SELECT d.Nombre "
                    + "FROM desguace d");
            while (rs5.next()) {
                numDesguace++;
            }
            String[] desguaces = new String[numDesguace];
            ResultSet rs6 = s.executeQuery("SELECT d.Nombre "
                    + "FROM desguace d");
            while (rs6.next()) {
                desguaces[i] = rs6.getString(1);
                i++;
            }
            for (int j = 0; j < desguaces.length; j++) {
                //System.out.println(marcas[j]);
                cbDesguace.addItem(desguaces[j]);
            }

        } catch (SQLException ex) {
            Logger.getLogger(nRecambio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
