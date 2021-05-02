package com.dividendo.istio.user.controller;


import com.dividendo.istio.user.domain.User;
import com.dividendo.istio.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Random;
import java.util.stream.IntStream;

@RequestMapping(value = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private static final Random random = new Random();
    @Autowired
    UserService userService;

    @GetMapping("users")
    public Collection<User> getAllUsers() {

        LOGGER.info("Entering UserController >>>> getAllUsers {}", LocalDateTime.now().toLocalTime());
        return userService.getAllUsers();
    }


    @GetMapping("users/{id}")
    public User getAllUsers(@PathVariable("id") Integer id) {

        LOGGER.info("Entering UserController >>>> getUserById {}", LocalDateTime.now().toLocalTime());
        return userService.getUserById(id);
    }

    @PostMapping(value = "users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User addUser(@RequestBody User user) {

        LOGGER.info("Entering UserController >>>> addUser {} at {}", user, LocalDateTime.now().toLocalTime());
        return userService.addUser(user);
    }

    @DeleteMapping("users")
    public String deleteUserById(@PathVariable("id") Integer id) {

        LOGGER.info("Entering UserController >>>> deleteUserById {}", LocalDateTime.now().toLocalTime());
        if (userService.deleteUserById(id)) {
            return String.format("User with %d has been successfully deleted", id);
        } else {
            return String.format("User with %d is not found in the system", id);
        }
    }


    @GetMapping("random/{numbers}")
    public void random(@PathVariable("numbers") Integer numbers) {

        IntStream.range(0, numbers).forEach(
                n -> {
                    if (random.nextBoolean()) {
                        LOGGER.info("Usercontroller >>> random result {}", true);
                    } else {
                        LOGGER.info("Usercontroller >>> random result {}", false);
                    }
                }
        );
    }
}
