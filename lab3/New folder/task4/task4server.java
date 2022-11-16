import java.io.*;
import java.net.*;
import java.util.Date;

public class task4server{
  public static void main(String[] args){
    int n = 0;
    try{
      while(true){
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server Running at Port : 5000");
        
        Socket socket = ss.accept();
        ++n;
        System.out.println("Client : "+n+" connected");

        
        task4ServerThread serverThread = new task4ServerThread(socket);
        serverThread.start();
        
        
        ss.close();
      }
    }catch(Exception e){
      System.out.println("Something went wrong");
    }
  }
}