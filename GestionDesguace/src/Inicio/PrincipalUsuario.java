/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import Conexion.ConexionBD;
import Registro.Registro;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adrián
 */
public class PrincipalUsuario extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    DefaultTableModel modelo;
    Connection conexion = ConexionBD.conexion();
    static String coche;
    static String mod;
    PiezaUsuario pu;
    HelpBroker hb;
    HelpSet helpset;

    public PrincipalUsuario() throws SQLException, MalformedURLException, HelpSetException {
        initComponents();
        modelo = (DefaultTableModel) tabla.getModel();
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((pantalla.width / 2) - (this.getWidth() / 2), (pantalla.height / 2) - (this.getHeight() / 2));
        rellenoTabla();
        rellenoMarcas();

        Image rIcon = Toolkit.getDefaultToolkit().getImage("iconos/reparacion.png");
        this.setIconImage(rIcon);
        getContentPane().setBackground(Color.white);
        ImageIcon salir = new ImageIcon("iconos/salir.png");
        ImageIcon salirDef = new ImageIcon(salir.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));

        ImageIcon ayuda = new ImageIcon("iconos/help.png");
        ImageIcon ayudaDef = new ImageIcon(ayuda.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));

        ImageIcon acerca = new ImageIcon("iconos/acerca.png");
        ImageIcon acercaDef = new ImageIcon(acerca.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));

        menuSalir.setIcon(salirDef);
        menuAcerca.setIcon(acercaDef);
        menuAyuda.setIcon(ayudaDef);

        ImageIcon buscar = new ImageIcon("iconos/buscar.png");
        ImageIcon buscarDef = new ImageIcon(buscar.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        ImageIcon volver = new ImageIcon("iconos/logout.png");
        ImageIcon volverDef = new ImageIcon(volver.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));

        ImageIcon icon = new ImageIcon("iconos/reparacion.png");
        ImageIcon iconDef = new ImageIcon(icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));

        btnVolver.setIcon(volverDef);

        icono.setIcon(iconDef);

        File fichero = new File(".\\src\\help\\help_set.hs");
        URL hsURL = fichero.toURI().toURL();

        helpset = new HelpSet(getClass().getClassLoader(), hsURL);
        hb = helpset.createHelpBroker();

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
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        icono = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        btnNext = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbMarca = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbModelo = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        btnVolver = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mInicio = new javax.swing.JMenu();
        menuSalir = new javax.swing.JMenuItem();
        mAyuda = new javax.swing.JMenu();
        menuAcerca = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Marca", "Modelo", "Año Salida ", "Año Extincion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(210, 220, 255));

        icono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconoMouseClicked(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(210, 220, 255));

        jLabel1.setText("Modelo Seleccionado:");

        lblModelo.setBackground(new java.awt.Color(255, 255, 255));
        lblModelo.setForeground(new java.awt.Color(255, 0, 51));
        lblModelo.setText("Selecciona un vehiculo");

        btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNextMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblModelo, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(102, 102, 102)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(7, 7, 7)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(31, 31, 31)))
        );

        jPanel6.setBackground(new java.awt.Color(210, 220, 255));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Marca");

        cbMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMarcaActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Modelo");

        cbModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbModelo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbMarca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbModelo)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE)
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(icono, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                        .addGap(58, 58, 58))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(icono, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jToolBar1.setRollover(true);

        btnVolver.setFocusable(false);
        btnVolver.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVolver.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jToolBar1.add(btnVolver);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mInicio.setText("Inicio");

        menuSalir.setText("Salir");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        mInicio.add(menuSalir);

        jMenuBar1.add(mInicio);

        mAyuda.setText("Ayuda");

        menuAcerca.setText("Acerca de");
        menuAcerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAcercaActionPerformed(evt);
            }
        });
        mAyuda.add(menuAcerca);

        menuAyuda.setText("Ayuda");
        menuAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAyudaActionPerformed(evt);
            }
        });
        mAyuda.add(menuAyuda);

        jMenuBar1.add(mAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Registro r = new Registro();
        r.setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseClicked
        // TODO add your handling code here:
        try {
            pu = new PiezaUsuario();
            pu.setVisible(true);
            this.setVisible(false);

        } catch (SQLException ex) {
            Logger.getLogger(PrincipalUsuario.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (MalformedURLException ex) {
            Logger.getLogger(PrincipalUsuario.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (HelpSetException ex) {
            Logger.getLogger(PrincipalUsuario.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNextMouseClicked

    private void iconoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconoMouseClicked
        // TODO add your handling codasd
    }//GEN-LAST:event_iconoMouseClicked

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        // TODO add your handling code here:
        jPanel4.setVisible(true);
        String car;
        int row = tabla.getSelectedRow();
        Object nombreMa = modelo.getValueAt(row, 0);
        Object nombreMo = modelo.getValueAt(row, 1);
        Object anoS = modelo.getValueAt(row, 2);
        Object anoE = modelo.getValueAt(row, 3);
        car = nombreMa.toString() + " " + nombreMo.toString() + " (" + anoS.toString() + "-" + anoE.toString() + ")";
        setModelo(nombreMo.toString());
        setCoche(car);
        lblModelo.setText(car);
        lblModelo.setForeground(Color.black);
        ImageIcon next = new ImageIcon("iconos/next.png");
        ImageIcon nextDef = new ImageIcon(next.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        btnNext.setIcon(nextDef);
    }//GEN-LAST:event_tablaMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        try {
            System.out.println(modelo.getRowCount());

            for (int i = 0; i < modelo.getRowCount(); i++) {
                modelo.removeRow(i);
                i -= 1;

            }

            Statement s = conexion.createStatement();
            System.out.println(cbModelo.getSelectedItem().toString());
            ResultSet rs = s.executeQuery("SELECT  ma.Nombre ,mo.Nombre , mo.AnoSalida , mo.AnoExtincion "
                    + "                    FROM modelo mo , marca ma "
                    + "                    WHERE mo.A_Marca=ma.P_Marca "
                    + "                    AND mo.Nombre LIKE '%" + cbModelo.getSelectedItem().toString() + "%'");

            while (rs.next()) {
                Object[] fila = new Object[4];
                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalUsuario.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cbMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMarcaActionPerformed
        try {
            // TODO add your handling code here:
            rellenoModelos();

        } catch (SQLException ex) {
            Logger.getLogger(PrincipalUsuario.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbMarcaActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_menuSalirActionPerformed

    private void menuAcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAcercaActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Creado por Adrian Iriondo Gonzalez, como proyecto del FP Desarrollo de aplicaciones Multiplataforma");
    }//GEN-LAST:event_menuAcercaActionPerformed

    private void menuAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAyudaActionPerformed
        // TODO add your handling code here:

        hb.enableHelpOnButton(menuAyuda, "principal", helpset);


    }//GEN-LAST:event_menuAyudaActionPerformed

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
            java.util.logging.Logger.getLogger(PrincipalUsuario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalUsuario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalUsuario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalUsuario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PrincipalUsuario().setVisible(true);

                } catch (SQLException ex) {
                    Logger.getLogger(PrincipalUsuario.class
                            .getName()).log(Level.SEVERE, null, ex);

                } catch (MalformedURLException ex) {
                    Logger.getLogger(PrincipalUsuario.class
                            .getName()).log(Level.SEVERE, null, ex);

                } catch (HelpSetException ex) {
                    Logger.getLogger(PrincipalUsuario.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public final void rellenoTabla() throws SQLException {
        Statement s = conexion.createStatement();
        ResultSet rs = s.executeQuery("SELECT  ma.Nombre ,mo.Nombre, mo.AnoSalida, mo.AnoExtincion "
                + "                    FROM modelo mo , marca ma "
                + "                    WHERE mo.A_Marca=ma.P_Marca");

        while (rs.next()) {
            Object[] fila = new Object[4];
            for (int i = 0; i < 4; i++) {
                fila[i] = rs.getObject(i + 1);
            }
            modelo.addRow(fila);
        }
    }

    public final void rellenoMarcas() throws SQLException {
        int i = 0;
        int num = 0;
        Statement s = conexion.createStatement();
        ResultSet rs = s.executeQuery("SELECT  ma.Nombre "
                + "                    FROM  marca ma ");
        while (rs.next()) {
            num++;
        }
        ResultSet query = s.executeQuery("SELECT  ma.Nombre "
                + "                    FROM  marca ma ");
        String[] marcas = new String[num];

        while (query.next()) {
            //System.out.println(" " + query.getString(1));
            marcas[i] = query.getString(1);
            i++;

        }
        for (int j = 0; j < marcas.length; j++) {
            //System.out.println(marcas[j]);
            cbMarca.addItem(marcas[j]);
        }
    }

    public static void setModelo(String mod) {
        PrincipalUsuario.mod = mod;
    }

    public static String getModelo() {
        return PrincipalUsuario.mod;
    }

    public static void setCoche(String car) {
        PrincipalUsuario.coche = car;
    }

    public static String getCoche() {
        return PrincipalUsuario.coche;
    }

    public final void rellenoModelos() throws SQLException {
        cbModelo.removeAllItems();
        int i = 0;
        int num = 0;
        Statement s = conexion.createStatement();
        ResultSet rs = s.executeQuery("SELECT  m.Nombre\n"
                + "FROM modelo m , marca ma\n"
                + "WHERE m.A_Marca = ma.P_Marca\n"
                + "AND ma.Nombre = '" + cbMarca.getSelectedItem().toString() + "'");
        while (rs.next()) {
            num++;
        }
        ResultSet query = s.executeQuery("SELECT  m.Nombre , m.AnoSalida , m.AnoExtincion\n"
                + "FROM modelo m , marca ma\n"
                + "WHERE m.A_Marca = ma.P_Marca\n"
                + "AND ma.Nombre = '" + cbMarca.getSelectedItem().toString() + "'");
        String[] modelos = new String[num];

        while (query.next()) {
            //System.out.println(" " + query.getString(1));
            modelos[i] = query.getString(1);
            i++;

        }
        for (int j = 0; j < modelos.length; j++) {
            //System.out.println(marcas[j]);
            cbModelo.addItem(modelos[j]);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel btnNext;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cbMarca;
    private javax.swing.JComboBox<String> cbModelo;
    private javax.swing.JLabel icono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JMenu mAyuda;
    private javax.swing.JMenu mInicio;
    private javax.swing.JMenuItem menuAcerca;
    private javax.swing.JMenuItem menuAyuda;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables

}
