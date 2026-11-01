
package pl.polsl.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pl.polsl.exceptions.InvalidModelException;

/**
 * Represents an application user who can participate in projects and issues.
 *
 * @author Oleksandr Holobokov
 * @version 1.1
 */
public class User {

    /** User identifier. */
    private final long id;
    /** Unique username. */
    private String username;
    /** User's full name. */
    private String fullName;
    /** Optional user email address. */
    private String email;
    /** Projects assigned to the user. */
    private List<Project> projects;
    /** Issues reported by the user. */
    private List<Issue> reportedIssues;
    /** Issues assigned to the user. */
    private List<Issue> assignedIssues;
    /** Comments authored by the user. */
    private List<Comment> comments;

    /**
     * Creates a user from builder values.
     *
     * @param builder source of the user values
     */
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
    
    /**
     * Associates the user with a project.
     *
     * @param project project to assign to the user
     */
    public void assignToProject(Project project) {
        if (project != null) {
            projects.add(project);
        }
    }
    
    /**
     * Records an issue reported by this user.
     *
     * @param issue issue reported by the user
     */
    public void reportIssue(Issue issue) {
        if (issue != null) {
            reportedIssues.add(issue);
            issue.setReporter(this);
        }
    }

    /**
     * Returns the user identifier.
     *
     * @return user identifier
     */
    public long getId() {
        return id;
    }

    /**
     * Returns the username.
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Updates the username.
     *
     * @param username new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the user's full name.
     *
     * @return full name
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Updates the user's full name.
     *
     * @param fullName new full name
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Returns the user's email address.
     *
     * @return email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Updates the user's email address.
     *
     * @param email new email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns an unmodifiable view of the user's projects.
     *
     * @return user projects
     */
    public List<Project> getProjects() {
        return Collections.unmodifiableList(projects);
    }

    /**
     * Replaces the user's projects with a defensive copy.
     *
     * @param projects replacement projects, or {@code null} for an empty list
     */
    public void setProjects(List<Project> projects) {
        this.projects = projects == null ? new ArrayList<>() : new ArrayList<>(projects);
    }

    /**
     * Returns an unmodifiable view of the user's reported issues.
     *
     * @return reported issues
     */
    public List<Issue> getReportedIssues() {
        return Collections.unmodifiableList(reportedIssues);
    }

    /**
     * Replaces reported issues with a defensive copy.
     *
     * @param reportedIssues replacement issues, or {@code null} for an empty list
     */
    public void setReportedIssues(List<Issue> reportedIssues) {
        this.reportedIssues = reportedIssues == null
                ? new ArrayList<>() : new ArrayList<>(reportedIssues);
    }

    /**
     * Returns an unmodifiable view of the user's assigned issues.
     *
     * @return assigned issues
     */
    public List<Issue> getAssignedIssues() {
        return Collections.unmodifiableList(assignedIssues);
    }

    /**
     * Replaces assigned issues with a defensive copy.
     *
     * @param assignedIssues replacement issues, or {@code null} for an empty list
     */
    public void setAssignedIssues(List<Issue> assignedIssues) {
        this.assignedIssues = assignedIssues == null
                ? new ArrayList<>() : new ArrayList<>(assignedIssues);
    }

    /**
     * Returns an unmodifiable view of the user's comments.
     *
     * @return user comments
     */
    public List<Comment> getComments() {
        return Collections.unmodifiableList(comments);
    }

    /**
     * Replaces comments with a defensive copy.
     *
     * @param comments replacement comments, or {@code null} for an empty list
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments == null ? new ArrayList<>() : new ArrayList<>(comments);
    }

    /**
     * Creates an empty user builder.
     *
     * @return new user builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds validated user instances using a fluent API.
     *
     * @author Oleksandr Holobokov
     * @version 1.1
     */
    public static class Builder {

        /**
         * Creates an empty user builder.
         */
        public Builder() {
        }

        /** User identifier being built. */
        private long id;
        /** Username being built. */
        private String username;
        /** Full name being built. */
        private String fullName;
        /** Email being built. */
        private String email;
        /** Projects being built. */
        private List<Project> projects = new ArrayList<>();
        /** Reported issues being built. */
        private List<Issue> reportedIssues = new ArrayList<>();
        /** Assigned issues being built. */
        private List<Issue> assignedIssues = new ArrayList<>();
        /** Comments being built. */
        private List<Comment> comments = new ArrayList<>();

        /**
         * Sets the user identifier.
         *
         * @param id user identifier
         * @return this builder
         */

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the username.
         *
         * @param username username
         * @return this builder
         */
        public Builder username(String username) {
            this.username = username;
            return this;
        }

        /**
         * Sets the full name.
         *
         * @param fullName full name
         * @return this builder
         */
        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        /**
         * Sets the email address.
         *
         * @param email email address
         * @return this builder
         */
        public Builder email(String email) {
            this.email = email;
            return this;
        }

        /**
         * Adds a non-null project.
         *
         * @param project project to add
         * @return this builder
         */
        public Builder addProject(Project project) {
            if (project != null) {
                projects.add(project);
            }
            return this;
        }

        /**
         * Adds a non-null reported issue.
         *
         * @param issue issue to add
         * @return this builder
         */
        public Builder addReportedIssue(Issue issue) {
            if (issue != null) {
                reportedIssues.add(issue);
            }
            return this;
        }

        /**
         * Adds a non-null assigned issue.
         *
         * @param issue issue to add
         * @return this builder
         */
        public Builder addAssignedIssue(Issue issue) {
            if (issue != null) {
                assignedIssues.add(issue);
            }
            return this;
        }

        /**
         * Adds a non-null comment.
         *
         * @param comment comment to add
         * @return this builder
         */
        public Builder addComment(Comment comment) {
            if (comment != null) {
                comments.add(comment);
            }
            return this;
        }

        /**
         * Validates the configured values and creates a user.
         *
         * @return validated user
         * @throws InvalidModelException if a required value is missing
         */
        public User build() {
            if (username == null || username.isBlank()) {
                throw new InvalidModelException("Pole username nie może być puste");
            }
            if (fullName == null || fullName.isBlank()) {
                throw new InvalidModelException("Pole fullName nie może być puste");
            }
            return new User(this);
        }
    }

    /**
     * Returns a textual representation of the user.
     *
     * @return user description
     */
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
