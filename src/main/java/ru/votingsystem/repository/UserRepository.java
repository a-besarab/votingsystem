package ru.votingsystem.repository;

import org.springframework.stereotype.Repository;
import ru.votingsystem.model.User;

import java.util.List;

@Repository
public class UserRepository {
    public User save(User user) {
        return null;
    }

    public User get(int id) {
        return null;
    }

    public boolean delete(int id) {
        return true;
    }

    public User getByEmail(String email) {
        return null;
    }

    public List<User> getAll() {
        return null;
    }
}
