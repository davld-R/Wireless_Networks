package serverrpcb;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author David Rojas - David Muños - Sebastian Salazar
 */
public class ClientRPCB implements Runnable{
    
    ServerRPCB server;
    Socket cliente;
    String usuario;
    DataOutputStream out;
    DataInputStream in;
    
    Thread hilo;

    public ClientRPCB(Socket cliente, ServerRPCB server) {
        this.server = server;
        this.cliente=cliente;
        hilo = new Thread(this);
        hilo.start();
    }
    
    public void SendALL(String comando, String mensaje) throws IOException{
        for (ClientRPCB client : server.clientes){
            if(!usuario.equals(client.usuario)){
                this.out = new DataOutputStream(client.cliente.getOutputStream());
                out.writeUTF(usuario);
                out.writeUTF(comando);
                out.writeUTF(mensaje);
            }
        }
    }
    
    public void SendSpecific(String usuario, String comando, String mensaje) throws IOException{
        for (ClientRPCB client : server.clientes){
            if(usuario.equals(client.usuario)){                
                this.out = new DataOutputStream(client.cliente.getOutputStream());
                out.writeUTF(usuario);
                out.writeUTF(comando);
                out.writeUTF(mensaje);
            }
        }
    }
    
    public void SendDConex(String desconectar){
        try {
            this.usuario = desconectar;
            for (ClientRPCB c : server.clientes) {               
                this.out = new DataOutputStream(c.cliente.getOutputStream());
                out.writeUTF(usuario);
                out.writeUTF("DConex");
                out.writeUTF(usuario+" Desconectado");
            }        
        } catch (IOException ex) {
            Logger.getLogger(ClientRPCB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    @Override
    public void run() {
        try {
            while(true && !cliente.isClosed()){                
                this.in = new DataInputStream(cliente.getInputStream());                
                String usuario = in.readUTF();
                String comando = in.readUTF();
                String mensaje = in.readUTF();
                System.out.println(usuario+" "+comando+" "+mensaje);
                
                switch(comando){
                    case "Conex":
                        this.usuario = usuario;
                        SendALL(comando, usuario+" conectado");
                    case "All":
                        SendALL(comando, mensaje);
                        break;
                    case "User":
                        //1. Mensajes de usuario a usuario
                        String[] cmsj = mensaje.split(":");
                        SendSpecific(cmsj[0], comando, cmsj[1]);
                        break;
                    case "DConex":
                        //2. Desconexion
                        SendDConex(usuario);
                        break;
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ClientRPCB.class.getName()).log(Level.SEVERE, null, ex);           
                     
        }
    }    
}
