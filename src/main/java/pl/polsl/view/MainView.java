
package pl.polsl.view;

import pl.polsl.model.Issue;
import pl.polsl.model.Project;
import pl.polsl.model.User;

/**
 * Provides console prompts and output for the application.
 *
 * @author Oleksandr Holobokov
 * @version 1.1
 */
public class MainView {

    /**
     * Creates the console view.
     */
    public MainView() {}
    
    /**
     * Prints the user section heading.
     */
    public void user() {
        System.out.println("======================= USER =======================");
    }
    
    /**
     * Prints the project section heading.
     */
    public void project() {
        System.out.println("======================= PROJECT =======================");
    }
    
    /**
     * Prints the issue section heading.
     */
    public void issue() {
        System.out.println("======================= ISSUE =======================");
    }
    
    /**
     * Prompts for an identifier.
     */
    public void askForId() {
        System.out.print("Podaj id: ");
    }

    /**
     * Prompts for an issue key.
     */
    public void askForIssueKey() {
        System.out.print("Podaj issue key: ");
    }
    
    /**
     * Prompts for a project key.
     */
    public void askForProjectKey() {
        System.out.print("Podaj project key: ");
    }
    
    /**
     * Prompts for a project name.
     */
    public void askForProjectName() {
        System.out.print("Podaj nazwę projektu: ");
    }
    
    /**
     * Prompts for an issue title.
     */
    public void askForIssueName() {
        System.out.print("Podaj nazwę zadania: ");
    }
    
    /**
     * Prompts for an issue priority.
     */
    public void askForPriority() {
        System.out.print("Podaj priorytet zadania: ");
    }
    
    /**
     * Prompts for an issue status.
     */
    public void askForStatus() {
        System.out.print("Podaj status zadania (domyślnie TO-DO): ");
    }

    /**
     * Prompts for a user's full name.
     */
    public void askForUserFullName() {
        System.out.print("Podaj pełne imię użytkownika: ");
    }
    
    /**
     * Prompts for a username.
     */
    public void askForUsername() {
        System.out.print("Podaj nazwę użytkownika: ");
    }
    
    /**
     * Prints user data.
     *
     * @param user user to print
     */
    public void printUser(User user) {
        System.out.println("\n\n USER DATA");
        System.out.println(user.toString());
    }
    
    /**
     * Prints project data.
     *
     * @param project project to print
     */
    public void printProject(Project project) {
        System.out.println("\n\n PROJECT DATA");
        System.out.println(project.toString());
    }
    
    /**
     * Prints issue data.
     *
     * @param issue issue to print
     */
    public void printIssue(Issue issue) {
        System.out.println("\n\n ISSUE DATA");
        System.out.println(issue.toString());
    }

    /**
     * Prints an error message.
     *
     * @param message error message
     */
    public void showError(String message) {
        System.err.println("Błąd: " + message);
    }
}
