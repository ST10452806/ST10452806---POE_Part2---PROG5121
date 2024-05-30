package poe_end_of_year;

import poe_end_of_year.checkers;
import java.util.*;
import javax.swing.*;

public class Login {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        String firstName;
        String lastName;
        String userName = "";
        String Password = "";
        boolean pass = false;
        boolean loginInfo = false;
        
        firstName = JOptionPane.showInputDialog("Enter your first name: ");
        
        lastName = JOptionPane.showInputDialog("Enter your last name: ");
        
        checkers user = new checkers(userName, Password);
        
        while (!pass) {
            
            userName = JOptionPane.showInputDialog("Enter a username (at least 5 characters long and containing an underscore): ");
            
            Password = JOptionPane.showInputDialog("Enter a password (at least 8 characters long, containing a capital letter, a number, and a special character): ");
            
            user.setPassword(Password);
            user.setUserName(userName);
            pass = user.checkRegistration();
            
        }
        
        JOptionPane.showMessageDialog(null, "First Name: \n" + firstName +  "Last Name: \n" + lastName 
                                      + "Username: \n" + userName + "Password: \n" + Password );
      
        while(!loginInfo){
            
            String loginUsername = JOptionPane.showInputDialog("Enter your username to log in: ");
            String loginPassword = JOptionPane.showInputDialog("Enter your password to log in: ");
            
            loginInfo = user.checkLogin(loginUsername, loginPassword);
        }    
        
        JOptionPane.showMessageDialog(null, "Welcome " + firstName + " " + lastName + " nice to see you again");
        
        Tasks afterLogin = new Tasks();
        
        afterLogin.startTasks();
        afterLogin.addTasks();

    }
    
}