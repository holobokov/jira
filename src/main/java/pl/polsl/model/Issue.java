
package pl.polsl.model;

import pl.polsl.enums.Priority;
import pl.polsl.enums.IssueStatus;


public class Issue {
    
    private long id;
    private String issueKey;
    private String title;
    private String description;
    private IssueStatus status;
    private Priority priority;
    private User user;
    
    public Issue(String name, IssueStatus status, Priority priority, User user) {
        this.name = name;
        this.status = status;
        this.priority = priority;
        this.user = user;
    }
    
    @Override
    public String toString() {
        return "Task: " + name + ", Status: " + status + ", Priority: " + priority + ", User: " + user.toString() + "\n";
    }
}
