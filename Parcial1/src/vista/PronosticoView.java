package vista;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 * Parcial N. 1 FPOE (A). Archivo: PronosticoView.java, Autores (Grupo 01 POE): 
 * Brayan Andrés Sánchez Lozano <brayan.andres.sanchez@correounivalle.edu.co>
 * Jose Luis Hincapie Bucheli <jose.bucheli@correounivalle.edu.co>
 * Fecha creación: 04-08-2022, Fecha última modificación: 04-08-2022 
 *  Docente: Luis Romo <luis.romo@correounivalle.edu.co>
 */

public class PronosticoView extends javax.swing.JFrame {
    DefaultTableModel modelo;
    /**
     * Creates new form VentanaPrincipal
     */
    public PronosticoView() {
        initComponents();
        initBtnCommands();
        this.getContentPane().setBackground(Color.white);
    }

    public void addBtnNuevo(ActionListener listenControles) {
        btnNuevoP.addActionListener(listenControles);
    }

    public void addBtnBorrarA(ActionListener listenControles) {
        btnBorrarA.addActionListener(listenControles);
    }

    public void addBtnModificar(ActionListener listenControles) {
        btnModificar.addActionListener(listenControles);
    }

    public void addBtnAgregarA(ActionListener listenControles) {
        btnAgregarA.addActionListener(listenControles);
    }

    private void initBtnCommands() {
        btnNuevoP.setActionCommand("btnNuevo");
        btnModificar.setActionCommand("btnModificar");
        btnAgregarA.setActionCommand("btnAgregar");
        btnBorrarA.setActionCommand("btnBorrar");
    }

    public String getAños(){
        return txtCantidad.getText();
    }

    public String getVentas(){
        return txtVentas.getText();
    }

    public void setFila(String[] fila){
        modelo = (DefaultTableModel) tblVentas.getModel();
        modelo.addRow(fila);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlVenta = new javax.swing.JPanel();
        lblVentas = new javax.swing.JLabel();
        txtVentas = new javax.swing.JTextField();
        pnlYears = new javax.swing.JPanel();
        lblCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        Controles = new javax.swing.JPanel();
        btnAgregarA = new javax.swing.JButton();
        btnBorrarA = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnNuevoP = new javax.swing.JButton();
        pnlHistoricoVentas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        pnlPronosticoV = new javax.swing.JPanel();
        lblCrecimiento = new javax.swing.JLabel();
        txtCrecimiento = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPronostico = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pronostico de Ventas");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        pnlVenta.setBackground(new java.awt.Color(255, 255, 255));
        pnlVenta.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Venta"));
        pnlVenta.setName("pnlVentas"); // NOI18N
        pnlVenta.setLayout(new java.awt.GridLayout(1, 2));

        lblVentas.setText("Cantidad de Ventas:");
        pnlVenta.add(lblVentas);

        txtVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVentasActionPerformed(evt);
            }
        });
        pnlVenta.add(txtVentas);

        pnlYears.setBackground(java.awt.Color.white);
        pnlYears.setBorder(javax.swing.BorderFactory.createTitledBorder("Años a Pronosticar"));
        pnlYears.setName("pnlVentas"); // NOI18N
        pnlYears.setLayout(new java.awt.GridLayout(1, 2));

        lblCantidad.setText("Cantidad:");
        pnlYears.add(lblCantidad);

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        pnlYears.add(txtCantidad);

        Controles.setBackground(java.awt.Color.white);
        Controles.setBorder(javax.swing.BorderFactory.createTitledBorder("Controles"));
        Controles.setLayout(new java.awt.GridLayout(2, 2, 10, 10));

        btnAgregarA.setText("Agregar Año");
        btnAgregarA.setActionCommand("btnNuevo");
        btnAgregarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAActionPerformed(evt);
            }
        });
        Controles.add(btnAgregarA);

        btnBorrarA.setText("Borrar Año");
        btnBorrarA.setActionCommand("btnBorrar");
        btnBorrarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarAActionPerformed(evt);
            }
        });
        Controles.add(btnBorrarA);

        btnModificar.setText("Modificar Año");
        btnModificar.setActionCommand("btnModificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        Controles.add(btnModificar);

        btnNuevoP.setText("Nuevo Pronostico");
        btnNuevoP.setActionCommand("btnNuevo");
        btnNuevoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPActionPerformed(evt);
            }
        });
        Controles.add(btnNuevoP);

        pnlHistoricoVentas.setBackground(java.awt.Color.white);
        pnlHistoricoVentas.setBorder(javax.swing.BorderFactory.createTitledBorder("Historico de Ventas"));

        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Año", "Cantidad de Ventas", "X^2", "Y^2", "X*Y"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblVentas);

        javax.swing.GroupLayout pnlHistoricoVentasLayout = new javax.swing.GroupLayout(pnlHistoricoVentas);
        pnlHistoricoVentas.setLayout(pnlHistoricoVentasLayout);
        pnlHistoricoVentasLayout.setHorizontalGroup(
            pnlHistoricoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHistoricoVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlHistoricoVentasLayout.setVerticalGroup(
            pnlHistoricoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHistoricoVentasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        pnlPronosticoV.setBackground(java.awt.Color.white);
        pnlPronosticoV.setBorder(javax.swing.BorderFactory.createTitledBorder("Pronostico de Ventas"));

        lblCrecimiento.setText("Crecimiento Promedio:");

        txtCrecimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCrecimientoActionPerformed(evt);
            }
        });

        tblPronostico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Año", "Pronostico Venta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblPronostico);

        javax.swing.GroupLayout pnlPronosticoVLayout = new javax.swing.GroupLayout(pnlPronosticoV);
        pnlPronosticoV.setLayout(pnlPronosticoVLayout);
        pnlPronosticoVLayout.setHorizontalGroup(
            pnlPronosticoVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPronosticoVLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblCrecimiento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCrecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlPronosticoVLayout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        pnlPronosticoVLayout.setVerticalGroup(
            pnlPronosticoVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPronosticoVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPronosticoVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCrecimiento)
                    .addComponent(txtCrecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlYears, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(Controles, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(pnlHistoricoVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlPronosticoV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlYears, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Controles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlHistoricoVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlPronosticoV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVentasActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void btnBorrarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBorrarAActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnNuevoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoPActionPerformed

    private void txtCrecimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCrecimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCrecimientoActionPerformed

    private void btnAgregarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarAActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PronosticoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PronosticoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Controles;
    private javax.swing.JButton btnAgregarA;
    private javax.swing.JButton btnBorrarA;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevoP;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCrecimiento;
    private javax.swing.JLabel lblVentas;
    private javax.swing.JPanel pnlHistoricoVentas;
    private javax.swing.JPanel pnlPronosticoV;
    private javax.swing.JPanel pnlVenta;
    private javax.swing.JPanel pnlYears;
    private javax.swing.JTable tblPronostico;
    private javax.swing.JTable tblVentas;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCrecimiento;
    private javax.swing.JTextField txtVentas;
    // End of variables declaration//GEN-END:variables
}
