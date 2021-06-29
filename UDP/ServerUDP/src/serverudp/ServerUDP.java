/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author Asus
 */
public class ServerUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException, IOException {
        // TODO code application logic here
        //Se crea el socket UDP
        DatagramSocket server=new DatagramSocket(5000);
        //Se crea un bufer de 1024 bytes 1Kb
        byte[] bufer=new byte[1024];
        while(true){
            //Se crea paquete para recibir información
            DatagramPacket request=new DatagramPacket(bufer, bufer.length);
            //Se recibe
            server.receive(request);
            //Se muestra la información
            System.out.println(request.getAddress()+" "+request.getPort());
            String msj=new String(request.getData());
            
            String[] operators=msj.split(",");
            int o1=Integer.parseInt(operators[0]);
            int o2=Integer.parseInt(operators[1].trim());
            
            int r=o1+o2;
            System.out.println(msj);
            System.out.println(o1+"+"+o2+"="+r);
            
            String msjr=o1+"+"+o2+"="+r;
            //Se prepara un paquete para dar una respuesta
            DatagramPacket response=new DatagramPacket(
                    msjr.getBytes(), 
                    msjr.length(),
                    request.getAddress(),
                    request.getPort());
            
            //Se envía la respuesta
            server.send(response);
        }
    }
    
}
