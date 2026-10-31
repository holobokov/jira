
package pl.polsl.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pl.polsl.exceptions.InvalidIssueException;

public class Project {

    private final long id;
    private final String key;
    private String name;
    private String description;
    private User owner;
    private List<User> members;
    private List<Issue> issues;
    

    private Project(Builder builder) {
        this.id = builder.id;
        this.key = builder.key;
        this.name = builder.name;
        this.description = builder.description;
        this.owner = builder.owner;
        this.members = new ArrayList<>(builder.members);
        this.issues = new ArrayList<>(builder.issues);
    }

    public void addMember(User user) {
        if (user != null) members.add(user);
    }
    
    public void addIssue(Issue issue) {
        if (issue != null) {
            issues.add(issue);
            issue.setProject(this);
        }
    }
    
    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<User> getMembers() {
        return Collections.unmodifiableList(members);
    }

    public void setMembers(List<User> members) {
        this.members = members == null ? new ArrayList<>() : new ArrayList<>(members);
    }

    public List<Issue> getIssues() {
        return Collections.unmodifiableList(issues);
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues == null ? new ArrayList<>() : new ArrayList<>(issues);
    }
    
    //Builder pattern
    
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private long id;
        private String key;
        private String name;
        private String description;
        private User owner;
        private List<User> members = new ArrayList<>();
        private List<Issue> issues = new ArrayList<>();

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder key(String key) {
            this.key = key;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder owner(User owner) {
            this.owner = owner;
            return this;
        }

        public Builder addMember(User member) {
            if (member != null) {
                members.add(member);
            }
            return this;
        }

        public Builder addIssue(Issue issue) {
            if (issue != null) {
                issues.add(issue);
            }
            return this;
        }

        public Project build() {
            if (key == null || key.isBlank()) {
                throw new InvalidIssueException("Pole key nie może być puste");
            }
            if (name == null || name.isBlank()) {
                throw new InvalidIssueException("Pole name nie może być puste");
            }
            return new Project(this);
        }
    }

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
