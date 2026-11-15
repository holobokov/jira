package pl.polsl.model;

import java.time.LocalDate;
import pl.polsl.enums.IssueStatus;
import pl.polsl.enums.Priority;
import pl.polsl.exceptions.InvalidModelException;

/**
 * Represents a regular task tracked in a project.
 *
 * @author Oleksandr Holobokov
 * @version 1.1
 */
public class Task extends Issue {

    /** Estimated number of hours needed to complete the task. */
    private final int estimatedHours;
    /** Optional task due date. */
    private final LocalDate dueDate;

    /**
     * Creates a task from builder values.
     *
     * @param builder source of the task values
     */
    private Task(Builder builder) {
        super(builder);
        this.estimatedHours = builder.estimatedHours;
        this.dueDate = builder.dueDate;
    }

    /**
     * Returns the estimated number of work hours.
     *
     * @return estimated hours
     */
    public int getEstimatedHours() {
        return estimatedHours;
    }

    /**
     * Returns the task due date.
     *
     * @return due date, or {@code null} if it was not specified
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * Creates an empty task builder.
     *
     * @return new task builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds validated task instances using a fluent API.
     */
    public static class Builder extends Issue.Builder {

        private int estimatedHours;
        private LocalDate dueDate;

        @Override
        public Builder id(long id) {
            super.id(id);
            return this;
        }

        @Override
        public Builder issueKey(String issueKey) {
            super.issueKey(issueKey);
            return this;
        }

        @Override
        public Builder title(String title) {
            super.title(title);
            return this;
        }

        @Override
        public Builder description(String description) {
            super.description(description);
            return this;
        }

        @Override
        public Builder status(IssueStatus status) {
            super.status(status);
            return this;
        }

        @Override
        public Builder priority(Priority priority) {
            super.priority(priority);
            return this;
        }

        @Override
        public Builder project(Project project) {
            super.project(project);
            return this;
        }

        @Override
        public Builder reporter(User reporter) {
            super.reporter(reporter);
            return this;
        }

        @Override
        public Builder assignee(User assignee) {
            super.assignee(assignee);
            return this;
        }

        public Builder estimatedHours(int estimatedHours) {
            this.estimatedHours = estimatedHours;
            return this;
        }

        public Builder dueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Task build() {
            if (estimatedHours < 0) {
                throw new InvalidModelException("Pole estimatedHours nie może być ujemne");
            }
            return new Task(this);
        }

    }

    /**
     * Returns a textual representation of the task.
     *
     * @return task description
     */
    @Override
    public String toString() {
        return "Task{"
                + "id=" + getId()
                + ", issueKey='" + getIssueKey() + '\''
                + ", title='" + getTitle() + '\''
                + ", status=" + getStatus()
                + ", priority=" + getPriority()
                + ", estimatedHours=" + estimatedHours
                + ", dueDate=" + dueDate
                + '}';
    }
}
