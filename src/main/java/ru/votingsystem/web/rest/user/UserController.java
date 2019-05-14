package ru.votingsystem.web.rest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.votingsystem.AuthorizedUser;
import ru.votingsystem.service.UserService;
import ru.votingsystem.to.UserTo;

import static org.springframework.security.core.context.SecurityContextHolder.getContext;
import static ru.votingsystem.util.UserUtil.createNewFromUser;

@RestController
@RequestMapping(value = UserController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    static final String REST_URL = "/users";
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public UserTo get() {
        int userId = ((AuthorizedUser) getContext().getAuthentication().getPrincipal()).getId();
        return createNewFromUser(userService.get(userId));
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete() {
        int userId = ((AuthorizedUser) getContext().getAuthentication().getPrincipal()).getId();
        userService.delete(userId);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody UserTo userTo) {
        int id = ((AuthorizedUser) getContext().getAuthentication().getPrincipal()).getId();
        userService.update(userTo, id);
    }
}