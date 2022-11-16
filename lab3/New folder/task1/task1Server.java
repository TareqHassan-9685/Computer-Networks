import java.io.*;
import java.net.*;
import java.util.Date;

public class task1Server {
  public static void main(String[] args){
    try{
      while(true){
        ServerSocket ss = new ServerSocket(5000);
      System.out.println("Server Running at Port : 7777");
      System.out.println("Akash is the best");
      Socket socket = ss.accept();
      System.out.println("Client Connected");
      
      
      String today = new Date().toString();
      DataOutputStream output = new DataOutputStream(socket.getOutputStream());
      PrintWriter writer = new PrintWriter(output, true);
      
      writer.println(today);
      
      ss.close();
      }
    } catch(Exception e) {
      System.out.println("Something went wrong");
    }
  }
}