
package pl.polsl.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pl.polsl.enums.IssueStatus;
import pl.polsl.enums.Priority;
import pl.polsl.exceptions.InvalidIssueException;

public class Issue {

    private final long id;
    private final String issueKey;
    private String title;
    private String description;
    private IssueStatus status;
    private Priority priority;
    private Project project;
    private User reporter;
    private User assignee;
    private List<Comment> comments;

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
    
    public void setProject(Project project) {
        if (project != null) this.project = project;
    }
    
    public void setReporter(User user) {
        if (user != null) reporter = user;
    }

    public long getId() {
        return id;
    }

    public String getIssueKey() {
        return issueKey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public IssueStatus getStatus() {
        return status;
    }

    public void setStatus(IssueStatus status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Project getProject() {
        return project;
    }

    public User getReporter() {
        return reporter;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public List<Comment> getComments() {
        return Collections.unmodifiableList(comments);
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments == null ? new ArrayList<>() : new ArrayList<>(comments);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private long id;
        private String issueKey;
        private String title;
        private String description;
        private IssueStatus status;
        private Priority priority;
        private Project project;
        private User reporter;
        private User assignee;
        private List<Comment> comments = new ArrayList<>();

        public Builder id(long id) {
            this.id = id;
            return this;
        }
        
        public Builder issueKey(String issueKey) {
            this.issueKey = issueKey;
            return this;
        }
        
        public Builder title(String title) {
            this.title = title;
            return this;
        }
        
        public Builder description(String description) {
            this.description = description;
            return this;
        }
        
        public Builder status(IssueStatus status) {
            this.status = status;
            return this;
        }
        
        public Builder priority(Priority priority) {
            this.priority = priority;
            return this;
        }
        
        public Builder project(Project project) {
            this.project = project;
            return this;
        }
        
        public Builder reporter(User reporter) {
            this.reporter = reporter;
            return this;
        }
        
        public Builder assignee(User assignee) {
            this.assignee = assignee;
            return this;
        }

        public Builder addComment(Comment comment) {
            if (comment != null) {
                this.comments.add(comment);
            }
            return this;
        }

        public Issue build() {
            if (issueKey == null || issueKey.isBlank()) {
                throw new InvalidIssueException("Pole issueKey nie może być puste");
            }
            if (title == null || title.isBlank()) {
                throw new InvalidIssueException("Pole title nie może być puste");
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

    @Override
    public String toString() {
        return "Issue{"
                + "id=" + id
                + ", issueKey='" + issueKey + '\''
                + ", title='" + title + '\''
                + ", status=" + status
                + ", priority=" + priority
                + ", project='" + project.getName()
                + ", reporter=" + (reporter == null ? "brak" : reporter)
                + ", assignee=" + (assignee == null ? "brak" : assignee)
                + '}';
    }
}
