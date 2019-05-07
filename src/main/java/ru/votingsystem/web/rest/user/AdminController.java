package ru.votingsystem.web.rest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.votingsystem.model.User;
import ru.votingsystem.service.UserService;
import ru.votingsystem.to.UserTo;
import ru.votingsystem.util.UserUtil;

import java.net.URI;
import java.util.List;

import static ru.votingsystem.util.UserUtil.createNewFromUser;

@RestController
@RequestMapping(value = AdminController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {

    static final String REST_URL = "/admin/users";
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public UserTo get(@PathVariable int userId) {
        return createNewFromUser(userService.get(userId));
    }

    @GetMapping
    public List<UserTo> getAll() {
        return createNewFromUser(userService.getAll());
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int userId) {
        userService.delete(userId);
    }

    @PutMapping(value = "/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody UserTo userTo, @PathVariable int userId) {
        int id = userTo.getId();
        userService.update(userTo, id);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserTo userTo) {
        User user = UserUtil.createNewFromTO(userTo);
        User created = userService.create(user);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }
}