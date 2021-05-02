package com.dividendo.istio.user.service;

import com.dividendo.istio.user.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    private static final User DEFAULT_USER = new User(99, "NOT FOUND", 99, "NOT FOUND");
    private static Map<Integer, User> USER_MAP = new HashMap<>();

    static {
        USER_MAP.put(1, new User(1, "A", 12, "M"));
        USER_MAP.put(2, new User(2, "A", 15, "F"));
        USER_MAP.put(3, new User(3, "A", 17, "F"));
        USER_MAP.put(4, new User(4, "A", 23, "F"));
        USER_MAP.put(5, new User(5, "A", 45, "M"));
        USER_MAP.put(6, new User(6, "A", 12, "M"));
    }

    public Collection<User> getAllUsers() {
        LOG.info("Entering UserService>>>>getAllUsers {}", LocalDateTime.now().toLocalTime());
        return USER_MAP.values();
    }

    public User getUserById(Integer id) {
        LOG.info("Entering UserService  >>>>  getUserById {} {}", id, LocalDateTime.now().toLocalTime());
        return USER_MAP.getOrDefault(id, DEFAULT_USER);
    }

    public User addUser(User user) {
        LOG.info("Entering UserService  >>>>  addUser for {} at {}", user, LocalDateTime.now().toLocalTime());
        int key = USER_MAP.size() + 1;
        user.setId(key);
        return USER_MAP.put(key, user);
    }

    public boolean deleteUserById(Integer id) {
        User user = USER_MAP.remove(id);
        return user != null;
    }
}
