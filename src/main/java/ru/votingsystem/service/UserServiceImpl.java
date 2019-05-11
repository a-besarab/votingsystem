package ru.votingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.votingsystem.model.User;
import ru.votingsystem.repository.UserRepository;
import ru.votingsystem.to.UserTo;
import ru.votingsystem.util.UserUtil;
import ru.votingsystem.util.exception.NotFoundException;

import java.util.List;

import static ru.votingsystem.util.ValidationUtil.checkNotFound;
import static ru.votingsystem.util.ValidationUtil.checkNotFoundWithId;

@Service("userService")
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @CacheEvict(value = "users", allEntries = true)
    @Override
    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return userRepository.save(user);
    }

    @CacheEvict(value = "users", allEntries = true)
    @Override
    public void delete(int userId) throws NotFoundException {
        checkNotFoundWithId(userRepository.delete(userId) != 0, userId);
    }

    @Override
    public User get(int userId) throws NotFoundException {
        return checkNotFoundWithId(userRepository.findById(userId).orElseThrow(() ->
                new NotFoundException("Not found user with id = " + userId)), userId);
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        Assert.notNull(email, "email must not be null");
        return checkNotFound(userRepository.getByEmail(email), "email=" + email);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public void update(UserTo userTo, int userId) {
        Assert.notNull(userTo, "user must not be null");
        User user = get(userId);
        userRepository.save(UserUtil.updateFromTo(user, userTo));
    }
}