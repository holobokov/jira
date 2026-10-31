
package pl.polsl.view;

import pl.polsl.model.Issue;
import pl.polsl.model.Project;
import pl.polsl.model.User;

public class MainView {
    public MainView() {}
    
    public void user() {
        System.out.println("======================= USER =======================");
    }
    
    public void project() {
        System.out.println("======================= PROJECT =======================");
    }
    
    public void issue() {
        System.out.println("======================= ISSUE =======================");
    }
    
    public void askForId() {
        System.out.print("Podaj id: ");
    }

    public void askForIssueKey() {
        System.out.print("Podaj issue key: ");
    }
    
    public void askForProjectKey() {
        System.out.print("Podaj project key: ");
    }
    
    public void askForProjectName() {
        System.out.print("Podaj nazwę projektu: ");
    }
    
    public void askForIssueName() {
        System.out.print("Podaj nazwę zadania: ");
    }
    
    public void askForPriority() {
        System.out.print("Podaj priorytet zadania: ");
    }
    
    public void askForStatus() {
        System.out.print("Podaj status zadania (domyślnie TO-DO): ");
    }

    public void askForUserFullName() {
        System.out.print("Podaj pełne imię użytkownika: ");
    }
    
    public void askForUsername() {
        System.out.print("Podaj nazwę użytkownika: ");
    }
    
    public void printUser(User user) {
        System.out.println("\n\n USER DATA");
        System.out.println(user.toString());
    }
    
    public void printProject(Project project) {
        System.out.println("\n\n PROJECT DATA");
        System.out.println(project.toString());
    }
    
    public void printIssue(Issue issue) {
        System.out.println("\n\n ISSUE DATA");
        System.out.println(issue.toString());
    }
}
