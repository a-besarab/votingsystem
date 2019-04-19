package ru.votingsystem.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.votingsystem.model.User;

import java.util.List;

import static ru.votingsystem.UserTestData.*;


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
        service.delete(100000);
        assertMatch(service.getAll(), ADMIN);
    }

    @Test
    public void get() {
        User user = service.get(100000);
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
        User modUser = service.get(100000);
        modUser.setName("mod_user");
        service.update(modUser);
        assertMatch(service.get(100000), modUser);
    }
}
