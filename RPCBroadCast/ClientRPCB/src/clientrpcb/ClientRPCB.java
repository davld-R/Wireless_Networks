package clientrpcb;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author David Rojas - David Muños - Sebastian Salazar
 */
public class ClientRPCB extends javax.swing.JFrame implements Runnable{

    String usuario;
    Socket cliente;
    Thread hilo;
        
    public ClientRPCB() {
        initComponents();        
        usuario=JOptionPane.showInputDialog("Escriba nombre de usuario");
        lbl_Usuario.setText(usuario);
        try {
            cliente=new Socket("localhost", 5000);
            DataOutputStream out=new DataOutputStream(cliente.getOutputStream());
            out.writeUTF(usuario);//Enviar al servidor el nombreB
            out.writeUTF("Conex");
            out.writeUTF(usuario+" Conectado");
            hilo=new Thread(this);
            hilo.start();
            
            cerrar();
            
        } catch (IOException ex) {
            Logger.getLogger(ClientRPCB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cerrar(){
        try {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e){
                    confirmarSalida();
                    System.exit(0);
                }
        });
          this.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void confirmarSalida(){
        
        try {
            cliente=new Socket("localhost", 5000);
            DataOutputStream out=new DataOutputStream(cliente.getOutputStream());
            out.writeUTF(usuario);
            out.writeUTF("DConex");
            out.writeUTF(usuario+" Desconectado");           
                       
            hilo=new Thread(this);
            hilo.start();
            
        } catch (IOException ex) {
            Logger.getLogger(ClientRPCB.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        txt_Mensaje = new javax.swing.JTextField();
        btn_Enviar = new javax.swing.JButton();
        txt_usuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_EnviarUsuario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_Chat = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        lbl_Usuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        btn_Enviar.setBackground(new java.awt.Color(204, 255, 255));
        btn_Enviar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btn_Enviar.setText("Enviar a todos");
        btn_Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EnviarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("Usuario:");

        btn_EnviarUsuario.setBackground(new java.awt.Color(204, 255, 255));
        btn_EnviarUsuario.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btn_EnviarUsuario.setText("Send");
        btn_EnviarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EnviarUsuarioActionPerformed(evt);
            }
        });

        txt_Chat.setBackground(new java.awt.Color(204, 255, 255));
        txt_Chat.setColumns(20);
        txt_Chat.setRows(5);
        jScrollPane1.setViewportView(txt_Chat);

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        lbl_Usuario.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        lbl_Usuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Usuario.setText("Usuario");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbl_Usuario)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_EnviarUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_Enviar, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_Mensaje, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(82, 82, 82))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_Mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Enviar)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(btn_EnviarUsuario))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    private void btn_EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EnviarActionPerformed
        try {
                        
            DataOutputStream out=new DataOutputStream(cliente.getOutputStream());
            String mensaje = txt_Mensaje.getText();
            out.writeUTF(usuario);
            out.writeUTF("All");
            out.writeUTF(mensaje);            
                     
        } catch (IOException ex) {
            Logger.getLogger(ClientRPCB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_EnviarActionPerformed

    private void btn_EnviarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EnviarUsuarioActionPerformed
            
            String mensaje = txt_Mensaje.getText();
            try {
                DataOutputStream out=new DataOutputStream(cliente.getOutputStream());                
                out.writeUTF(usuario);
                out.writeUTF("User");
                out.writeUTF(txt_usuario.getText()+":"+txt_Mensaje.getText());
            } catch (IOException ex) {
                Logger.getLogger(ClientRPCB.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btn_EnviarUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(ClientRPCB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientRPCB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientRPCB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientRPCB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientRPCB().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Enviar;
    private javax.swing.JButton btn_EnviarUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Usuario;
    private javax.swing.JTextArea txt_Chat;
    private javax.swing.JTextField txt_Mensaje;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        try {
            DataInputStream in=new DataInputStream(cliente.getInputStream());
            while (true) {
                String usuario=in.readUTF();
                String comando=in.readUTF();
                String mensaje=in.readUTF();
                
                String chat = txt_Chat.getText();
                txt_Chat.setText(usuario+":"+mensaje+"\n"+chat);                
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientRPCB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}