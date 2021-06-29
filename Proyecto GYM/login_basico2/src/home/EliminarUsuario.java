package home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author David
 */
public class EliminarUsuario extends javax.swing.JFrame {
    
   Connection con = null;
   Statement stmt = null;
   String titulos[] = {"id","Cedula","Nombres","Apellidos","Celular","Tipo Plan","Precio","Fecha Fin Plan"};
   String fila[] = new String [8];
   DefaultTableModel modelo;
   String PS;
      
    public EliminarUsuario() {
        
       initComponents();
        this.setTitle("ELIMINAR");
        //this.setLocation(130,80);
        this.setResizable(false);
        ImageIcon icono = new ImageIcon("C:\\Users\\2020\\Documents\\Proyectos NetBeans\\login_basico\\src\\imagenes\\cesmag_color.png");
        this.setIconImage(icono.getImage());
        
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
               
               modelo = new DefaultTableModel(null,titulos);
            
               while(rs.next()) {
                   
                   fila[0] = rs.getString("id");
                   fila[1] = rs.getString("cedula");
                   fila[2] = rs.getString("nombre");
                   fila[3] = rs.getString("apellido");
                   fila[4] = rs.getString("celular");
                   fila[5] = rs.getString("tipousuario");
                   fila[6] = rs.getString("precio");
                   fila[7] = rs.getString("fecha");
                   
                   modelo.addRow(fila);     
               }
               
               tabla_usuarios.setModel(modelo);
               
                TableColumn ci = tabla_usuarios.getColumn("id");
                ci.setMaxWidth(25);
                TableColumn cn = tabla_usuarios.getColumn("Cedula");
                cn.setMaxWidth(170);
                TableColumn cd = tabla_usuarios.getColumn("Nombres");
                cd.setMaxWidth(200);
                TableColumn ct = tabla_usuarios.getColumn("Apellidos");
                ct.setMaxWidth(200);
                TableColumn cp = tabla_usuarios.getColumn("Celular");
                cp.setMaxWidth(110);
                TableColumn ctipo = tabla_usuarios.getColumn("Tipo Plan");
                ctipo.setMaxWidth(95);
                TableColumn cprecio = tabla_usuarios.getColumn("Precio");
                cprecio.setMaxWidth(80);
                TableColumn cFecha = tabla_usuarios.getColumn("Fecha Fin Plan");
                cFecha.setMaxWidth(290);
               
        }
        catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,"Error al extraer los datos de la tabla");
        }
    }
           
    public void deleteDatos(String id) {
        
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
               
               modelo = new DefaultTableModel(null,titulos);
            
               while(rs.next()) {
                   
                   fila[0] = rs.getString("id");
                   fila[1] = rs.getString("cedula");
                   fila[2] = rs.getString("nombre");
                   fila[3] = rs.getString("apellido");
                   fila[4] = rs.getString("celular");
                   fila[5] = rs.getString("tipousuario");
                   fila[6] = rs.getString("precio");
                   fila[7] = rs.getString("fecha");
                   
                   modelo.addRow(fila);     
               }
               
               tabla_usuarios.setModel(modelo);
               
                TableColumn ci = tabla_usuarios.getColumn("id");
                ci.setMaxWidth(25);
                TableColumn cn = tabla_usuarios.getColumn("Cedula");
                cn.setMaxWidth(170);
                TableColumn cd = tabla_usuarios.getColumn("Nombres");
                cd.setMaxWidth(200);
                TableColumn ct = tabla_usuarios.getColumn("Apellidos");
                ct.setMaxWidth(200);
                TableColumn cp = tabla_usuarios.getColumn("Celular");
                cp.setMaxWidth(110);
                TableColumn ctipo = tabla_usuarios.getColumn("Tipo Plan");
                ctipo.setMaxWidth(95);
                TableColumn cprecio = tabla_usuarios.getColumn("Precio");
                cprecio.setMaxWidth(80);
                TableColumn cFecha = tabla_usuarios.getColumn("Fecha Fin Plan");
                cFecha.setMaxWidth(290);
               
        }
        catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,"Error al extraer los datos de la tabla");
        }
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_usuarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btn_volver = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();

        jScrollPane2.setViewportView(jEditorPane1);

        jMenuItem1.setText("eliminar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tabla_usuarios.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        tabla_usuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_usuarios.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tabla_usuarios);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel1.setText("TABLA DE CLIENTES");

        btn_volver.setBackground(new java.awt.Color(255, 255, 255));
        btn_volver.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        btn_volver.setForeground(new java.awt.Color(51, 102, 255));
        btn_volver.setText("VOLVER");
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });

        btn_eliminar.setBackground(new java.awt.Color(255, 255, 255));
        btn_eliminar.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(51, 102, 255));
        btn_eliminar.setText("ELIMINAR");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1009, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_eliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_volver)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_volver)
                    .addComponent(btn_eliminar))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        panel_control bc = new panel_control();
                 bc.setVisible(true);
                 this.dispose();                            
    }//GEN-LAST:event_btn_volverActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        int fila = tabla_usuarios.getSelectedRow();
        String pop="";
        pop = tabla_usuarios.getValueAt(fila, 0).toString();
        
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM clientes WHERE id='"+pop+"'");
            pst.executeUpdate();
            deleteDatos("");
            JOptionPane.showMessageDialog(null, "Registro Eliminado");            
        } catch (Exception e) {
            
        }        
        
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int fila = tabla_usuarios.getSelectedRow();
        String pop="";
        pop = tabla_usuarios.getValueAt(fila, 0).toString();
        
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM usuarios WHERE id='"+pop+"'");
            pst.executeUpdate();
            deleteDatos("");
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    
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
            java.util.logging.Logger.getLogger(EliminarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EliminarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla_usuarios;
    // End of variables declaration//GEN-END:variables
}
