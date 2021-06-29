/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientebroadcast;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aula_info
 */
public class ClienteBroadCast extends javax.swing.JFrame implements Runnable{

    /**
     * Creates new form ClienteBroadCast
     */
    Thread hilo;
    public ClienteBroadCast() {
        initComponents();
        hilo=new Thread(this);
        hilo.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_Impuesto = new javax.swing.JLabel();
        lbl_Precio1 = new javax.swing.JLabel();
        lbl_PrecioGE = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_Impuesto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_Impuesto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Impuesto.setText("Retención por IVA");

        lbl_Precio1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_Precio1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Precio1.setText("Precio: 15000");

        lbl_PrecioGE.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_PrecioGE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_PrecioGE.setText("Precio GE: 20000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_Impuesto, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(lbl_Precio1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lbl_PrecioGE, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(lbl_Precio1)
                .addGap(88, 88, 88)
                .addComponent(lbl_Impuesto)
                .addContainerGap(103, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(108, 108, 108)
                    .addComponent(lbl_PrecioGE)
                    .addContainerGap(163, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ClienteBroadCast.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteBroadCast.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteBroadCast.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteBroadCast.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteBroadCast().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl_Impuesto;
    private javax.swing.JLabel lbl_Precio1;
    private javax.swing.JLabel lbl_PrecioGE;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        Socket cliente;
        try {
            cliente = new Socket("localhost",5000);
            DataInputStream in=new DataInputStream(cliente.getInputStream());
            while (true) {    
                double precio=in.readDouble();
                double precioGE=in.readDouble();
                String impuesto=in.readUTF();
                lbl_Precio1.setText("Precio:"+precio);
                lbl_PrecioGE.setText("Precio GE:"+precioGE);
                lbl_Impuesto.setText("Retención por "+impuesto);
            }            
        } catch (IOException ex) {
            Logger.getLogger(ClienteBroadCast.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
    }
}