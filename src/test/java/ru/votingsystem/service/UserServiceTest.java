package ru.votingsystem.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.votingsystem.model.User;

import java.util.List;

import static ru.votingsystem.testdata.UserTestData.*;


public class UserServiceTest extends AbstractServiceTest {

    @Autowired
    UserService service;

    @Test
    public void create() {
        service.create(NEW_USER);
        assertMatch(service.getByEmail("mail@gmail.com"), NEW_USER);
    }

    @Test
    public void delete() {
        service.delete(USER_ID);
        assertMatch(service.getAll(), ADMIN);
    }

    @Test
    public void get() {
        User user = service.get(USER_ID);
        assertMatch(user, USER);
    }

    @Test
    public void getByEmail() {
        assertMatch(service.getByEmail("user@yandex.ru"), USER);
    }

    @Test
    public void getAll() {
        List<User> users = service.getAll();
        assertMatch(users, ALL_USERS);
    }

    @Test
    public void update() {
        User modUser = service.get(USER_ID);
        modUser.setName("mod_user");
        service.create(modUser);
        assertMatch(service.get(USER_ID), modUser);
    }
}