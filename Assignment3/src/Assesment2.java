import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject; 

public class Assesment2 { 

   @SuppressWarnings("unchecked")
public static void main(String args[]) { 

      //Creating a JSONObject object 

      JSONObject jsonObject = new JSONObject(); 

      

      jsonObject.put("ID", "07"); 

      jsonObject.put("First_Name", "Manish"); 

      jsonObject.put("Last_Name", "Kumar"); 

      jsonObject.put("Date_Of_Birth", "1998-05-15"); 

      jsonObject.put("Place_Of_Birth", "Bihar"); 

      jsonObject.put("Country", "India"); 

      try { 

         FileWriter file = new FileWriter("C:\\new\\output.json"); 

         file.write(jsonObject.toJSONString()); 

         file.close(); 

      } catch (IOException e) { 

         // TODO Auto-generated catch block 

         e.printStackTrace(); 

      } 

      System.out.println("JSON file created: "+jsonObject); 

   } 

} 

