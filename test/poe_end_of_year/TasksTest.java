package poe_end_of_year;



import static org.junit.jupiter.api.Assertions.assertEquals;  

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.Test;

import java.util.Collections;

import org.junit.Before;

public class TasksTest {

    public Tasks t1 = new Tasks();

    @Before
    public void testStartTasks() {

        Collections.addAll(t1.assignedDeveloperNames, "Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer");
        Collections.addAll(t1.assignedTaskNames, "Create Login", "Create Add Features", "Create Reports", "Add Arrays");
        Collections.addAll(t1.assignedTaskID, "CR:1:ITH", "CR:2:SON", "CR:3:SON", "AD:4:ZER");
        Collections.addAll(t1.assignedDurations, 5, 2, 8, 11);
        Collections.addAll(t1.assignedStatus, "To Do", "Doing", "Done");

    }

    @Test
    public void testAddTasks() {

    }

    @Test
    public void testCheckTaskDescription() {

        Tasks testing = new Tasks();

        boolean expected1 = true;
        boolean actual1;

        String taskDescriptionTest1 = "Create login to authenticate...";

        actual1 = testing.checkTaskDescription(taskDescriptionTest1);

        assertEquals(expected1, actual1);

        boolean expected2 = true;
        boolean actua2;

        String taskDescriptionTest2 = "Create login to add task users...";

        actua2 = testing.checkTaskDescription(taskDescriptionTest2);

        assertEquals(expected2, actua2);

    }

    @Test
    public void testPrintTaskDetails() {
    }

    @Test
    public void testReturnTotalHours() {

        Tasks test = new Tasks();

        test.assignedDurations.add(5);
        test.assignedDurations.add(2);
        test.assignedDurations.add(8);
        test.assignedDurations.add(11);

        int totalHours = test.returnTotalHours();

        assertEquals(26, totalHours);

    }

    @Test
    public void testShowReport() {
    }

    /*@Test
    public void testShowTasksByStatus() {

        String expectedStatus = "Task name: Create Reports"
                + "\nDeveloper: Samantha Paulson"
                + "\nDuration: 8";

        assertEquals(expectedStatus, t1.showTasksByStatus("Done"));

        System.out.println(t1.showTasksByStatus("Done"));

    }*/

    @Test
    public void testShowTaskWithLongestDuration() {
        
        String expectedMaxDuration = "Developer: Glenda Oberholzer" 
                                            + "\nDuration: 11"
                                             + " hours";
        
        assertEquals(expectedMaxDuration, t1.showTaskWithLongestDuration());
        
        System.out.println(t1.showTaskWithLongestDuration());

    }

    @Test
    public void testSearchTaskByName() {

        /*String expected = "Task Name: Create Login\nDeveloper: Mike Smith\nTask Status: Done";
        assertEquals(expected, t1.searchTaskByName());*/
        String expectedTaskName = "Task Name: Create Login"
                + "\nDeveloper: Mike Smith"
                + "\nTask Status: To Do";

        assertEquals(expectedTaskName, t1.searchTaskByName());

        System.out.println(t1.searchTaskByName());
    }

    @Test
    public void testSearchTasksByDeveloper() {

        String expectedDN = "Developer: Samantha Paulson"
                + "\nTask Name: Create Reports"
                + "\nTask Status: Done";

        assertEquals(expectedDN, t1.searchTasksByDeveloper());

        System.out.println(t1.searchTasksByDeveloper());

    }

    @Test
    public void testDeleteTask() {
        
        //String expectedDelTask = "Task deleted successfully";
        
        t1.deleteTask();
        
        assertFalse(t1.assignedTaskNames.contains("Create Reports"));
        assertFalse(t1.assignedDeveloperNames.contains("Samantha Paulson"));
        assertFalse(t1.assignedDurations.contains(8));
        assertFalse(t1.assignedStatus.contains("Done"));
        
        //assertEquals(expectedDelTask, t1.deleteTask());

    }

    @Test
    public void testDisplayAllTasks() {

        String expectedDisplayOutput = "Task Name: Create Login" 
                // + "\nTask number: " + assignedTaskNumber.get(i)
                + "\nDeveloper: Mike Smith"
                + "\nTask ID: CR:1:ITH" 
                + "\nDuration: 5" 
                + "\nStatus: To Do";
        /*String expectedDisplayOutput2 = "Task Name: Create Add Features" 
                   // + "\nTask number: " + assignedTaskNumber.get(i)
                   + "\nDeveloper: Edward Harrison"
                   + "\nTask ID: CR:2:SON" 
                   + "\nDuration: 2" 
                   + "\nStatus: Doing ";
        
        String expectedDisplayOutput3 = "Task Name: Create Reports" 
                // + "\nTask number: " + assignedTaskNumber.get(i)
                + "\nDeveloper: Samantha Paulson"
                + "\nTask ID: CR:3:SON" 
                + "\nDuration: 8" 
                + "\nStatus: Done";
        
        String expectedDisplayOutput4 = "Task Name: Add Arrays" 
                // + "\nTask number: " + assignedTaskNumber.get(i)
                + "\nDeveloper: Glenda Oberholzer"
                + "\nTask ID: AD:4:ZER" 
                + "\nDuration: 11" 
                + "\nStatus: To Do";*/
        
        
        
        assertEquals(expectedDisplayOutput, t1.displayAllTasks());
    }
    
}
  

    

