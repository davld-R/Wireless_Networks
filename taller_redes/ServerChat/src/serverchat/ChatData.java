/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lusy Enriquez, Angie Portilla, Jackeline Espinoza
 */
public class ChatData extends Thread {

    DataOutputStream os;
    DataInputStream is;
    Socket client;
    LinkedList<Socket> clients;
    LinkedList<String> usuarios;
    String nombre;

    public ChatData(DataOutputStream os, DataInputStream is, Socket client, LinkedList<Socket> clients, LinkedList<String> usuarios, String nombre) {
        this.os = os;
        this.is = is;
        this.client = client;
        this.clients = clients;
        this.usuarios = usuarios;
        this.nombre = nombre;
    }

    public ChatData(Socket client, String nombre) {
        this.client = client;
        this.nombre = nombre;

        try {
            this.os = new DataOutputStream(client.getOutputStream());
            this.is = new DataInputStream(client.getInputStream());

        } catch (IOException ex) {
            Logger.getLogger(ChatData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                String msj = is.readUTF();//recibe el nombre
                System.out.println(msj);
                for (Socket client1 : clients) {
                    DataOutputStream os = new DataOutputStream(client1.getOutputStream());
                    os.writeUTF(usuarios + ":" + msj);
                }
            } catch (IOException ex) {
                try {
                    // desarrollo del primer punto solucionar el error
                    this.client.close();//se cierra la conexion de cliente que se desconecto
                    this.os.close();//se cierra el flujo de salida 
                    this.is.close();//se cierra el flujo de entrada
                    // desarrollo del tercer punto saber cuando un cliente se ha desconectado
                    clients.remove(this.client);//se quita el cliente de esa lista clientes
                    usuarios.remove(this.nombre);//se quita el nombre de la lista usuarios 
                    System.out.println(usuarios + ":Todos:" + this.nombre + " se desconecto"); // se imprime en el servidor el usuario que se desconecta

                    for (Socket client1 : clients) {
                        DataOutputStream os;
                        os = new DataOutputStream(client1.getOutputStream());
                        os.writeUTF(usuarios + ":Todos:" + this.nombre + " se desconecto");//se envia para todos los chats el usuario que se desconecta
                    }
                } catch (IOException ex1) {
                    Logger.getLogger(ChatData.class.getName()).log(Level.SEVERE, null, ex1);
                }
                break;
            }
        }

    }

}
