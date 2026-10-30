/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.view;

import pl.polsl.model.Issue;

/**
 *
 * @author holobokov
 */
public class MainView {
    public MainView() {}

    public void askForTaskName() {
        System.out.print("Podaj nazwę zadania: ");
    }
    
    public void askForPriority() {
        System.out.print("Podaj priorytet zadania: ");
    }
    
    public void askForStatus() {
        System.out.print("Podaj status zadania (domyślnie TO-DO): ");
    }

    public void askForUserFirstName() {
        System.out.print("Podaj imię użytkownika: ");
    }

    public void askForUserLastName() {
        System.out.print("Podaj nazwisko użytkownika: ");
    }
    
    public void printTask(Issue task) {
        System.out.println(task.toString());
    }
}
