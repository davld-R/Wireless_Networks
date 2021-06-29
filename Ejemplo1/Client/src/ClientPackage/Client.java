/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import  java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Aula_info
 */
public class Client {
    public static void main(String[] args) throws IOException{
        Socket client=new Socket("127.0.0.1", 5000);
        Scanner sc=new Scanner(System.in);
        System.out.println("Escriba mensaje:");
        
        DataInputStream in=new DataInputStream(client.getInputStream());
        DataOutputStream out=new DataOutputStream(client.getOutputStream());
        //ObjectOutputStream obj=new ObjectOutputStream(client.getOutputStream());
        
        String mensaje=sc.nextLine();
        System.out.println(mensaje);        
        
        out.writeUTF(mensaje);
        
        String rta=in.readUTF();
        System.out.println(rta);
        client.close();
        
    }
}
