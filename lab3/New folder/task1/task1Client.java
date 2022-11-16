import java.io.*;
import java.net.*;
import java.util.*;

public class task1Client {
  public static void main(String[] args) {
    try {
      Socket s = new Socket("localhost",5000);
      
      InputStreamReader input = new InputStreamReader(new DataInputStream(s.getInputStream()));
      BufferedReader reader = new BufferedReader(input);
      
      System.out.println("Today's date : "+ reader.readLine());
 
      s.close();
      
    }catch(Exception e){
      System.out.println(e);
    }
  }
}