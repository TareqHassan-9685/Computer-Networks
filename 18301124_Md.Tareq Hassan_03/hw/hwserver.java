
import java.io.*;
import java.net.*;
import java.util.Date;

public class hwserver{
  public static void main(String[] args){
    int n = 0;
    try{
      while(true){
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server Running at Port : 5000");
        
        Socket socket = ss.accept();


        
        hwServerThread serverThread = new hwServerThread(socket);
        serverThread.start();
        
        
        ss.close();
      }
    }catch(Exception e){
      System.out.println("Something went wrong");
    }
  }
}