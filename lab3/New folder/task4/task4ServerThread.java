import java.io.*;
import java.net.*;

public class task4ServerThread extends Thread{
  
  private Socket socket;
  
  task4ServerThread(Socket s){
    socket = s;
  }
  
  public  void run(){
    
    try{
      InputStreamReader input = new InputStreamReader(new DataInputStream(socket.getInputStream()));
      BufferedReader reader = new BufferedReader(input);
      
      DataOutputStream output = new DataOutputStream(socket.getOutputStream());
      PrintWriter writer = new PrintWriter(output, true);
      
      while(true){
        //String client_response = reader.readLine();
        String option = reader.readLine();
        String n1 = reader.readLine();
        String n2 = reader.readLine();
        
        if(option.equals("1")){
          int sum = Integer.parseInt(n1) + Integer.parseInt(n2);
          writer.println("Sum = "+sum);
        }else if(option.equals("2")){
          int subs = Integer.parseInt(n1) - Integer.parseInt(n2);
          writer.println("Sub = "+subs);
        }else if (option.equals("3")){
          int mul = Integer.parseInt(n1) * Integer.parseInt(n2);
          writer.println("Mul = "+mul);
        }else{
          writer.println("Goodbye");
          break;
        }
      }
    }catch(Exception e) {
      System.out.println("Something went wrong");
    }
  }
}

