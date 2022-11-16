import java.io.*;
import java.net.*;
import java.net.Socket;

public class task3ServerThread extends Thread{
  
  private Socket socket;
  
  task3ServerThread(Socket s){
    socket = s;
  }
  
  public  void run(){
    
    try{
      InputStreamReader input = new InputStreamReader(new DataInputStream(socket.getInputStream()));
      BufferedReader reader = new BufferedReader(input);
      
      DataOutputStream output = new DataOutputStream(socket.getOutputStream());
      PrintWriter writer = new PrintWriter(output, true);
      
      while(true){
        String client_response = reader.readLine();
        
        if(client_response.equalsIgnoreCase("end game")){
          writer.println("goodbye");
          break;
        }else{
          writer.println(client_response);
        }
      }
    }catch(Exception e) {
      System.out.println("Something went wrong");
    }
  }
}