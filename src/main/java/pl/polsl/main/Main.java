
package pl.polsl.main;

import java.util.Scanner;
import pl.polsl.controller.MainController;
import pl.polsl.model.Issue;
import pl.polsl.model.Project;
import pl.polsl.model.User;
import pl.polsl.view.MainView;

public class Main {

    public static void main(String[] args) {
        MainView view = new MainView();
        Scanner scanner = new Scanner(System.in);
        MainController controller = new MainController(view, scanner);
        
        User user = controller.createUser();
        Project project = controller.createProject();
        Issue issue = controller.createIssue();
        
        user.assignToProject(project);
        user.reportIssue(issue);
        project.addIssue(issue);
       
        view.printUser(user);
        view.printProject(project);
        view.printIssue(issue);
    }
}
