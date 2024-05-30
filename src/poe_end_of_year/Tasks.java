package poe_end_of_year;

import javax.swing.JOptionPane;

class Task {
    
    public String taskName;
    public String taskDescription;
    public int taskDuration;
    public String taskStatus;
    public String developerName;
    public String taskId;
    public static int taskCounter = 0;
    
    //non-default constructer
    public Task(String taskName, String taskDescription, int taskDuration, String taskStatus, String developerName) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.developerName = developerName;
        this.taskId = generateTaskId();
    }
    
    //default constructer
    public Task()
    {
    
    }
    
    public String generateTaskId() {
        
        String taskId = taskName.substring(0, 2).toUpperCase() + ":" + taskCounter + ":" + 
                         developerName.substring(developerName.length() - 3).toUpperCase();
        taskCounter++;
        return taskId;
    }

    @Override
    public String toString() {
        return "Task ID: " + taskId + "\nTask Name: " + taskName + 
                 "\nDescription: " + taskDescription + "\nDuration: " + taskDuration + 
                  " hours\nStatus: " + taskStatus + "\nDeveloper: " + developerName;
    }
}

public class Tasks {

    public void startTasks() {
          
      JOptionPane.showMessageDialog(null, "Welcome to Easy Kanban");
      
        while (true) {
           String[] options = {"1.Add tasks", 
                                "2.Show report", 
                                "3.Quit"};
            
            int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "Easy Kanban",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

           switch (choice) {
                case 0:
                    
                    addTasks();
                    
                    break;
                case 1:
                    
                    JOptionPane.showMessageDialog(null, "Coming soon");
                    
                    break;
                case 2:
                    
                    JOptionPane.showMessageDialog(null, "Exiting...");
                    System.exit(0);
                    
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option");
                    break;
            }
        }
    }

    public void addTasks() {
    String input = JOptionPane.showInputDialog("How many tasks do you want to add?");
    int numberOfTasks;
    
    try {
        numberOfTasks = Integer.parseInt(input);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Invalid number. Returning to menu.");
        return;
    }

    Task[] tasks = new Task[numberOfTasks];

    for (int i = 0; i < numberOfTasks; i++) {
        String taskName = JOptionPane.showInputDialog("Enter the task name:");

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
        
        try {
            taskDuration = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid duration. Returning to menu.");
            return;
        }

        String[] statusOptions = {"To do", 
                                   "Doing", 
                                    "Done"};
        
        String taskStatus = (String) JOptionPane.showInputDialog(null, "Select the status of the task:", "Task Status", 
                             JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]);

        String developerName = JOptionPane.showInputDialog("Enter the developer's full name:");
        
        Task task = new Task(taskName, taskDescription, taskDuration, taskStatus, developerName);
        tasks[i] = task;
        JOptionPane.showMessageDialog(null, "Task successfully captured.\n" + printTaskDetails(task));
    }
    
        JOptionPane.showMessageDialog(null, "Total hours: " + returnTotalHours(tasks));
}
    
    public static boolean checkTaskDescription(String taskDescription) {
        
        return taskDescription.split("\\s+").length <= 50;
    }

    public String createTaskID(String taskName, String developerName) {
        
        return taskName.substring(0, 2).toUpperCase() + ":" + Task.taskCounter + ":" + 
               developerName.substring(developerName.length() - 3).toUpperCase();
    }

    public String printTaskDetails(Task task) {
        
        return "Task ID: " + task.taskId + "\nTask Name: " + task.taskName + 
               "\nDescription: " + task.taskDescription + "\nDuration: " + task.taskDuration + 
                " hours\nStatus: " + task.taskStatus + "\nDeveloper: " + task.developerName;
    }

    public int returnTotalHours(Task[] tasks) {
        int totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.taskDuration;
        }
        return totalHours;
    }

    
}


