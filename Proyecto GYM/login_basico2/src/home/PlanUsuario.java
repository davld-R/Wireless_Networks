package home;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
;

/**
 *
 * @author David
 */
public class PlanUsuario extends javax.swing.JFrame {
    
   Connection con = null;
   Statement stmt = null;
   String var,var2;
   String titulo[] = {"id","Nombres","Apellidos","Fecha Fin Plan","Tipo Plan","Precio"};//2//
   String fila2[] = new String[6];//2
   DefaultTableModel modelo2;
   
   
    public int suma(){
        int contar = tabla_usuarios2.getRowCount();
        int suma = 0;
        for (int i = 0; i <contar; i++){
            suma = suma+Integer.parseInt(tabla_usuarios2.getValueAt(i, 5).toString());
        }
        return suma;
    }
   
    public PlanUsuario() {
        initComponents();
        this.setTitle("PAGOS");
        this.setLocation(200,200);
        this.setResizable(false);
        ImageIcon icono = new ImageIcon("C:\\Users\\2020\\Documents\\Proyectos NetBeans\\login_basico\\src\\imagenes\\cesmag_color.png");
        this.setIconImage(icono.getImage());
        
                       
        consulta();
        txt_suma.setText(Integer.toString(suma()));
    }
    
     public void consulta(){
        try {
            
            String url = "jdbc:mysql://localhost:3306/gimnasio";
            String usuario = "root";
            String contraseña = "DsJnTv20DS";  
            
               Class.forName("com.mysql.jdbc.Driver").newInstance();
               con = DriverManager.getConnection(url,usuario,contraseña);
               if (con!= null)
                   System.out.println("Se ha establecido una conexion a la base de datos"+"\n"+url);
               
               stmt = con.createStatement();
               ResultSet rs = stmt.executeQuery("select* from clientes");
               
             
                modelo2 = new DefaultTableModel(null,titulo);
            
               while(rs.next()) {
                   
                              
                    fila2[0] = rs.getString("id");
                    fila2[1] = rs.getString("nombre");
                    fila2[2] = rs.getString("apellido");
                    fila2[3] = rs.getString("fecha");
                    fila2[4] = rs.getString("tipousuario");
                    fila2[5] = rs.getString("precio");
                       
                    modelo2.addRow(fila2);
               }
               
                      tabla_usuarios2.setModel(modelo2);
  
                     TableColumn cii = tabla_usuarios2.getColumn("id");
                     cii.setMaxWidth(25);
                     TableColumn cdd = tabla_usuarios2.getColumn("Nombres");
                     cdd.setMaxWidth(200);
                     TableColumn ctt = tabla_usuarios2.getColumn("Apellidos");
                     ctt.setMaxWidth(200);           
                     TableColumn cFechac = tabla_usuarios2.getColumn("Fecha Fin Plan");
                     cFechac.setMaxWidth(290);  
                     TableColumn ctipos = tabla_usuarios2.getColumn("Tipo Plan");
                     ctipos.setMaxWidth(95);               
                     TableColumn cprecio = tabla_usuarios2.getColumn("Precio");
                     cprecio.setMaxWidth(80);                                        
              
        }
        catch (Exception e) {      
        }
    }
     
     
       
     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btn_volver = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_usuarios2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_suma = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_volver.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_volver.setForeground(new java.awt.Color(51, 102, 255));
        btn_volver.setText("VOLVER");
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });
        jPanel1.add(btn_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(579, 330, 99, 33));

        tabla_usuarios2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabla_usuarios2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 43, 523, 180));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("TOTAL");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 256, -1, -1));
        jPanel1.add(txt_suma, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 261, 84, -1));

        btn_guardar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_guardar.setForeground(new java.awt.Color(51, 102, 255));
        btn_guardar.setText("PAGAR");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(579, 271, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        panel_control bc = new panel_control();
                 bc.setVisible(true);
                 this.dispose();  
    }//GEN-LAST:event_btn_volverActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        JOptionPane.showMessageDialog(null, "El cliente a pagado");        
        
        
    }//GEN-LAST:event_btn_guardarActionPerformed

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
            java.util.logging.Logger.getLogger(PlanUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlanUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlanUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlanUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlanUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla_usuarios2;
    private javax.swing.JTextField txt_suma;
    // End of variables declaration//GEN-END:variables
}
