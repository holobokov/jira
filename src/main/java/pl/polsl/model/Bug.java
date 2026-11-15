package pl.polsl.model;

import pl.polsl.enums.IssueStatus;
import pl.polsl.enums.Priority;
import pl.polsl.exceptions.InvalidModelException;

/**
 * Represents a software defect tracked in a project.
 *
 * @author Oleksandr Holobokov
 * @version 1.1
 */
public class Bug extends Issue {

    /** Steps required to reproduce the bug. */
    private final String reproductionSteps;
    /** Expected behavior before the bug occurs. */
    private final String expectedBehavior;
    /** Actual behavior observed when the bug occurs. */
    private final String actualBehavior;

    /**
     * Creates a bug from builder values.
     *
     * @param builder source of the bug values
     */
    private Bug(Builder builder) {
        super(builder);
        this.reproductionSteps = builder.reproductionSteps;
        this.expectedBehavior = builder.expectedBehavior;
        this.actualBehavior = builder.actualBehavior;
    }

    /**
     * Returns the reproduction steps.
     *
     * @return reproduction steps
     */
    public String getReproductionSteps() {
        return reproductionSteps;
    }

    /**
     * Returns the expected behavior.
     *
     * @return expected behavior
     */
    public String getExpectedBehavior() {
        return expectedBehavior;
    }

    /**
     * Returns the actual behavior.
     *
     * @return actual behavior
     */
    public String getActualBehavior() {
        return actualBehavior;
    }

    /**
     * Creates an empty bug builder.
     *
     * @return new bug builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds validated bug instances using a fluent API.
     */
    public static class Builder extends Issue.Builder {

        private String reproductionSteps;
        private String expectedBehavior;
        private String actualBehavior;

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

        public Builder reproductionSteps(String reproductionSteps) {
            this.reproductionSteps = reproductionSteps;
            return this;
        }

        public Builder expectedBehavior(String expectedBehavior) {
            this.expectedBehavior = expectedBehavior;
            return this;
        }

        public Builder actualBehavior(String actualBehavior) {
            this.actualBehavior = actualBehavior;
            return this;
        }

        public Bug build() {
            if (reproductionSteps == null || reproductionSteps.isBlank()) {
                throw new InvalidModelException("Pole reproductionSteps nie może być puste");
            }
            if (expectedBehavior == null || expectedBehavior.isBlank()) {
                throw new InvalidModelException("Pole expectedBehavior nie może być puste");
            }
            if (actualBehavior == null || actualBehavior.isBlank()) {
                throw new InvalidModelException("Pole actualBehavior nie może być puste");
            }
            return new Bug(this);
        }

    }

    /**
     * Returns a textual representation of the bug.
     *
     * @return bug description
     */
    @Override
    public String toString() {
        return "Bug{"
                + "id=" + getId()
                + ", issueKey='" + getIssueKey() + '\''
                + ", title='" + getTitle() + '\''
                + ", status=" + getStatus()
                + ", priority=" + getPriority()
                + ", reproductionSteps='" + reproductionSteps + '\''
                + ", expectedBehavior='" + expectedBehavior + '\''
                + ", actualBehavior='" + actualBehavior + '\''
                + '}';
    }
}
