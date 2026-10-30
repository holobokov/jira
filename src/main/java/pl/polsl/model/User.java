
package pl.polsl.model;


public class User {
    private String id;
    private String firstName;
    private String lastName;
    
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
