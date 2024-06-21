package poe_end_of_year;

import javax.swing.*;

public class checkers {

    public String userName;
    public String Password;

    public checkers(String userName, String Password) {
        
        this.userName = userName;
        this.Password = Password;
    }

    public void setUserName(String user) {
        this.userName = user;
    }

    public void setPassword(String pass) {
        this.Password = pass;
    }

    public void setLoginPassword(String LoginPass) {
        this.Password = LoginPass;
    }

    public void setLoginUserName(String LoginUserName) {
        this.userName = LoginUserName;
    }

    //create boolean to check user name is correct in terms of the requirements
    public boolean checkUserName() {

        if (userName.length() <= 5 && userName.contains("_")) {

            return true;

        } else {
            JOptionPane.showMessageDialog(null, "Invalid username. Must be at least 5 characters long and contain an underscore.");
            return false;
        }

    }

    //create boolean that checks the passowrd is correct
    public boolean checkPasswordComplexity() {

        if (Password.matches(".*[A-Z].*") && Password.matches(".*[!@#$%^&*].*")
                && Password.matches(".*\\d.*") && Password.length() >= 8) {

            return true;

        } else {
            JOptionPane.showMessageDialog(null, "Invalid password. Must contain at least one capital letter, one special character, one number, and be at least 8 characters long.");
            return false;
        }

    }

    //Create boolean to check the user name and password are valid
    public boolean checkRegistration() {

        if (checkPasswordComplexity() && checkUserName()) {

            JOptionPane.showMessageDialog(null, "The above conditions have been met and the registration was successful");
            return true;

        } else {
            //JOptionPane.showMessageDialog(null, "User name incorrectly formatted or password complexity did not meet the requirements");

            return false;

        }

    }

    public boolean checkLogin(String loginUsername, String loginPassword) {

        if (userName.equals(loginUsername)) {

            if (Password.equals(loginPassword)) {

                JOptionPane.showMessageDialog(null, "You have logged in successfully");
                return true;

            } else {

                JOptionPane.showMessageDialog(null, "The password doesn't match.");
                return false;

            }
        } else {

            JOptionPane.showMessageDialog(null, "The username doesn't match.");
            return false;

        }

    }

}
