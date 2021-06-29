package home;

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

/**
 *
 * @author David
 */
public class ModificarUsuario extends javax.swing.JFrame {
    
   Connection con = null;
   Statement stmt = null;
    String titulos[] = {"id","Cedula","Nombres","Apellidos","Celular","Tipo Plan","Precio","Fecha Fin Plan"};
   String fila[] = new String [8];
   DefaultTableModel modelo;       
   String var,var2;
    
    public ModificarUsuario() {
        initComponents();
        this.setTitle("MODIFICAR");
        this.setLocation(200,150);
        this.setResizable(false);
        ImageIcon icono = new ImageIcon("C:\\Users\\2020\\Documents\\Proyectos NetBeans\\login_basico\\src\\imagenes\\cesmag_color.png");
        this.setIconImage(icono.getImage());
    }

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_apellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_celular = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_tipoplan = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        btn_cambiar = new javax.swing.JButton();
        btn_volver = new javax.swing.JButton();
        consultarUsuario = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JTextField();
        cmd_precio = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 51, 0));
        jLabel2.setText("CEDULA:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 132, -1, -1));

        txt_cedula.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jPanel1.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 133, 100, -1));

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 51, 0));
        jLabel1.setText("NOMBRES:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 132, -1, -1));

        txt_nombre.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txt_nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 220, 30));

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 51, 0));
        jLabel3.setText("APELLIDOS:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 208, -1, -1));

        txt_apellido.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jPanel1.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 220, -1));

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 51, 0));
        jLabel4.setText("PRECIO:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, -1, -1));

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 51, 0));
        jLabel5.setText("CELULAR:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 208, -1, -1));

        txt_celular.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jPanel1.add(txt_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 209, 127, -1));

        jLabel6.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 51, 0));
        jLabel6.setText("TIPO DE PLAN:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, 20));

        txt_tipoplan.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txt_tipoplan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diario", "Quincenal ", "Mensual " }));
        jPanel1.add(txt_tipoplan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, -1, -1));

        jLabel7.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 51, 0));
        jLabel7.setText("ID:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 60, -1, -1));

        txt_id.setBackground(new java.awt.Color(153, 255, 255));
        txt_id.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jPanel1.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 58, 33, 29));

        btn_cambiar.setBackground(new java.awt.Color(255, 255, 255));
        btn_cambiar.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        btn_cambiar.setText("MODIFICAR");
        btn_cambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cambiarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cambiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, -1, -1));

        btn_volver.setBackground(new java.awt.Color(255, 255, 255));
        btn_volver.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        btn_volver.setText("VOLVER");
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });
        jPanel1.add(btn_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 400, -1, -1));

        consultarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        consultarUsuario.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        consultarUsuario.setText("BUSCAR");
        consultarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(consultarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, -1, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 51, 0));
        jLabel8.setText("MODIFICAR CLIENTES");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 25, -1, -1));

        jLabel9.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 51, 0));
        jLabel9.setText("FECHA FIN PLAN");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        txt_fecha.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jPanel1.add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 360, 142, -1));

        cmd_precio.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        cmd_precio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3000", "25000", "45000" }));
        jPanel1.add(cmd_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, -1, -1));

        jLabel10.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondomodi.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
        panel_control cc = new panel_control();
                 cc.setVisible(true);
                 this.dispose();
    }//GEN-LAST:event_btn_volverActionPerformed
    public void consulta(){
        String cap="";
        ResultSet rs = null;
        var2 = var;
        String sql2="Select id, cedula, nombre, apellido, celular, tipousuario, precio, fecha fecha FROM clientes where nombre = '"+var2+"'";
            
   try { 
       
                  String url = "jdbc:mysql://localhost:3306/gimnasio"; 
                  String usuario = "root"; 
                  String contraseña = "DsJnTv20DS";
                  
     Class.forName("com.mysql.jdbc.Driver").newInstance(); 
     
     
     con = DriverManager.getConnection(url,usuario,contraseña); 

     if ( con != null ) 
	   System.out.println("Se ha establecido una conexión a la base de datos " + 
	                                       "\n " + url ); 
	  
	stmt = con.createStatement(); 
	rs = stmt.executeQuery(sql2); 
        
	int i=1; 
	   while ( rs.next() ) { 
               
	           String id = rs.getString("id"); 
	           String inom = rs.getString("cedula"); 
	           String idom = rs.getString("nombre"); 
                                String itel = rs.getString("apellido"); 
                                String ipass = rs.getString("celular");
                                String itipo = rs.getString("tipousuario");
                                String iprec = rs.getString("Precio");
                                String ifecha = rs.getString("fecha");
	           System.out.println("Sitio Web "+ (i++) + ":\n" 
	                     
                                + id + "\n"
                                + inom + "\n" 
                                + idom + "\n" 
                                + itel + "\n"
	           + ipass + "\n"
                                + itipo + "\n"
                                + iprec + "\n"
                                + ifecha + "\n\n" ); 
                
                                txt_id.setText(id);
                                txt_cedula.setText(inom);
                                txt_nombre.setText(idom);
                                txt_apellido.setText(itel);
                                txt_celular.setText(ipass);
                                txt_tipoplan.setSelectedItem(itipo);
                                cmd_precio.setSelectedItem(iprec);
                                txt_fecha.setText(ifecha);
                                } 
                     } 
                  catch( SQLException ex ) { 
                      ex.printStackTrace(); 
	                  } catch (InstantiationException ex) { 
            Logger.getLogger(ModificarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ModificarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModificarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } 
	  
	              finally { 
	                  if ( rs != null ) { 
	                      try    { 
	                          rs.close(); 
	                      } catch( SQLException ex ) { 
	                          System.out.println( ex.getMessage()); 
	                          ex.printStackTrace(); 
	                      } 
	                  } 
	                  if ( stmt != null ) { 
	                      try    { 
	                          stmt.close(); 
	                      } catch( SQLException ex ) { 
	                          System.out.println( ex.getMessage()); 
	                          ex.printStackTrace(); 
	                      } 
	                  } 
	                  if ( con != null ) { 
	                      try    { 
	                          con.close(); 
	                      } catch( SQLException ex ) { 
	                          System.out.println( ex.getMessage()); 
	                          ex.printStackTrace(); 
         } 
       }
     }
    }
    
    public void actualizar(){
        String cadena1,cadena2,cadena3,cadena4,cadena5,cadena6,cadena7,cadena8;
        
        cadena1 = txt_id.getText();
        cadena2 = txt_cedula.getText();
        cadena3 = txt_nombre.getText();
        cadena4 = txt_apellido.getText();
        cadena5 = txt_celular.getText();
        cadena6 = txt_tipoplan.getSelectedItem().toString();
        cadena7 = cmd_precio.getSelectedItem().toString();
        cadena8 = txt_fecha.getText();
        
        if (txt_nombre.getText().equals("")) {
         javax.swing.JOptionPane.showMessageDialog(this,"1-. Consulte el nombre del cliente\n 2-. Actualice el dato deseado en el campo correspondiente","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);          
        } else {
            try { 
                  String url = "jdbc:mysql://localhost:3306/gimnasio"; 
                  String usuario = "root"; 
                  String contraseña = "DsJnTv20DS"; 
                  
                  Class.forName("com.mysql.jdbc.Driver").newInstance(); 
                  con = DriverManager.getConnection(url,usuario,contraseña); 
                  if ( con != null ) 
                    System.out.println("Se ha establecido una conexión a la base de datos " +  
                                       "\n " + url ); 
  
                  stmt = con.createStatement(); 
                  stmt.executeUpdate("update ignore clientes set id= '"+cadena1+"' , cedula = '"+cadena2+"',nombre = '"+cadena3+"',apellido = '"+cadena4+"', celular = '"+cadena5+"', tipousuario = '"+cadena6+"', precio = '"+cadena7+"', fecha = '"+cadena8+"' where id = '"+txt_id.getText()+"' || cedula = '"+txt_cedula.getText()+"' || nombre = '"+txt_nombre.getText()+"' || apellido = '"+txt_apellido.getText()+"' || celular = '"+txt_celular.getText()+"' || tipousuario = '"+txt_tipoplan.getSelectedItem()+"' || precio = '"+cmd_precio.getSelectedItem()+"' || fecha = '"+txt_fecha.getText()+"'"); 
                  System.out.println("Los valores han sido Actualizados"); 
                  } 
           catch( SQLException e ) { 
           e.printStackTrace(); 
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(ModificarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ModificarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ModificarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } 
  
              finally { 
                  if ( con != null ) { 
                      try    { 
                          con.close(); 
                          stmt.close(); 
                      } catch( Exception e ) { 
                          System.out.println( e.getMessage()); 
                      } 
                  } 
     }
     javax.swing.JOptionPane.showMessageDialog(this,"Actualizado correctamente!","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
     } 
        this.txt_id.setText("");
        this.txt_cedula.setText("");
        this.txt_nombre.setText("");
        this.txt_apellido.setText("");
        this.txt_celular.setText("");
        this.txt_fecha.setText("");
    }
    private void consultarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarUsuarioActionPerformed
        String cap="";
        String cap2="";
        ResultSet rs = null; 
        
         var = javax.swing.JOptionPane.showInputDialog(this,"Nombre del usuario","Consulta usuario",javax.swing.JOptionPane.QUESTION_MESSAGE);
        String sql="SELECT* FROM  usuarios WHERE nombre = '"+var+"'";
        
        if(var == null)  
        javax.swing.JOptionPane.showMessageDialog(this,"La accion fue cancelada","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
      else {   
        if (var.equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this,"Favor de ingresar el nombre de usuario\nque desea consultar","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
         else {
        try {
            
            String url = "jdbc:mysql://localhost:3306/gimnasio";
            String usuario = "root";
            String contraseña = "DsJnTv20DS";
            
             Class.forName("com.mysql.jdbc.Driver").newInstance(); 
             con = DriverManager.getConnection(url,usuario,contraseña); 
             if ( con != null ) 
                    System.out.println("Se ha establecido una conexión a la base de datos " +  
                                       "\n " + url ); 
  
                  stmt = con.createStatement(); 
                  rs = stmt.executeQuery(sql);
                        
         while(rs.next()) {
              
               cap = rs.getString("tipousuario"); 
                  
          if (cap.equals("Diario") || cap.equals("Quincenal") || cap.equals("Mensual")) {
               
              consulta();           
          }
        }   
         
         while(rs.next()){
             
             cap2 = rs.getString("precio");
             
             if (cap2.equals("3000") || cap2.equals("25000") || cap2.equals("45000")) {
               
              consulta();           
             
          }
         }
         
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
          // Logger.getLogger(portada.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        finally {
            if (con != null) {
                try {
                    con.close();
                    stmt.close();
                } catch ( Exception e ) { 
                         System.out.println( e.getMessage());
                }
              }
            }
        
      // if (!cap.equals("Diario") && !cap.equals("Quincenal") && !cap.equals("Mensual")) {
      //        javax.swing.JOptionPane.showMessageDialog(this,"El usuario  fue encontrado\n","CONSULTA", javax.swing.JOptionPane.YES_OPTION);
              consulta();
      //    }
        }
      }    

    }//GEN-LAST:event_consultarUsuarioActionPerformed

    private void btn_cambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cambiarActionPerformed
        
        actualizar();
       
    }//GEN-LAST:event_btn_cambiarActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cambiar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JComboBox<String> cmd_precio;
    private javax.swing.JButton consultarUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_celular;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JComboBox<String> txt_tipoplan;
    // End of variables declaration//GEN-END:variables

   

    
}
