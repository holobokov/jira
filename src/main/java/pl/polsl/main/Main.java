
package pl.polsl.main;

import java.util.Scanner;
import pl.polsl.controller.MainController;
import pl.polsl.view.MainView;

/**
 * Starts the Jira console application.
 *
 * @author Oleksandr Holobokov
 * @version 1.1
 */
public class Main {

    /**
     * Creates the application entry-point object.
     */
    public Main() {
    }

    /**
     * Creates the MVC components and starts the controller.
     *
     * @param args command-line arguments in the documented order
     */
    public static void main(String[] args) {
        /*
         * Argument order:
         * 1. user id, 2. username, 3. full name,
         * 4. project id, 5. project key, 6. project name,
         * 7. issue id, 8. issue title, 9. issue key,
         * 10. priority, 11. status.
         * If the argument count differs from 11, data is read interactively.
         */
        MainView view = new MainView();
        Scanner scanner = new Scanner(System.in);
        MainController controller = new MainController(view, scanner);
        controller.run(args);
    }
}
