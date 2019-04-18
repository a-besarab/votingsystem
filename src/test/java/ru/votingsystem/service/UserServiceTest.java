package ru.votingsystem.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.votingsystem.model.User;


public class UserServiceTest extends AbstractServiceTest {

    @Autowired
    UserService service;

    @Test
    public void create() {

    }

    @Test
    public void delete() {
        service.delete(100000);
    }

    @Test
    public void get() {
        User user = service.get(100000);
        //assertEquals(user, new User(100000, "user", "user@yandex.ru", "password", Role.ROLE_USER));
    }

    @Test
    public void getByEmail() {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void update() {
    }
}
