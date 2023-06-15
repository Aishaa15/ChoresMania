package choresmania;
//for later
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class App {
  private static final String JSON_FILE_PATH = "accounts.json";

  public static void main(String[] args) throws Exception {
    JSONParser parser = new JSONParser();
    JSONArray accounts = (JSONArray) parser.parse(new FileReader("accounts.json"));
    Scanner scanner = new Scanner(System.in);
    //use the get method to check input against 
    
    System.out.println("Enter username");
    String userName = scanner.nextLine();  // Read user input
    System.out.println("Username is: " + userName);

    System.out.println("Enter password");
    String passWord = scanner.nextLine(); 
    System.out.println("Password is: " + passWord);
    Boolean userNameMatches = false;
    Boolean passwordMatches = false;
    for (Object o : accounts)
    {
      JSONObject person = (JSONObject) o;
      String username = (String) person.get("username");
      if(userName == username){
        userNameMatches = true;
      }


      String password = (String) person.get("password");
      System.out.println(password);
      if(password == passWord){
        passwordMatches = true;
      }
    }

    if(userNameMatches && passwordMatches){
      //do something
    }

    //creating the data structure
    JSONObject jo = new JSONObject();
    jo.put("username", "John");
    jo.put("email", "sdkn@gmail.com");
    jo.put("password", "1234AZ");
    jo.put("securityQuestion", "What's your favorite color?");
    jo.put("securityAnswer", "green");

    JSONObject member = new JSONObject();
    JSONArray assignedChores = new JSONArray();
    JSONArray unassignedChores = new JSONArray();
    member.put("personName","John");
    member.put("assignedChores",assignedChores);

    //add member to family
    JSONArray familyMembers = new JSONArray();
    familyMembers.add(member);

    jo.put("family",familyMembers);
    jo.put("unassignedChores",unassignedChores);
    jo.put("customTheme", "green");

    //add user to total list of users
    JSONArray ja = new JSONArray();
    ja.add(jo);

    System.out.println(ja);

    try (FileWriter file = new FileWriter("accounts.json")) {
            file.write(ja.toJSONString()); 
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
  }
}
