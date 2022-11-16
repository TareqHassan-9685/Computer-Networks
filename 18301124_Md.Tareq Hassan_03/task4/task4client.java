import java.io.*;
import java.net.*;
import java.util.*;

public class task4client{
  public static void main(String[] args) {
    try {
      Socket s = new Socket("localhost",7777);
      
      InputStreamReader input = new InputStreamReader(new DataInputStream(s.getInputStream()));
      BufferedReader reader = new BufferedReader(input);
      
      DataOutputStream output = new DataOutputStream(s.getOutputStream());
      PrintWriter writer = new PrintWriter(output, true);
      
      Scanner sc = new Scanner(System.in);
      while(true){
        System.out.println("----------Menu------------");
        System.out.println("1 Add numbers");
        System.out.println("2 Subtract numbers");
        System.out.println("3 Mulitply numbers");
        System.out.println("Enter 0 to close the applicationm : ");
        
        String option = sc.nextLine();
        
        //System.out.println("Say something in the server : ");
        //String in = sc.nextLine();
        writer.println(option);
        if(!option.equals("0")){
          System.out.println("Enter first number : ");
          String n1 = sc.nextLine();
          System.out.println("Enter second number : ");
          String n2 = sc.nextLine();
          writer.println(n1);
          writer.println(n2);
        }else{
          String n1 = "0";
          String n2 = "0";
        }
        
        
        
        
        //writer.println(in);
        String response = reader.readLine();
        System.out.println("From server : "+response);
        
        if(response.equalsIgnoreCase("goodbye")){
          break;
        }
      }
      
      s.close();
    }catch(Exception e) {
      System.out.println(e);
    }
  }
}