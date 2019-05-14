package ru.votingsystem.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.votingsystem.model.User;
import ru.votingsystem.util.exception.NotFoundException;

import java.util.List;

import static ru.votingsystem.testdata.UserTestData.*;


public class UserServiceTest extends AbstractServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void create() {
        userService.create(NEW_USER);
        assertMatch(userService.getByEmail("mail@gmail.com"), NEW_USER);
    }

    @Test
    public void delete() {
        userService.delete(USER_ID);
        assertMatch(userService.getAll(), ADMIN);
    }

    @Test(expected = NotFoundException.class)
    public void deleteNotFound() {
        userService.delete(99999);
    }

    @Test
    public void get() {
        User user = userService.get(USER_ID);
        assertMatch(user, USER);
    }

    @Test(expected = NotFoundException.class)
    public void getNotFound() {
        userService.get(99999);
    }

    @Test
    public void getByEmail() {
        assertMatch(userService.getByEmail("user@yandex.ru"), USER);
    }

    @Test
    public void getAll() {
        List<User> users = userService.getAll();
        assertMatch(users, ALL_USERS);
    }

    @Test
    public void update() {
        User modUser = userService.get(USER_ID);
        modUser.setName("mod_user");
        userService.create(modUser);
        assertMatch(userService.get(USER_ID), modUser);
    }
}