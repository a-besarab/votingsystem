package ru.votingsystem.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.votingsystem.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService userService;
}