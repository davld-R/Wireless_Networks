/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author Asus
 */
public class ClientUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        // TODO code application logic here
        //Se crea un socket UDP cliente
        DatagramSocket  client=new DatagramSocket();
        
        //Se crea un mensaje
        String msj="10,20";
        //Se convierte el mensaje en bytes
        byte[] bmsj=msj.getBytes();
        //Se declara la ip del servidor a enviar
        InetAddress host=InetAddress.getByName("localhost");
        
        //Se crea el paquete para enviar petición
        DatagramPacket request=new DatagramPacket(bmsj, msj.length(),host,5000);
        //Se envia el paquete
        client.send(request);
        
        //Se crea un buffer para recibir respuesta
        byte[] buffer=new byte[1024];
        
        //Se crea el paquete para recibir respuesta
        DatagramPacket response=new DatagramPacket(buffer, buffer.length);
        //Se recibe la respuesta
        client.receive(response);
        
        //Se escribe la respuesta del servidor
        String rta=new String(response.getData());
        System.out.println(rta);
        
        client.close();
        
        
    }
    
}
