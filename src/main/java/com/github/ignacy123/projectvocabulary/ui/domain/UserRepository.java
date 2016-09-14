package com.github.ignacy123.projectvocabulary.ui.domain;

/**
 * Created by ignacy on 11.02.16.
 */
public interface UserRepository {
    UserRepositoryMemory INSTANCE = new UserRepositoryMemory();

    User saveUser(User user) throws UserEmailNotUniqueException, UserLoginNotUniqueException;

    static UserRepository getInstance() {
        return INSTANCE;
    }

    User findUserByEmail(String email);
}
