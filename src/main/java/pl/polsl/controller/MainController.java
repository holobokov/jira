package pl.polsl.controller;


import java.util.Scanner;
import pl.polsl.enums.Priority;
import pl.polsl.enums.IssueStatus;
import pl.polsl.model.Issue;
import pl.polsl.model.User;
import pl.polsl.view.MainView;



public class MainController {
    
    private MainView view;
    private Scanner scanner;
    
    public MainController(MainView view, Scanner scanner) {
        this.view = view;
        this.scanner = scanner;
    }
    
    public Issue createTask() {
        view.askForTaskName();
        String taskName = scanner.nextLine().trim();
        
        //view.askForPriority();
        
        
        view.askForUserFirstName();
        String userFirstName = scanner.nextLine().trim();
        
        view.askForUserLastName();
        String userLastName = scanner.nextLine().trim();
        
        return new Issue(taskName, IssueStatus.TO_DO, Priority.LOW, new User(userFirstName, userLastName));
    }
}