package pl.polsl.controller;


import java.util.Scanner;
import pl.polsl.enums.Priority;
import pl.polsl.enums.IssueStatus;
import pl.polsl.model.Issue;
import pl.polsl.model.Project;
import pl.polsl.model.User;
import pl.polsl.view.MainView;



public class MainController {
    
    private MainView view;
    private Scanner scanner;
    
    public MainController(MainView view, Scanner scanner) {
        this.view = view;
        this.scanner = scanner;
    }
    
    public User createUser() {
        view.user();
        
        view.askForId();
        long id = scanner.nextLong();
        scanner.nextLine();
        
        view.askForUsername();
        String username = scanner.nextLine().trim();
        
        view.askForUserFullName();
        String userFullName = scanner.nextLine().trim();
        
        return new User.Builder()
                .id(id)
                .username(username)
                .fullName(userFullName)
                .build();
    }
    
    public Project createProject() {
        view.project();
        
        view.askForId();
        long id = scanner.nextLong();
        scanner.nextLine();
        
        view.askForProjectKey();
        String key = scanner.nextLine().trim();
        
        view.askForProjectName();
        String name = scanner.nextLine().trim();
        
        return new Project.Builder()
                .id(id)
                .key(key)
                .name(name)
                .build();
    }
    
    public Issue createIssue() {
        view.issue();
        
        view.askForId();
        long id = scanner.nextLong();
        scanner.nextLine();
        
        view.askForIssueName();
        String taskName = scanner.nextLine().trim();
        
        view.askForIssueKey();
        String issueKey = scanner.nextLine().trim();
        
        view.askForPriority();
        view.askForStatus();
        
        view.askForProjectKey();
        
        
        return new Issue.Builder()
                .id(id)
                .issueKey(issueKey)
                .title(taskName)
                .build();
    }
}