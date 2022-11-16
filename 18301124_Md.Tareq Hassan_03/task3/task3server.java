import java.io.*;
import java.net.*;
import java.util.Date;

public class task3server{
  public static void main(String[] args){
    try{
      while(true){
        ServerSocket ss = new ServerSocket(7777);
        System.out.println("Server Running at Port : 7777");
        
        Socket socket = ss.accept();
	System.out.println("Client connected");

        
        task3ServerThread serverThread = new task3ServerThread(socket);
        serverThread.start();
        
        
        ss.close();
      }
    }catch(Exception e){
      System.out.println("Something went wrong");
    }
  }
}