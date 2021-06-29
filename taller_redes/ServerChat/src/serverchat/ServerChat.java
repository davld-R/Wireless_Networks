/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

/**
 *
 * @author Lusy Enriquez, Angie Portilla, Jackeline Espinoza
 */
public class ServerChat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        System.out.println("**Servidor Listo**\n");

        ServerSocket server = new ServerSocket(5000);
        LinkedList<ChatData> chats = new LinkedList<>();
        LinkedList<Socket> clients = new LinkedList<>();
        LinkedList<String> usuarios = new LinkedList<>();

        while (true) {
            Socket clientsocket = server.accept();
            DataInputStream entrada = new DataInputStream(clientsocket.getInputStream());
            ChatData chat1 = new ChatData(clientsocket, entrada.readUTF());
            chats.add(chat1);
            clients.add(clientsocket);
            usuarios.add(chat1.nombre);

            for (ChatData chat : chats) {
                chat.clients = clients;
                chat.usuarios = usuarios;
            }

            for (Socket clien1 : clients) {
            DataOutputStream os;
                // desarrollo del tercer punto saber cuando un cliente se ha conectado
                System.out.println(usuarios + ":Todos:" + chat1.nombre + " conectado");// Envia mensaje al servidor de usuario que se conecta
                os = new DataOutputStream(clien1.getOutputStream());
                os.writeUTF(usuarios + ":Todos:" + chat1.nombre + " conectado");// envia mensaje al chat de los clientes de usuario que se conecta
                }

            chat1.start();
        }

    }

}
