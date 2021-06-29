package httpservidor;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.StringTokenizer;


public class HTTPServidor implements Runnable{ 
	
	static final File WEB_ROOT = new File(".");
        static final String DEFAULT_DIRECTORY="www/";
	static final String DEFAULT_FILE = "index.html";
	static final String ERROR_NO_ENCONTRADO = "404.html";
	static final String METHOD_NOT_SUPPORTED = "not_supported.html";
	

	//static final int PUERTO = 49300;
	static final int PUERTO = 5516;
	
	
	
	
	private Socket sk;
	
	public HTTPServidor(Socket c) {
		sk = c;
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
            
            
		try {
			ServerSocket servidorConectado = new ServerSocket(PUERTO);
			System.out.println("servidor conectado, puerto: " + PUERTO );
			
			while (true) {
				HTTPServidor servidor = new HTTPServidor(servidorConectado.accept());
				
				if (true) {
					System.out.println("Connecton abierta. (" + new Date() + ")");
				}
				
			
				Thread i = new Thread(servidor);
				i.start();
			}
			
		} catch (IOException e) {
			System.err.println("Error en la coneccion con el servidor : " + e.getMessage());
		}
	}

	@Override
	public void run() {
	
		BufferedReader in = null; PrintWriter out = null; BufferedOutputStream dataOut = null;
		
		
		try {
		
			in = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			
			out = new PrintWriter(sk.getOutputStream());
		
			dataOut = new BufferedOutputStream(sk.getOutputStream());
			
			
			String input = in.readLine();
		
			StringTokenizer parse = new StringTokenizer(input);
			String metodo = parse.nextToken().toUpperCase(); // we get the HTTP method of the client
                        String currentfile=parse.nextToken().replaceAll("GET /", "");
                        if (!metodo.equals("GET")  &&  !metodo.equals("HEAD")){
                            System.out.println("501 No Implementado : " + metodo + " metodo.");
                        }				 
			else  {				
				File archivo = new File(DEFAULT_DIRECTORY+DEFAULT_FILE);
                                if(!currentfile.trim().equals("") && !currentfile.trim().equals("/")){
                                    archivo = new File(DEFAULT_DIRECTORY+currentfile);
                                }
				int tamañoArchivo = (int) archivo.length();							   
                                byte[] fileData = readFileData(archivo, tamañoArchivo);

                                // send HTTP Headers
                                out.println("HTTP/1.1 200 OK");
                                out.println("Servidor: Electiva redes HTTP Final Redes");
                                out.println("Fecha: " + new Date());

                                out.println("Tamaño: " + tamañoArchivo);
                                out.println(); 
                                out.flush(); 

                                dataOut.write(fileData, 0, tamañoArchivo);
                                dataOut.flush();
				
	
				if (true) {
					System.out.println("Archivo " );
				}
				
			
	
			
			}
			} 
                catch (FileNotFoundException fnfe)
                {
			try {
                            fileNotFound(out, dataOut, null);
			} 
                        catch (IOException e)
			{
                            System.err.println("Error archivo no encontrado: " + e.getMessage());
			}
			
		} catch (IOException e) 
                {
			System.err.println("Error de servidor : " + e);
		} 
                finally 
                {
                    try 
                    {
                            in.close();
                            out.close();
                            dataOut.close();
                            sk.close(); 
                    } catch (Exception e) {
                            System.err.println("Error, cerrando flujo de datos  : " + e.getMessage());
                    } 			
                    
                    System.out.println("coneccion cerrada");
                    
		}
		
		
	}
	
	private byte[] readFileData(File Archivo, int tamaño) throws IOException {
		FileInputStream fileIn = null;
		byte[] fileData = new byte[tamaño];
		
		try {
			fileIn = new FileInputStream(Archivo);
			fileIn.read(fileData);
		} finally {
			if (fileIn != null) 
				fileIn.close();
		}
		
		return fileData;
	}
	

	
		
		
	private void fileNotFound(PrintWriter out, OutputStream dataOut, String archivoSolicitado) throws IOException {
		File file = new File(WEB_ROOT, ERROR_NO_ENCONTRADO);
		int tamaño = (int) file.length();
		String content = "text/html";
		byte[] fileData = readFileData(file, tamaño);
		
		out.println("HTTP/1.1 404 archivo no encontrado");
		out.println("Servidor: ServidorHTTP Final Redes");
		out.println("Fecha: " + new Date());
		out.println("Tipo de Contenido: " + content);
		out.println("tamaño: " + tamaño);
		out.println(); // blank line between headers and content, very important !
		out.flush(); // flush character output stream buffer
		
		dataOut.write(fileData, 0, tamaño);
		dataOut.flush();
		
		if (true) {
			System.out.println("Archivo " + archivoSolicitado + " no encontrado");
		}
	}
	
}