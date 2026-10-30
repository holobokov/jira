
package pl.polsl.main;

import java.util.Scanner;
import pl.polsl.controller.MainController;
import pl.polsl.model.Issue;
import pl.polsl.view.MainView;

public class Main {

    public static void main(String[] args) {
        MainView view = new MainView();
        Scanner scanner = new Scanner(System.in);
        MainController controller = new MainController(view, scanner);
        Issue task = controller.createTask();
        view.printTask(task);
    }
}
