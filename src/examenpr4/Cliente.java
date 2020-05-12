package examenpr4;

/**
 *
 * @author ADVANCE
 */
import java.net.*;  
import java.io.*;  


public class Cliente {
    public static void main(String args[])throws Exception{  
        Socket s=new Socket("127.0.0.1",5050);  
        DataInputStream in = new DataInputStream(s.getInputStream());  
        DataOutputStream out = new DataOutputStream(s.getOutputStream());  
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));  

        String mensaje1="",mensaje2="";  
        while(!mensaje1.equals("Finalizar")){  
            mensaje1=bf.readLine();  
            out.writeUTF(mensaje1);  
            out.flush();  
            mensaje2=in.readUTF();  
            System.out.println("Servidor: "+mensaje2); 

        }  
    out.close(); 
    s.close();  
    } 
}