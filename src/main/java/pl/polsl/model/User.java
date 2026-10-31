
package pl.polsl.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pl.polsl.exceptions.InvalidIssueException;

public class User {

    private final long id;
    private String username;
    private String fullName;
    private String email;
    private List<Project> projects;
    private List<Issue> reportedIssues;
    private List<Issue> assignedIssues;
    private List<Comment> comments;

    private User(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.fullName = builder.fullName;
        this.email = builder.email;
        this.projects = new ArrayList<>(builder.projects);
        this.reportedIssues = new ArrayList<>(builder.reportedIssues);
        this.assignedIssues = new ArrayList<>(builder.assignedIssues);
        this.comments = new ArrayList<>(builder.comments);
    }
    
    public void assignToProject(Project project) {
        projects.add(project);
        project.addMember(this);
    }
    
    public void reportIssue(Issue issue) {
        reportedIssues.add(issue);
        issue.setReporter(this);
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Project> getProjects() {
        return Collections.unmodifiableList(projects);
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects == null ? new ArrayList<>() : new ArrayList<>(projects);
    }

    public List<Issue> getReportedIssues() {
        return Collections.unmodifiableList(reportedIssues);
    }

    public void setReportedIssues(List<Issue> reportedIssues) {
        this.reportedIssues = reportedIssues == null
                ? new ArrayList<>() : new ArrayList<>(reportedIssues);
    }

    public List<Issue> getAssignedIssues() {
        return Collections.unmodifiableList(assignedIssues);
    }

    public void setAssignedIssues(List<Issue> assignedIssues) {
        this.assignedIssues = assignedIssues == null
                ? new ArrayList<>() : new ArrayList<>(assignedIssues);
    }

    public List<Comment> getComments() {
        return Collections.unmodifiableList(comments);
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments == null ? new ArrayList<>() : new ArrayList<>(comments);
    }

    //Builder pattern

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private long id;
        private String username;
        private String fullName;
        private String email;
        private List<Project> projects = new ArrayList<>();
        private List<Issue> reportedIssues = new ArrayList<>();
        private List<Issue> assignedIssues = new ArrayList<>();
        private List<Comment> comments = new ArrayList<>();

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder addProject(Project project) {
            if (project != null) {
                projects.add(project);
            }
            return this;
        }

        public Builder addReportedIssue(Issue issue) {
            if (issue != null) {
                reportedIssues.add(issue);
            }
            return this;
        }

        public Builder addAssignedIssue(Issue issue) {
            if (issue != null) {
                assignedIssues.add(issue);
            }
            return this;
        }

        public Builder addComment(Comment comment) {
            if (comment != null) {
                comments.add(comment);
            }
            return this;
        }

        public User build() {
            if (username == null || username.isBlank()) {
                throw new InvalidIssueException("Pole username nie może być puste");
            }
            if (fullName == null || fullName.isBlank()) {
                throw new InvalidIssueException("Pole fullName nie może być puste");
            }
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", username='" + username + '\''
                + ", fullName='" + fullName + '\''
                + ", email='" + email + '\''
                + ", projects=" + projects.size()
                + ", reportedIssues=" + reportedIssues.size()
                + ", assignedIssues=" + assignedIssues.size()
                + '}';
    }
}
