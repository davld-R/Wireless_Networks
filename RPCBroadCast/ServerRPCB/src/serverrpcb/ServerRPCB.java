package serverrpcb;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author David Rojas - David Muños - Sebastian Salazar
 */
public class ServerRPCB implements Runnable{

    Thread hilo;
    List<ClientRPCB> clientes;
    public ServerRPCB() {
        clientes = new LinkedList<>();
        hilo= new Thread(this);
        hilo.start();
    }    
    
    public static void main(String[] args) {
             
        ServerRPCB server = new ServerRPCB();
    }

    @Override
    public void run() {
        try {
            System.out.println("Servidor listo");
            ServerSocket servidor = new ServerSocket(5000);
            while(true){
                Socket cliente = servidor.accept();
                clientes.add(new ClientRPCB(cliente, this));
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ServerRPCB.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }  
}
