package ru.votingsystem;

import ru.votingsystem.model.Role;
import ru.votingsystem.model.User;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.votingsystem.model.AbstractBaseEntity.START_SEQ;

public class UserTestData {

    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 1;

    public static final User USER = new User(USER_ID, "User", "user@yandex.ru", "password", Role.ROLE_USER);
    public static final User ADMIN = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admin", Role.ROLE_ADMIN);
    public static final User NEW_USER = new User(100030, "newUser", "mail@gmail.com", "password", Role.ROLE_USER);


    public static List<User> ALL_USERS = Arrays.asList(ADMIN, USER);


    public static void assertMatch(User actual, User expected) {
        assertThat(actual).isEqualTo(expected).isEqualToIgnoringGivenFields(expected, "password");
    }

    public static void assertMatch(Iterable<User> actual, User... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<User> actual, Iterable<User> expected) {
        assertThat(actual).isEqualTo(expected).usingElementComparatorIgnoringFields("password");
    }
}