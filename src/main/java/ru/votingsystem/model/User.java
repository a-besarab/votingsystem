package ru.votingsystem.model;

import java.util.List;

public class User extends AbstractNamedEntity {
    private String email;
    private String password;
    private List<Vote> votes;
    private Role role;

    public User() {
    }

    public User(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(Integer id, String name, String email, String password, Role role) {
        super(id, name);
        this.email = email;
        this.password = password;
        this.role = role;
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

    public void setRoles(Role role) {
        this.role = role;
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

    public Role getRole() {
        return role;
    }
}