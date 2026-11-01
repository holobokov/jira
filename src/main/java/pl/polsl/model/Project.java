
package pl.polsl.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pl.polsl.exceptions.InvalidModelException;

/**
 * Represents a project containing users and issues.
 *
 * @author Oleksandr Holobokov
 * @version 1.1
 */
public class Project {

    /** Project identifier. */
    private final long id;
    /** Unique project key. */
    private final String key;
    /** Project name. */
    private String name;
    /** Optional project description. */
    private String description;
    /** Project owner. */
    private User owner;
    /** Users participating in the project. */
    private List<User> members;
    /** Issues belonging to the project. */
    private List<Issue> issues;
    

    /**
     * Creates a project from builder values.
     *
     * @param builder source of the project values
     */
    private Project(Builder builder) {
        this.id = builder.id;
        this.key = builder.key;
        this.name = builder.name;
        this.description = builder.description;
        this.owner = builder.owner;
        this.members = new ArrayList<>(builder.members);
        this.issues = new ArrayList<>(builder.issues);
    }

    /**
     * Adds a user to the project and synchronizes the user relationship.
     *
     * @param user member to add
     */
    public void addMember(User user) {
        if (user != null) {
            members.add(user);
            user.assignToProject(this);
        }
    }
    
    /**
     * Adds an issue to the project and associates the issue with this project.
     *
     * @param issue issue to add
     */
    public void addIssue(Issue issue) {
        if (issue != null) {
            issues.add(issue);
            issue.setProject(this);
        }
    }
    
    /**
     * Returns the project name.
     *
     * @return project name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the project identifier.
     *
     * @return project identifier
     */
    public long getId() {
        return id;
    }

    /**
     * Returns the project key.
     *
     * @return project key
     */
    public String getKey() {
        return key;
    }

    /**
     * Updates the project name.
     *
     * @param name new project name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the project description.
     *
     * @return project description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Updates the project description.
     *
     * @param description new project description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the project owner.
     *
     * @return project owner
     */
    public User getOwner() {
        return owner;
    }

    /**
     * Updates the project owner.
     *
     * @param owner new project owner
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }

    /**
     * Returns an unmodifiable view of the project members.
     *
     * @return project members
     */
    public List<User> getMembers() {
        return Collections.unmodifiableList(members);
    }

    /**
     * Replaces project members with a defensive copy.
     *
     * @param members replacement members, or {@code null} for an empty list
     */
    public void setMembers(List<User> members) {
        this.members = members == null ? new ArrayList<>() : new ArrayList<>(members);
    }

    /**
     * Returns an unmodifiable view of the project issues.
     *
     * @return project issues
     */
    public List<Issue> getIssues() {
        return Collections.unmodifiableList(issues);
    }

    /**
     * Replaces project issues with a defensive copy.
     *
     * @param issues replacement issues, or {@code null} for an empty list
     */
    public void setIssues(List<Issue> issues) {
        this.issues = issues == null ? new ArrayList<>() : new ArrayList<>(issues);
    }
    
    /**
     * Creates an empty project builder.
     *
     * @return new project builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds validated project instances using a fluent API.
     *
     * @author Oleksandr Holobokov
     * @version 1.1
     */
    public static class Builder {

        /**
         * Creates an empty project builder.
         */
        public Builder() {
        }

        /** Project identifier being built. */
        private long id;
        /** Project key being built. */
        private String key;
        /** Project name being built. */
        private String name;
        /** Project description being built. */
        private String description;
        /** Project owner being built. */
        private User owner;
        /** Project members being built. */
        private List<User> members = new ArrayList<>();
        /** Project issues being built. */
        private List<Issue> issues = new ArrayList<>();

        /**
         * Sets the project identifier.
         *
         * @param id project identifier
         * @return this builder
         */

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the project key.
         *
         * @param key project key
         * @return this builder
         */
        public Builder key(String key) {
            this.key = key;
            return this;
        }

        /**
         * Sets the project name.
         *
         * @param name project name
         * @return this builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the project description.
         *
         * @param description project description
         * @return this builder
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        /**
         * Sets the project owner.
         *
         * @param owner project owner
         * @return this builder
         */
        public Builder owner(User owner) {
            this.owner = owner;
            return this;
        }

        /**
         * Adds a non-null project member.
         *
         * @param member member to add
         * @return this builder
         */
        public Builder addMember(User member) {
            if (member != null) {
                members.add(member);
            }
            return this;
        }

        /**
         * Adds a non-null project issue.
         *
         * @param issue issue to add
         * @return this builder
         */
        public Builder addIssue(Issue issue) {
            if (issue != null) {
                issues.add(issue);
            }
            return this;
        }

        /**
         * Validates the configured values and creates a project.
         *
         * @return validated project
         * @throws InvalidModelException if a required value is missing
         */
        public Project build() {
            if (key == null || key.isBlank()) {
                throw new InvalidModelException("Pole key nie może być puste");
            }
            if (name == null || name.isBlank()) {
                throw new InvalidModelException("Pole name nie może być puste");
            }
            return new Project(this);
        }
    }

    /**
     * Returns a textual representation of the project.
     *
     * @return project description
     */
    @Override
    public String toString() {
        return "Project{"
                + "id=" + id
                + ", key='" + key + '\''
                + ", name='" + name + '\''
                + ", description='" + description + '\''
                + ", owner=" + (owner == null ? "brak" : owner)
                + ", members=" + members.size()
                + ", issues=" + issues.size()
                + '}';
    }
}
