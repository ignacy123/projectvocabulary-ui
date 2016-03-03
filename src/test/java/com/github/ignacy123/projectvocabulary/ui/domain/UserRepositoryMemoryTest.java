package com.github.ignacy123.projectvocabulary.ui.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by ignacy on 03.03.16.
 */
public class UserRepositoryMemoryTest {
    private UserRepositoryMemory userRepository;

    @Before
    public void setUp() throws Exception {
        userRepository = new UserRepositoryMemory();

    }

    @Test
    public void testSaveUser() throws Exception {
        User user = new User();
        user.setLogin("test123");
        user.setEmail("abc@gmail.com");
        user.setPassword("test123");
        userRepository.saveUser(user);
        User createdUser = userRepository.findUserByLogin("test123");
        assertThat(createdUser.getLogin(), is(user.getLogin()));
        assertThat(createdUser.getEmail(), is(user.getEmail()));
        assertThat(createdUser.getPassword(), is(user.getPassword()));
    }

    @Test(expected = UserEmailNotUniqueException.class)
    public void testSaveUserThrowsExceptionForNonUniqueEmail() throws Exception {
        User user = new User();
        user.setLogin("test123");
        user.setEmail("abc@gmail.com");
        user.setPassword("test123");
        userRepository.saveUser(user);
        user = new User();
        user.setLogin("nottest");
        user.setEmail("abc@gmail.com");
        user.setPassword("test123");
        userRepository.saveUser(user);
    }

    @Test(expected = UserLoginNotUniqueException.class)
    public void testSaveUserThrowsExceptionForNonUniqueLogin() throws Exception {
        User user = new User();
        user.setLogin("test123");
        user.setEmail("abc@gmail.com");
        user.setPassword("test123");
        userRepository.saveUser(user);
        user = new User();
        user.setLogin("test123");
        user.setEmail("differentEmail");
        user.setPassword("test123");
        userRepository.saveUser(user);
    }

}
