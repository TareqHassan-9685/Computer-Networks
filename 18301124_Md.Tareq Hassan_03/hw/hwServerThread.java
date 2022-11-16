import java.io.*;
import java.net.*;

public class hwServerThread extends Thread{
  
  private Socket socket;
  
  hwServerThread(Socket s){
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
        	
            char [] z=client_response.toCharArray();
            for(int i=0;i<z.length;i++){ 
                System.out.print((int)z[i]);

            }
      }
      }
    }
      catch(Exception e) {
      System.out.println("Something went wrong");
    }
  }
}