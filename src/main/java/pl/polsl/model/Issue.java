
package pl.polsl.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pl.polsl.enums.IssueStatus;
import pl.polsl.enums.Priority;
import pl.polsl.exceptions.InvalidModelException;

/**
 * Represents an issue tracked in a project.
 *
 * @author Oleksandr Holobokov
 * @version 1.1
 */
public class Issue {

    /** The numeric issue identifier. */
    private final long id;
    /** The human-readable issue key. */
    private final String issueKey;
    /** The issue title. */
    private String title;
    /** The optional issue description. */
    private String description;
    /** The current issue status. */
    private IssueStatus status;
    /** The issue priority. */
    private Priority priority;
    /** The project containing this issue. */
    private Project project;
    /** The user who reported this issue. */
    private User reporter;
    /** The user assigned to this issue. */
    private User assignee;
    /** The comments associated with this issue. */
    private List<Comment> comments;

    /**
     * Creates an issue from builder values.
     *
     * @param builder source of the issue values
     */
    private Issue(Builder builder) {
        this.id = builder.id;
        this.issueKey = builder.issueKey;
        this.title = builder.title;
        this.description = builder.description;
        this.status = builder.status;
        this.priority = builder.priority;
        this.project = builder.project;
        this.reporter = builder.reporter;
        this.assignee = builder.assignee;
        this.comments = new ArrayList<>(builder.comments);
    }
    
    /**
     * Associates the issue with a project when a non-null project is supplied.
     *
     * @param project project to associate with the issue
     */
    void setProject(Project project) {
        if (project != null) this.project = project;
    }
    
    /**
     * Sets the user who reported the issue when a non-null user is supplied.
     *
     * @param user reporting user
     */
    void setReporter(User user) {
        if (user != null) reporter = user;
    }

    /**
     * Returns the issue identifier.
     *
     * @return issue identifier
     */
    public long getId() {
        return id;
    }

    /**
     * Returns the issue key.
     *
     * @return issue key
     */
    public String getIssueKey() {
        return issueKey;
    }

    /**
     * Returns the issue title.
     *
     * @return issue title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Updates the issue title.
     *
     * @param title new issue title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the issue description.
     *
     * @return issue description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Updates the issue description.
     *
     * @param description new issue description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the current issue status.
     *
     * @return issue status
     */
    public IssueStatus getStatus() {
        return status;
    }

    /**
     * Updates the issue status.
     *
     * @param status new issue status
     */
    public void setStatus(IssueStatus status) {
        this.status = status;
    }

    /**
     * Returns the issue priority.
     *
     * @return issue priority
     */
    public Priority getPriority() {
        return priority;
    }

    /**
     * Updates the issue priority.
     *
     * @param priority new issue priority
     */
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    /**
     * Returns the project containing the issue.
     *
     * @return issue project
     */
    public Project getProject() {
        return project;
    }

    /**
     * Returns the reporting user.
     *
     * @return reporting user
     */
    public User getReporter() {
        return reporter;
    }

    /**
     * Returns the assigned user.
     *
     * @return assigned user
     */
    public User getAssignee() {
        return assignee;
    }

    /**
     * Assigns the issue to a user.
     *
     * @param assignee user assigned to the issue
     */
    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    /**
     * Returns an unmodifiable view of the issue comments.
     *
     * @return unmodifiable issue comments
     */
    public List<Comment> getComments() {
        return Collections.unmodifiableList(comments);
    }

    /**
     * Replaces the issue comments with a defensive copy.
     *
     * @param comments replacement comments, or {@code null} for an empty list
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments == null ? new ArrayList<>() : new ArrayList<>(comments);
    }

    /**
     * Creates an empty issue builder.
     *
     * @return new issue builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds validated issue instances using a fluent API.
     *
     * @author Oleksandr Holobokov
     * @version 1.1
     */
    public static class Builder {

        /**
         * Creates an empty issue builder.
         */
        public Builder() {
        }

        /** Issue identifier being built. */
        private long id;
        /** Issue key being built. */
        private String issueKey;
        /** Issue title being built. */
        private String title;
        /** Issue description being built. */
        private String description;
        /** Issue status being built. */
        private IssueStatus status;
        /** Issue priority being built. */
        private Priority priority;
        /** Issue project being built. */
        private Project project;
        /** Issue reporter being built. */
        private User reporter;
        /** Issue assignee being built. */
        private User assignee;
        /** Issue comments being built. */
        private List<Comment> comments = new ArrayList<>();

        /**
         * Sets the issue identifier.
         *
         * @param id issue identifier
         * @return this builder
         */

        public Builder id(long id) {
            this.id = id;
            return this;
        }
        
        /**
         * Sets the issue key.
         *
         * @param issueKey issue key
         * @return this builder
         */
        public Builder issueKey(String issueKey) {
            this.issueKey = issueKey;
            return this;
        }
        
        /**
         * Sets the issue title.
         *
         * @param title issue title
         * @return this builder
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }
        
        /**
         * Sets the issue description.
         *
         * @param description issue description
         * @return this builder
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }
        
        /**
         * Sets the issue status.
         *
         * @param status issue status
         * @return this builder
         */
        public Builder status(IssueStatus status) {
            this.status = status;
            return this;
        }
        
        /**
         * Sets the issue priority.
         *
         * @param priority issue priority
         * @return this builder
         */
        public Builder priority(Priority priority) {
            this.priority = priority;
            return this;
        }
        
        /**
         * Sets the issue project.
         *
         * @param project issue project
         * @return this builder
         */
        public Builder project(Project project) {
            this.project = project;
            return this;
        }
        
        /**
         * Sets the issue reporter.
         *
         * @param reporter issue reporter
         * @return this builder
         */
        public Builder reporter(User reporter) {
            this.reporter = reporter;
            return this;
        }
        
        /**
         * Sets the issue assignee.
         *
         * @param assignee assigned user
         * @return this builder
         */
        public Builder assignee(User assignee) {
            this.assignee = assignee;
            return this;
        }

        /**
         * Adds a non-null comment to the issue.
         *
         * @param comment comment to add
         * @return this builder
         */
        public Builder addComment(Comment comment) {
            if (comment != null) {
                this.comments.add(comment);
            }
            return this;
        }

        /**
         * Validates the configured values and creates an issue.
         *
         * @return validated issue
         * @throws InvalidModelException if a required value is missing
         */
        public Issue build() {
            if (issueKey == null || issueKey.isBlank()) {
                throw new InvalidModelException("Pole issueKey nie może być puste");
            }
            if (title == null || title.isBlank()) {
                throw new InvalidModelException("Pole title nie może być puste");
            }
            if (status == null) {
                status = IssueStatus.TO_DO;
            }
            if (priority == null) {
                priority = Priority.LOW;
            }
            return new Issue(this);
        }
    }

    /**
     * Returns a textual representation of the issue.
     *
     * @return issue description
     */
    @Override
    public String toString() {
        return "Issue{"
                + "id=" + id
                + ", issueKey='" + issueKey + '\''
                + ", title='" + title + '\''
                + ", status=" + status
                + ", priority=" + priority
                + ", project=" + (project == null ? "brak" : project.getName())
                + ", reporter=" + (reporter == null ? "brak" : reporter)
                + ", assignee=" + (assignee == null ? "brak" : assignee)
                + '}';
    }
}
