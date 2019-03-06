package ru.votingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.votingsystem.model.User;
import ru.votingsystem.repository.UserRepository;
import ru.votingsystem.util.exception.NotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User save(User user) {
        return null;
    }

    public void delete(int id) throws NotFoundException {
    }

    public User get(int id) throws NotFoundException {
        return null;
    }

    public User getByEmail(String email) throws NotFoundException {
        return null;
    }
}
