package com.github.ignacy123.projectvocabulary.ui.Users;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ignacy on 02.03.16.
 */
public class UserRepository {
    private List<User> users;

    UserRepository() {
        users = new ArrayList<User>();

    }

    public void addUser(User user) {
        users.add(user);
    }

    public User findByEmail(String email) {
        for (User user : users) {
            String userEmail = user.getEmail();
            if (userEmail.equals(email)) {
                return user;
            }
        }
        return null;
    }

    public void save(File file) throws FileNotFoundException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {

            outputStream.writeObject(users);
        } catch (IOException e) {
            throw new FileNotFoundException();
        }

    }

    public List<User> getAll() {
        return Collections.unmodifiableList(users);
    }
}
