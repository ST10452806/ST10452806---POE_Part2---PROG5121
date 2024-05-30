package poe_end_of_year;

import static org.junit.jupiter.api.Assertions.assertEquals;  

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.Test;

public class checkersTest {

//Part2
    @Test
    public void testCheckTaskDescription() {
        
        Tasks t1 = new Tasks();
        
        boolean expected = true;
        boolean actual = t1.checkTaskDescription("HI");
        
        assertEquals(expected, actual);
    }

    @Test
    public void testCreateTaskID() {
        Tasks t2 = new Tasks();
        
        String expected = "TA:0:DOE";
        
        String actual = t2.createTaskID("Task ID", "John Doe");
        
        assertEquals(expected, actual);
    }
    

    @Test
    public void testPrintTaskDetails() {
        Tasks test3 = new Tasks();
        
        Task task = new Task("task1", "This is a task description.", 3, "To do", "John Doe");
        
        String expected = """
                          Task ID: TA:0:DOE
                          Task Name: task1
                          Description: This is a task description.
                          Duration: 3 hours
                          Status: To do
                          Developer: John Doe""";
         String actual = test3.printTaskDetails(task);
         assertEquals(expected, actual);
}


    @Test
    public void testReturnTotalHours() {
        Tasks test4 = new Tasks();
        
        Task task1 = new Task("task1", "This is a task description.", 3, "To do", "John Doe");
        Task task2 = new Task("task2", "This is another task description.", 5, "Doing", "Jane Doe");
        Task[] tasks = {task1, task2};
        int expected = 8;
        int actual = test4.returnTotalHours(tasks);
        assertEquals(expected, actual);
    }
}




    
/*    public checkersTest() {
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
        
        Login testing = new Login();
        
        String expected = "kyl_l";
        Login realUserName = testing;
        
        boolean check = true;
        
        checkers test = new checkers(expected, expected);
        check = test.checkUserName();
        System.out.println(check);
        
    }

    @Test
    public void testCheckPasswordComplexity() {
        
        Login testing = new Login();
        
        String expected = "1!Asdfgh";
        Login realPassword = testing;
        
        boolean checking = true;
        
        checkers test = new checkers(expected, expected);
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
        
    }*/
    