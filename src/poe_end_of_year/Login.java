package poe_end_of_year;

import poe_end_of_year.checkers;
import java.util.*;

public class Login {
    
     public static void main(String[] args) {
         
        Scanner input = new Scanner(System.in);
        
        String firstName;
         String lastName;
          String userName;
           String Password;

        System.out.print("Enter your first name: ");
        firstName = input.nextLine();

        System.out.print("Enter your last name: ");
        lastName = input.nextLine();

        System.out.print("Enter a username (at least 5 characters long and containing an underscore): ");
        userName = input.nextLine();

        System.out.print("Enter a password (at least 8 characters long, containing a capital letter, a number, and a special character): ");
        Password = input.nextLine();
        
        System.out.println(firstName);
         System.out.println(lastName);
          System.out.println(userName);
           System.out.println(Password);

        checkers user = new checkers(userName, Password);
        user.checkRegistration();

        System.out.println("Enter your username to log in: ");
        String loginUsername = input.nextLine();

        System.out.println("Enter your password to log in: ");
        String loginPassword = input.nextLine();
       

        user.checkLogin(loginUsername, loginPassword);
        
        System.out.println("Welcome " + firstName + " " + lastName + " nice to see you again");

    
}
     
     
     
}
