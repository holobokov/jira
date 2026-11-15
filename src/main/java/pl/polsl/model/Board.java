package pl.polsl.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pl.polsl.exceptions.InvalidModelException;

/**
 * Represents a board containing issues for a project.
 *
 * @author Oleksandr Holobokov
 * @version 1.1
 */
public class Board {

    /** Board identifier. */
    private final long id;
    /** Board name. */
    private String name;
    /** Project associated with this board. */
    private Project project;
    /** Issues displayed on this board. */
    private List<Issue> issues;

    /**
     * Creates a board from builder values.
     *
     * @param builder source of the board values
     */
    private Board(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.project = builder.project;
        this.issues = new ArrayList<>(builder.issues);
    }

    /**
     * Adds an issue to the board if it is not already present.
     *
     * @param issue issue to add
     */
    public void addIssue(Issue issue) {
        if (issue != null && !issues.contains(issue)) {
            issues.add(issue);
            if (project != null && !project.getIssues().contains(issue)) {
                project.addIssue(issue);
            }
        }
    }

    /**
     * Removes an issue from the board.
     *
     * @param issue issue to remove
     * @return {@code true} if the issue was removed
     */
    public boolean removeIssue(Issue issue) {
        return issues.remove(issue);
    }

    /**
     * Finds an issue by its key.
     *
     * @param issueKey key to search for
     * @return matching issue or {@code null} if it does not exist
     */
    public Issue findIssueByKey(String issueKey) {
        if (issueKey == null) {
            return null;
        }
        return issues.stream()
                .filter(issue -> issueKey.equals(issue.getIssueKey()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Returns the board identifier.
     *
     * @return board identifier
     */
    public long getId() {
        return id;
    }

    /**
     * Returns the board name.
     *
     * @return board name
     */
    public String getName() {
        return name;
    }

    /**
     * Updates the board name.
     *
     * @param name new board name
     */
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new InvalidModelException("Pole name nie może być puste");
        }
        this.name = name;
    }

    /**
     * Returns the associated project.
     *
     * @return associated project
     */
    public Project getProject() {
        return project;
    }

    /**
     * Updates the associated project.
     *
     * @param project project associated with the board
     */
    public void setProject(Project project) {
        this.project = project;
    }

    /**
     * Returns an unmodifiable view of the board issues.
     *
     * @return board issues
     */
    public List<Issue> getIssues() {
        return Collections.unmodifiableList(issues);
    }

    /**
     * Replaces board issues with a defensive copy.
     *
     * @param issues replacement issues, or {@code null} for an empty list
     */
    public void setIssues(List<Issue> issues) {
        this.issues = issues == null ? new ArrayList<>() : new ArrayList<>(issues);
    }

    /**
     * Creates an empty board builder.
     *
     * @return new board builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds validated board instances using a fluent API.
     *
     * @author Oleksandr Holobokov
     * @version 1.1
     */
    public static class Builder {

        /** Board identifier being built. */
        private long id;
        /** Board name being built. */
        private String name;
        /** Project associated with the board being built. */
        private Project project;
        /** Issues assigned to the board being built. */
        private List<Issue> issues = new ArrayList<>();

        /**
         * Sets the board identifier.
         *
         * @param id board identifier
         * @return this builder
         */
        public Builder id(long id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the board name.
         *
         * @param name board name
         * @return this builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the associated project.
         *
         * @param project project associated with the board
         * @return this builder
         */
        public Builder project(Project project) {
            this.project = project;
            return this;
        }

        /**
         * Adds a non-null issue to the board.
         *
         * @param issue issue to add
         * @return this builder
         */
        public Builder addIssue(Issue issue) {
            if (issue != null && !issues.contains(issue)) {
                issues.add(issue);
            }
            return this;
        }

        /**
         * Validates the configured values and creates a board.
         *
         * @return validated board
         * @throws InvalidModelException if a required value is missing
         */
        public Board build() {
            if (name == null || name.isBlank()) {
                throw new InvalidModelException("Pole name nie może być puste");
            }
            return new Board(this);
        }
    }

    /**
     * Returns a textual representation of the board.
     *
     * @return board description
     */
    @Override
    public String toString() {
        return "Board{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", project=" + (project == null ? "brak" : project.getName())
                + ", issues=" + issues.size()
                + '}';
    }
}
