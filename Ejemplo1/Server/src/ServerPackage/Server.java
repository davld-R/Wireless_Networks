/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerPackage;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;//Server
import java.net.Socket;//Client


/**
 *
 * @author Aula_info
 */
public class Server {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        System.out.println("Servidor listo");
        ServerSocket server=new ServerSocket(5000);
                
        
        while(true){
            Socket client=server.accept();
            System.out.println("Un cliente nuevo se ha conectado");
            DataInputStream in=new DataInputStream(client.getInputStream());
            DataOutputStream out=new DataOutputStream(client.getOutputStream());
            //ObjectInputStream obj=new ObjectInputStream(client.getInputStream());
            
            /*Primera in*/
            String msj=in.readUTF();            
            System.out.println("cliente dice: "+msj);          
            
            //Estudiante e=(Estudiante)obj.readObject();
            //System.out.println("cedula:"+e.getCedula()+" nombre:"+e.getNombre()+" promedio:"+e.getPromedio());
            /*Segunda out*/
            out.writeUTF("Hola mundo");
            
            client.close();
            
            
        }
    }
    
}
