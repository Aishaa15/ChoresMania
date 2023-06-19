package choresmania;
//for later
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class App {
  //replace file path with your file path
  private static final String JSON_FILE_PATH = "/Users/kuroliu/chores mania/demo/src/main/java/choresmania/accounts.json";

  public static void main(String[] args) throws Exception {
    JSONParser parser = new JSONParser();
    JSONArray accounts = (JSONArray) parser.parse(new FileReader(JSON_FILE_PATH));
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
      System.out.println("username is: " + username);
      System.out.println("userName is: " + userName);
      if(username.equals(userName)){
        userNameMatches = true;
        System.out.println("username matches: " + userNameMatches);
      }


      String password = (String) person.get("password");
      System.out.println("password is: " + password);
      if(password.equals(passWord)){
        passwordMatches = true;
        System.out.println("password matches: " + passwordMatches);
      }

      if(userNameMatches && passwordMatches){
        break;
      } else {
        userNameMatches = false;
        passwordMatches = false;
      }
    }

    System.out.println("username matches: " + userNameMatches);
    System.out.println("password matches: " + passwordMatches);

    if(userNameMatches && passwordMatches){
      //do something
      System.out.println("matches");
    } else {
      System.out.println("Username or password incorrect");
    }

    //creating the data structure
    JSONObject jo = new JSONObject();
    jo.put("username", "john");
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

    try (FileWriter file = new FileWriter(JSON_FILE_PATH)) {
            file.write(ja.toJSONString()); 
            file.flush();
            file.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
  
    try (FileReader reader = new FileReader("accounts.json")) {
            Object obj = parser.parse(reader);
            JSONArray accounts2 = (JSONArray) obj;

            List<String> family = new ArrayList<>();
            family.add("FamilyMember1");
            family.add("FamilyMember2");
            family.add("FamilyMember3");
            //add more family members as needed

            List<String> chores = new ArrayList<>();
            chores.add("Chore1");
            chores.add("Chore2");
            chores.add("Chore3");
            //add more chores as needed

            Collections.shuffle(chores);

            List<String> assignedChores2 = new ArrayList<>();
            List<String> unassignedChores2 = new ArrayList<>(chores);
            int choresPerFamilyMember = unassignedChores.size() / family.size();

            for (String member2 : family) {
                for (int i = 0; i < choresPerFamilyMember; i++) {
                    int randomIndex = new Random().nextInt(unassignedChores.size());
                    assignedChores.add(unassignedChores.get(randomIndex));
                    unassignedChores.remove(randomIndex);
                }
            }

            if (!unassignedChores.isEmpty()) {
                for (String chore : unassignedChores2) {
                    int randomIndex = new Random().nextInt(family.size());
                    assignedChores.add(chore + " assigned to " + family.get(randomIndex));
                }
            }

            try (FileWriter writer = new FileWriter("accounts.json")) {
                writer.write(accounts.toJSONString());
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
  
  }

}
