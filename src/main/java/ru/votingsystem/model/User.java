package ru.votingsystem.model;

import java.util.List;
import java.util.Set;

public class User extends AbstractNamedEntity {
    private String email;
    private String password;
    private List<Vote> votes;
    private Set<Role> roles;

    public User() {
    }

    public User(Integer id, String name, String email, String password, List<Vote> votes, Set<Role> roles) {
        super(id, name);
        this.email = email;
        this.password = password;
        this.votes = votes;
        this.roles = roles;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public Set<Role> getRoles() {
        return roles;
    }
}