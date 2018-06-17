/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import Conexion.ConexionBD;
import Registro.Registro;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.security.Principal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.help.HelpSetException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Adrián
 */
public class Compra extends javax.swing.JDialog {

    float precio = 0;
    int cantidad = 0;
    Connection conexion = ConexionBD.conexion();
    PrincipalUsuario priU;
    PiezaUsuario piU;
    Registro r;

    public Compra(java.awt.Frame parent, boolean modal) throws SQLException, MalformedURLException, HelpSetException {
        super(parent, modal);
        initComponents();
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((pantalla.width / 2) - (this.getWidth() / 2), (pantalla.height / 2) - (this.getHeight() / 2));
        rellenarPC();
        getContentPane().setVisible(true);
        lblCantidad.setVisible(true);
        jLabel4.setVisible(true);

        ImageIcon carrito = new ImageIcon("iconos/carrito.png");
        ImageIcon carritoDef = new ImageIcon(carrito.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));

        ImageIcon cancelar = new ImageIcon("iconos/cancelar.png");
        ImageIcon cancelarDef = new ImageIcon(cancelar.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));

        ImageIcon volver = new ImageIcon("iconos/volver.png");
        ImageIcon volverDef = new ImageIcon(volver.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));

        btnComprar.setIcon(carritoDef);
        btnCancelar.setIcon(cancelarDef);
        priU = new PrincipalUsuario();
        piU = new PiezaUsuario();

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
        jLabel1 = new javax.swing.JLabel();
        txtPieza = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCoche = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnComprar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacion Pieza"));

        jLabel1.setText("Pieza Seleccionada: ");

        txtPieza.setEnabled(false);
        txtPieza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPiezaActionPerformed(evt);
            }
        });

        jLabel2.setText("Coche:");

        txtCoche.setEnabled(false);

        jLabel3.setText("Precio:");

        lblPrecio.setForeground(new java.awt.Color(255, 153, 51));

        jLabel4.setText("Cantidad disponible:");

        lblCantidad.setForeground(new java.awt.Color(153, 204, 0));
        lblCantidad.setText("jLabel5");

        jLabel5.setText("Cantidad");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(54, 54, 54)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(200, 200, 200))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txtCantidad)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(63, 63, 63))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(64, 64, 64)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCoche)
                                    .addComponent(txtPieza))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(lblPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(202, 202, 202))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtCoche))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtPieza))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtCantidad))
                .addContainerGap())
        );

        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(286, 286, 286)
                .addComponent(btnComprar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnComprar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPiezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPiezaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPiezaActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        // TODO add your handling code here:
        try {
            Statement s = conexion.createStatement();
            //System.out.println(cantidad);

            //System.out.println( Integer.parseInt(txtCantidad.getText()));
            if (cantidad >= Integer.parseInt(txtCantidad.getText())) {
                int idUsuario = 0;
                int idRecambio = 0;
                int idCarrito = 0;
                ResultSet rs = s.executeQuery("SELECT u.`P_Usuario`\n"
                        + "FROM usuario u\n"
                        + "WHERE u.`Usuario` = '" + r.getUsername() + "'");

                while (rs.next()) {
                    idUsuario = rs.getInt(1);
                }
                String insertinto = "INSERT INTO carrito VALUES(null , " + idUsuario + " );";
                System.out.println(insertinto);
                s.executeUpdate(insertinto);

                ResultSet rs2 = s.executeQuery(" SELECT  r.`P_Recambio` \n"
                        + "    FROM recambio r , pieza p , motor m , modelomotor mm , modelo mo\n"
                        + "    WHERE r.`A_Pieza` = p.`P_Pieza`\n"
                        + "    AND r.`A_Motor` = m.`P_Motor`\n"
                        + "    AND mm.`A_Motor`=m.`P_Motor`\n"
                        + "    AND mm.`A_Modelo`= mo.`P_Modelo`\n"
                        + "    AND mo.`Nombre` = '" + priU.getModelo() + "'\n"
                        + "    AND p.`Nombre`= '" + piU.getPieza() + "'");
                while (rs2.next()) {
                    idRecambio = rs2.getInt(1);
                }
                ResultSet rs3 = s.executeQuery("SELECT c.`P_Carrito`\n"
                        + "       FROM carrito c , usuario u\n"
                        + "       WHERE c.`A_Usuario`=u.`P_Usuario`\n"
                        + "       AND u.`P_Usuario` = '" + idUsuario + "'");
                while (rs3.next()) {
                    idCarrito = rs3.getInt(1);
                }
                String icarre = "INSERT INTO car_re VALUES(null , " + idCarrito + ", " + idRecambio + ", " + txtCantidad.getText() + " );";
                s.executeUpdate(icarre);
                int idDesguace = 0;
                ResultSet rs4 = s.executeQuery("SELECT r.`A_Desguace`\n"
                        + "                    FROM recambio r\n"
                        + "                    WHERE r.`P_Recambio`=" + idRecambio);
                while (rs4.next()) {
                    idDesguace = rs4.getInt(1);
                }
                Calendar fecha = Calendar.getInstance();
                int año = fecha.get(Calendar.YEAR);
                int mes = fecha.get(Calendar.MONTH) + 1;
                int dia = fecha.get(Calendar.DAY_OF_MONTH);
                String fech = dia + "/" + mes + "/" + año;
                System.out.println(fech);
                String ifactura = "INSERT INTO factura VALUES(null ,'" + fech + "', " + idCarrito + " , " + idDesguace + " );";
                System.out.println(ifactura);
                s.executeUpdate(ifactura);

                String actualizarStock = "UPDATE recambio SET CantidadDisponible = CantidadDisponible-" + txtCantidad.getText() + " WHERE P_recambio = " + idRecambio;
                s.executeUpdate(actualizarStock);

                try {
                    int factura = 0;
                    ResultSet rs5 = s.executeQuery("SELECT f.`P_Factura`\n"
                            + "FROM factura f\n"
                            + "WHERE f.`A_Carrito`= " + idCarrito + " "
                            + "AND f.`A_Desguace` =" + idDesguace);
                    while (rs5.next()) {
                        factura = rs5.getInt(1);
                    }
                    Map parametros = new HashMap();
                    parametros.put("factura", factura);
                    JasperPrint print = JasperFillManager.fillReport("./report/Factura.jasper", parametros, conexion);

                    JasperExportManager.exportReportToPdfFile(print, "./PDF/Informe1.pdf");

                    File path = new File("./PDF/Informe1.pdf");
                    Desktop.getDesktop().open(path);
                } catch (JRException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.setVisible(false);
                piU.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "No hay disponible tanto stock como el solicitado.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        piU.setVisible(true);
    }//GEN-LAST:event_btnComprarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        PrincipalUsuario pu;
        try {
            pu = new PrincipalUsuario();
            pu.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HelpSetException ex) {
            Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    public void rellenarPC() throws SQLException {
        Statement s = conexion.createStatement();
        txtCoche.setText(priU.getCoche());
        txtPieza.setText(piU.getPieza());

        ResultSet rs = s.executeQuery("SELECT  r.`Precio` , r.`CantidadDisponible` \n"
                + "    FROM recambio r , pieza p , motor m , modelomotor mm , modelo mo\n"
                + "    WHERE r.`A_Pieza` = p.`P_Pieza`\n"
                + "    AND r.`A_Motor` = m.`P_Motor`\n"
                + "    AND mm.`A_Motor`=m.`P_Motor`\n"
                + "    AND mm.`A_Modelo`= mo.`P_Modelo`\n"
                + "    AND mo.`Nombre` = '" + priU.getModelo() + "'\n"
                + "    AND p.`Nombre`= '" + piU.getPieza() + "'");
        while (rs.next()) {
            precio = rs.getFloat(1);
            cantidad = rs.getInt(2);
            if (cantidad == 0) {
                JOptionPane.showMessageDialog(this, "Recambio no disponible, haga click en comprar para finalizar.");
                this.dispose();
                btnComprar.setEnabled(false);
            }
            System.out.println("precio: " + precio);
            lblPrecio.setText(precio + "");
            lblCantidad.setText(cantidad + "");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnComprar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCoche;
    private javax.swing.JTextField txtPieza;
    // End of variables declaration//GEN-END:variables
}
