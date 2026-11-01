package pl.polsl.controller;


import java.util.Scanner;
import pl.polsl.enums.Priority;
import pl.polsl.enums.IssueStatus;
import pl.polsl.exceptions.InvalidModelException;
import pl.polsl.model.Issue;
import pl.polsl.model.Project;
import pl.polsl.model.User;
import pl.polsl.view.MainView;



/**
 * Coordinates console input, model construction, and application output.
 *
 * @author Oleksandr Holobokov
 * @version 1.1
 */
public class MainController {

    /** Number of command-line arguments required for non-interactive mode. */
    private final int commandLineArgumentsCount = 11;
    
    /** Application view used for prompts and output. */
    private final MainView view;
    /** Input source used by the interactive mode. */
    private final Scanner scanner;
    
    /**
     * Creates a controller.
     *
     * @param view application view
     * @param scanner input scanner
     */
    public MainController(MainView view, Scanner scanner) {
        this.view = view;
        this.scanner = scanner;
    }
    
    /**
     * Reads user data interactively and builds a user.
     *
     * @return created user
     * @throws InvalidModelException if entered data is invalid
     */
    public User createUser() {
        view.user();
        
        view.askForId();
        long id = scanner.nextLong();
        scanner.nextLine();
        
        view.askForUsername();
        String username = scanner.nextLine().trim();
        
        view.askForUserFullName();
        String userFullName = scanner.nextLine().trim();
        
        return User.builder()
                .id(id)
                .username(username)
                .fullName(userFullName)
                .build();
    }
    
    /**
     * Reads project data interactively and builds a project.
     *
     * @return created project
     * @throws InvalidModelException if entered data is invalid
     */
    public Project createProject() {
        view.project();
        
        view.askForId();
        long id = scanner.nextLong();
        scanner.nextLine();
        
        view.askForProjectKey();
        String key = scanner.nextLine().trim();
        
        view.askForProjectName();
        String name = scanner.nextLine().trim();
        
        return Project.builder()
                .id(id)
                .key(key)
                .name(name)
                .build();
    }
    
    /**
     * Reads issue data interactively, builds an issue, and creates its relations.
     *
     * @param project project receiving the issue
     * @param reporter user reporting the issue
     * @return created issue
     * @throws InvalidModelException if entered data is invalid
     */
    public Issue createIssue(Project project, User reporter) {
        view.issue();
        
        view.askForId();
        long id = scanner.nextLong();
        scanner.nextLine();
        
        view.askForIssueName();
        String taskName = scanner.nextLine().trim();
        
        view.askForIssueKey();
        String issueKey = scanner.nextLine().trim();
        
        view.askForPriority();
        Priority priority = readEnum(Priority.class, Priority.LOW);

        view.askForStatus();
        IssueStatus status = readEnum(IssueStatus.class, IssueStatus.TO_DO);
        
        Issue issue = Issue.builder()
                .id(id)
                .issueKey(issueKey)
                .title(taskName)
                .priority(priority)
                .status(status)
                .project(project)
                .reporter(reporter)
                .build();

        project.addIssue(issue);
        reporter.reportIssue(issue);

        return issue;
    }

    /**
     * Runs the application in command-line or interactive mode.
     *
     * @param args command-line arguments
     */
    public void run(String[] args) {
        try {
            if (args.length == commandLineArgumentsCount) {
                createFromArguments(args);
            } else {
                createInteractively();
            }
        } catch (InvalidModelException | IllegalArgumentException exception) {
            view.showError(exception.getMessage());
        }
    }

    /**
     * Creates all domain objects from interactive input.
     */
    private void createInteractively() {
        User user = createUser();
        Project project = createProject();
        Issue issue = createIssue(project, user);
        project.addMember(user);
        printResults(user, project, issue);
    }

    /**
     * Creates all domain objects from command-line arguments.
     *
     * @param args command-line arguments in the documented order
     * @throws InvalidModelException if an argument is invalid
     */
    private void createFromArguments(String[] args) {
        User user = User.builder()
                .id(parseId(args[0]))
                .username(args[1])
                .fullName(args[2])
                .build();

        Project project = Project.builder()
                .id(parseId(args[3]))
                .key(args[4])
                .name(args[5])
                .build();

        Issue issue = Issue.builder()
                .id(parseId(args[6]))
                .title(args[7])
                .issueKey(args[8])
                .priority(parseEnum(Priority.class, args[9]))
                .status(parseEnum(IssueStatus.class, args[10]))
                .build();
        project.addIssue(issue);
        project.addMember(user);
        user.reportIssue(issue);
        printResults(user, project, issue);
    }

    /**
     * Parses a numeric identifier.
     *
     * @param value textual identifier
     * @return parsed identifier
     * @throws InvalidModelException if the value is not numeric
     */
    private long parseId(String value) {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException exception) {
            throw new InvalidModelException("Id musi być liczbą całkowitą");
        }
    }

    /**
     * Parses an enum value from command-line input.
     *
     * @param <T> enum type
     * @param enumType enum class
     * @param value textual enum value
     * @return parsed enum value
     * @throws InvalidModelException if the value is invalid
     */
    private <T extends Enum<T>> T parseEnum(Class<T> enumType, String value) {
        try {
            return Enum.valueOf(enumType, value.toUpperCase().replace('-', '_'));
        } catch (IllegalArgumentException exception) {
            throw new InvalidModelException("Nieprawidłowa wartość " + value);
        }
    }

    /**
     * Displays the created domain objects.
     *
     * @param user created user
     * @param project created project
     * @param issue created issue
     */
    private void printResults(User user, Project project, Issue issue) {
        view.printUser(user);
        view.printProject(project);
        view.printIssue(issue);
    }

    /**
     * Reads an enum value interactively.
     *
     * @param <T> enum type
     * @param enumType enum class
     * @param defaultValue value used for empty input
     * @return parsed enum value or the default value
     */
    private <T extends Enum<T>> T readEnum(Class<T> enumType, T defaultValue) {
        String value = scanner.nextLine().trim()
                .toUpperCase()
                .replace('-', '_');
        return value.isEmpty() ? defaultValue : Enum.valueOf(enumType, value);
    }
}