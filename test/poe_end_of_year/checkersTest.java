package poe_end_of_year;

import static org.junit.jupiter.api.Assertions.assertEquals;  

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.Test;

public class checkersTest {
    
    public checkersTest() {
    }

    @Test
    public void testCheckUserName() {
        
        /*
        String userName = "kyl_1";
        String Password = "1!Asdfgh";
        boolean check = true;

        checkers test = new checkers(userName, Password);
        
        check = test.checkUserName();
        System.out.println(check);
        */
        String userName = "kyl_l";
        
        boolean check = true;
        
        checkers test = new checkers(userName, userName);
        check = test.checkUserName();
        System.out.println(check);
        
    }

    @Test
    public void testCheckPasswordComplexity() {
        
        String Password = "1!Asdfgh";
        
        boolean checking = true;
        
        checkers test = new checkers(Password, Password);
        checking = test.checkPasswordComplexity();
        System.out.println(checking);
        
    }

    @Test
    public void testCheckRegistration() {
        
        String registraionUserName = "kyl_l";
        String registarionPassword = "1!Asdfgh";
        
        boolean doubleCheck = true;
        
        checkers test = new checkers(registraionUserName, registarionPassword);
        doubleCheck = test.checkRegistration();
        System.out.println(doubleCheck);
        
    }

    @Test
    public void testCheckLogin() {
        
        String loginUserName = "kyl_l";
        String loginPassword = "1!Asdfgh";
        
        boolean endCheck = true;
        
        checkers test = new checkers(loginPassword, loginUserName);
        endCheck = test.checkRegistration();
        System.out.println(endCheck);
        
    }
    
}
