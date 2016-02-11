package com.github.ignacy123.projectvocabulary.ui.domain;

/**
 * Created by ignacy on 11.02.16.
 */
public interface UserRepository {
    boolean isEmailUnique(String email);
    User saveUser(User user);

}
