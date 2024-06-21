package poe_end_of_year;

import javax.swing.JOptionPane;
import java.util.*;

//Task = class name that holds all the variables and constructors 
//Tasks = main method that holds the whole code
class Task {

    public int taskNumber;
    public String taskName;
    public String taskDescription;
    public int taskDuration;
    public String taskStatus;
    public String developerName;
    public String taskId;
    public static int taskCounter = 0;

    //non-default constructer
    public Task(String taskName, int taskNumber, String taskDescription, int taskDuration, String taskStatus, String developerName) {

        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.developerName = developerName;
        this.taskId = generateTaskId();
    }

    //default constructer
    public Task() {

    }

    public String generateTaskId() {

        String taskId = taskName.substring(0, 2).toUpperCase() + ":" + taskCounter + ":"
                + developerName.substring(developerName.length() - 3).toUpperCase();
        taskCounter++;

        return taskId;
    }

    /*public String displayInfo() {
        return "\nTask Name: " + taskName
                + "\nTask /number: " + taskNumber
                + "\nDescription: " + taskDescription
                + "\nDeveloper: " + developerName
                + "\nDuration: " + taskDuration + " hours "
                + "\nTask ID: " + taskId
                + "\nStatus: " + taskStatus;
    }*/
}

public class Tasks {

    public List<String> assignedDeveloperNames = new ArrayList<>();
    public List<String> assignedTaskNames = new ArrayList<>();
    public List<String> assignedTaskNumber = new ArrayList<>();
    public List<String> assignedTaskID = new ArrayList<>();
    public List<Integer> assignedDurations = new ArrayList<>();
    public List<String> assignedStatus = new ArrayList<>();

    public void startTasks() {
        JOptionPane.showMessageDialog(null, "Welcome to Easy Kanban");

        while (true) {
            String message = """
                             Choose an option:
                             1. Add tasks
                             2. Show report
                             3. Quit""";
            String input = JOptionPane.showInputDialog(null, message, "Easy Kanban", JOptionPane.PLAIN_MESSAGE);

            if (input == null) {
                JOptionPane.showMessageDialog(null, "Exiting...");
                System.exit(0);
            }

            try {
                int choice = Integer.parseInt(input);

                switch (choice) {
                    case 1:
                        addTasks();
                        break;
                    case 2:
                        showReport();
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Exiting...");
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid option");
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid option");
            }
        }
    }

    public void addTasks() {

        int taskCounter = 0;

        String input = JOptionPane.showInputDialog("How many tasks do you want to add?");
        int numberOfTasks;

        try {
            numberOfTasks = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid. Returning to menu.");
            return;
        }

        for (int taskNumber = 0; taskNumber < numberOfTasks; taskNumber++) {
            String taskName = JOptionPane.showInputDialog("Enter the task name:");
            assignedTaskNames.add(taskName);

            String taskDescription;

            while (true) {
                taskDescription = JOptionPane.showInputDialog("Enter the task description (max 50 words):");
                if (checkTaskDescription(taskDescription)) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 words.");
                }
            }

            input = JOptionPane.showInputDialog("Enter the duration of the task in hours:");
            int taskDuration;

            while (true) {
                try {
                    taskDuration = Integer.parseInt(input);
                    if (taskDuration <= 0) {
                        JOptionPane.showMessageDialog(null, "Invalid duration. Please enter a positive integer.");
                        input = JOptionPane.showInputDialog("Enter the hours again: ");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid duration. Returning to menu.");
                    return;
                }
            }
            assignedDurations.add(taskDuration);

            String[] statusOptions = {"To do", "Doing", "Done"};
            String taskStatus = (String) JOptionPane.showInputDialog(null, "Select the status of the task:", "Task Status",
                    JOptionPane.PLAIN_MESSAGE, null, statusOptions, statusOptions[0]);
            assignedStatus.add(taskStatus);

            String developerName;
            while (true) {
                developerName = JOptionPane.showInputDialog("Enter the developer's full name thats more than 4 characters: ");
                if (validDeveloperName(developerName)) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid details");
                }
            }
            assignedDeveloperNames.add(developerName);

            int taskNumbers = taskNumber + 1;
            //assignedTaskNumber.addAll(taskNumber, assignedTaskNumber);

            Task tasksEntered = new Task(taskName, taskNumbers, taskDescription, taskDuration, taskStatus, developerName);
            assignedTaskID.add(tasksEntered.taskId); // Use the generated task ID from the Task object

            JOptionPane.showMessageDialog(null, "Task successfully captured.\n" + printTaskDetails(tasksEntered));

            //taskCounter++;
        }

        //JOptionPane.showMessageDialog(null, "Task number: " + taskCounter);
        JOptionPane.showMessageDialog(null, "Total hours: " + returnTotalHours());

    }

    public static boolean checkTaskDescription(String taskDescription) {

        return taskDescription.split("\\s+").length <= 50;

    }

    public String printTaskDetails(Task tasks) {

        return "\nTask Name: " + tasks.taskName
                + "\nTask Number: " + tasks.taskNumber
                + "\nDescription: " + tasks.taskDescription
                + "\nDeveloper: " + tasks.developerName
                + "\nDuration in hours: " + tasks.taskDuration
                + "\nTask ID: " + tasks.taskId
                + "\nStatus: " + tasks.taskStatus;
    }

    public int returnTotalHours() {
        int totalHours = 0;
        for (int duration : assignedDurations) {
            totalHours += duration;
        }
        return totalHours;
    }

    public void showReport() {

        String reportDisplay = """
                               Choose what information you would like to see: 
                               1. See which developers are assigned to a task and the task names and durations of all the tasks that are done
                               2. See the developer and the task with the longest duration
                               3. Search for a task by name and see the developer, the task name and the task status
                               4. Search for all tasks assigned to a developer and show the name of the task and its status
                               5. Choose this option if you want to delete a task
                               6. Display a report that shows the full list of details of each task
                               7. Exit back to main menu
                               """;

        for (int a = 0; a < 10; a++) {

            String option = JOptionPane.showInputDialog(null, reportDisplay, JOptionPane.QUESTION_MESSAGE);
            switch (Integer.parseInt(option)) {
                case 1:
                    JOptionPane.showMessageDialog(null, showTasksByStatus("Done"));
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, showTaskWithLongestDuration());
                    //showTaskWithLongestDuration();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, searchTaskByName());
                    //searchTaskByName();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, searchTasksByDeveloper());
                    //searchTasksByDeveloper();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, deleteTask());
                    //deleteTask();
                    break;
                case 6:
                    //JOptionPane.showMessageDialog(null, displayAllTasks());
                    displayAllTasks();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option");
                    break;
            }

        }

    }

    public String showTasksByStatus(String status) {

        for (int i = 0; i < assignedStatus.size(); i++) {
            if (assignedStatus.get(i).equals(status)) {
                return "Task name: " + assignedTaskNames.get(i)
                        + "\nDeveloper: " + assignedDeveloperNames.get(i)
                        + "\nDuration: " + assignedDurations.get(i);
            }
        }

        return "Task not found";
    }

    public String showTaskWithLongestDuration() {

        int maxDurations = 0;
        int maxIndex = 0;
        for (int i = 0; i < assignedDurations.size(); i++) {
            if (assignedDurations.get(i) > maxDurations) {
                maxDurations = assignedDurations.get(i);
                maxIndex = i;
            }
        }
        return "Developer: " + assignedDeveloperNames.get(maxIndex)
                + "\nDuration: "
                + maxDurations + " hours";

        //return maxDurations;
    }

    public String searchTaskByName() {

        String searchTaskName = JOptionPane.showInputDialog("Enter the task name you want to see:");

        for (int i = 0; i < assignedTaskNames.size(); i++) {

            if (assignedTaskNames.get(i).equals(searchTaskName)) {

                return "Task Name: " + assignedTaskNames.get(i)
                        + "\nDeveloper: " + assignedDeveloperNames.get(i)
                        + "\nTask Status: " + assignedStatus.get(i);
            }
        }

        return "Task name or task not found";
    }

    public String searchTasksByDeveloper() {

        /*String developerName = "";
        
        String result = "";
        for (int i = 0; i < assignedDeveloperNames.size(); i++) {
            if (assignedDeveloperNames.get(i).equals(developerName)) {
                result += "Task Name: " + assignedTaskNames.get(i) + "\n";
                result += "Task Status: " + assignedStatus.get(i) + "\n";
            }
        }
        return result;*/

        String searchedDN = JOptionPane.showInputDialog("Enter the developer's name you want to see");
        
        
        for (int i = 0; i < assignedDeveloperNames.size(); i++) {
            
            if (assignedDeveloperNames.get(i).equals(searchedDN)) {
                
                return "Developer: " + assignedDeveloperNames.get(i)
                        + "\nTask Name: " + assignedTaskNames.get(i)
                        + "\nTask Status: " + assignedStatus.get(i);
            }/*else{
                
                JOptionPane.showInputDialog("Please enter the correct developers name: ");

            }*/
        }
        return "Developer name not found";
    }

    public String deleteTask() {

        String deleteTask = JOptionPane.showInputDialog("Enter the task name you want to delete");

        for (int i = 0; i < assignedTaskNames.size(); i++) {

            if (assignedTaskNames.get(i).equals(deleteTask)) {
                assignedTaskNames.remove(i);
                //assignedTaskNumber.remove(i);
                assignedDeveloperNames.remove(i);
                assignedDurations.remove(i);
                assignedTaskID.remove(i);
                assignedStatus.remove(i);
                return "Task deleted successfully";

            } /*else {
                while (true) {

                }

            }*/
        }
        return "Task not found";

    }

    /*public void displayAllTasks() {
        
        for (int i = 0; i < assignedTaskNames.size(); i++) {
            
            String taskInfo = "Task Name: " + assignedTaskNames.get(i)
                    + "\nDeveloper: " + assignedDeveloperNames.get(i)
                    + "\nTask ID: " + assignedTaskID.get(i)
                    + "\nDuration: " + assignedDurations.get(i)
                    + "\nStatus: " + assignedStatus.get(i);
            JOptionPane.showMessageDialog(null, taskInfo);
        }
    }*/

    public String displayAllTasks() {
        
        for (int i = 0; i < assignedTaskNames.size(); i++) {
            return "Task Name: " + assignedTaskNames.get(i)
                   // + "\nTask number: " + assignedTaskNumber.get(i)
                    + "\nDeveloper: " + assignedDeveloperNames.get(i)
                    + "\nTask ID: " + assignedTaskID.get(i)
                    + "\nDuration: " + assignedDurations.get(i)
                    + "\nStatus: " + assignedStatus.get(i);
            
        }
        return "Task not found";
    }
    public boolean validDeveloperName(String developerName) {

        if (developerName.trim().isEmpty() || developerName.trim().isBlank()) {
            return false;
        }
        return developerName.matches("[a-zA-Z\\s]+");
    }

    /*public boolean correctDeletedTask(String deletedTask){
        
        if(deletedTask.matches(assignedTaskNames)){
            
        }
        
    }*/
}

//https://www.naukri.com/code360/library/remove-an-element-from-an-array-in-java this for the deletion method
//https://stackoverflow.com/questions/13570694/how-do-you-call-upon-an-array and 
//https://stackoverflow.com/questions/43823191/trying-to-print-arrays-in-java-need-assistancefor the arrays
//https://stackoverflow.com/questions/69892165/what-are-the-steps-to-writing-a-junit-test-for-methods-with-arrays published 2022
