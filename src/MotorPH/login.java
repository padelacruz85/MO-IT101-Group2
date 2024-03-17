package MotorPH;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;

import org.junit.Test;

import UserAccount.UserAccount;
import ReadData.ReturnOption;  

public class login  
{
	public static void main(String[] args) throws Throwable 
    {
      Scanner input = new Scanner (System.in);  
      String username;
      String password;
      String answer;
      System.out.println("***********************************************");
      System.out.println("                [System Login]         ");    
      System.out.println("***********************************************");
      
      //Enter USername
      System.out.println("Username: ");
      username = input.nextLine();
     //Enter Password
      System.out.println("Password: ");
      password = input.nextLine();

      //Validate credential and return boolean value
      UserAccount login = new UserAccount(username, password);
      
      if(login.checkPassword()) {
    	  MainMenu();
    	  System.out.println("Select from option.");
      	  answer = input.nextLine();
      	  Options(answer);
      }
      else {
          System.out.println("The username and password you entered are incorrect.");
          input.close();
      }
    }
    
	
    private static void MainMenu() {
        System.out.println("\n***********************************************");
        System.out.println("        Main Menu      ");
        System.out.println("***********************************************");
        System.out.println("1: Display Employe Records");
        System.out.println("2: Calculate Work-Hour & Net Salary");
        System.out.println("************************************************");
    }

    private static void Options(String option) throws Throwable {
        switch (option) {
            case "1":
            	System.out.println("Selected option 1");
				ReturnOption.enter_details();
                break;
            case "2":
            	System.out.println("Selected option 3");
            	ReturnOption.work_hour_details();
                break;
            default:
                break;
        }
    }
   
    //*************TEST CASE 1: CREDENTIAL IS VALID*************//
//	@Test
//	public void test_validCreadential() {
//	    String username="paul";
//	    String password="password";
//		UserAccount login = new UserAccount(username, password);
//		assertEquals(true,login.checkPassword(), "Username and Passwors is valid.");  
//		System.out.println("TEST CASE 1: CREDENTIAL IS VALID -> PASSED");  
//	}
//	

}