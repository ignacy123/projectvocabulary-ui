package com.github.ignacy123.projectvocabulary.ui.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ignacy on 11.02.16.
 */
public class UserRepositoryMemory implements UserRepository {

    private final Map<String, User> users = new HashMap<>();

    UserRepositoryMemory() {
        User user = new User();
        user.setFirstName("Janusz");
        user.setLastName("Kowalki");
        user.setPassword("1234567");
        user.setEmail("janusz@example.com");
        saveUser(user);
    }


    @Override
    public User saveUser(User user) {
        for (User iteratedUser : users.values()) {
            if (iteratedUser.getEmail().equals(user.getEmail())) {
                throw new UserEmailNotUniqueException();
            }
        }
        users.put(user.getEmail(), user);
        return user;
    }
    public User findUserByEmail(String email) {
        return users.get(email);
    }
}
