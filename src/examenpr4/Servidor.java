package examenpr4;

/**
 *
 * @author ADVANCE
 */

import java.net.*;  
import java.io.*;  
import java.io.PrintWriter;

public class Servidor {
    public static void main(String args[])throws Exception{
        
            ServerSocket servidor=new ServerSocket(5050);  
            Socket s = servidor.accept();  
            DataInputStream in = new DataInputStream(s.getInputStream());  
            DataOutputStream out = new DataOutputStream(s.getOutputStream());  
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));  

            String mensaje1="",mensaje2="";  
            
            String Final = null;
            
            while(!mensaje1.equals("Finalizar")){  
                mensaje1=in.readUTF();  
                System.out.println("Cliente: "+mensaje1);  
                mensaje2=bf.readLine();  
                out.writeUTF(mensaje2);  
                out.flush();  
             
                if(Final == null){
                    Final = "Cliente: "+mensaje1+"\n"+"Servidor: "+mensaje2+"\n";
                }else{
                    Final = Final +"Cliente: "+mensaje1+"\n"+"Servidor: "+mensaje2+"\n";
                  
                }
            }
            
        in.close();  
        s.close();  
        servidor.close();
        int i = 1;
        String ruta = "F:/chat_"+ i +".txt";
        File archivo = new File(ruta);      
        
        do{
            ++i;
            ruta = "F:/chat_"+ i +".txt";
            archivo = new File(ruta);
        }while (archivo.exists());
        
        PrintWriter writer = new PrintWriter("F:/chat_"+ i +".txt", "UTF-8");
        writer.println(Final);
        writer.close();
    }
}