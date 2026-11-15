
package pl.polsl.main;

import javax.swing.SwingUtilities;

/**
 * Starts the Jira Swing application.
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
     * Starts the Swing window. Model objects are created by GUI actions.
     *
     * @param args command-line arguments in the documented order
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
