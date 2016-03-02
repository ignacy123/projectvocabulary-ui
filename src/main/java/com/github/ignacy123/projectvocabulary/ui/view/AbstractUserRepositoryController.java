package com.github.ignacy123.projectvocabulary.ui.view;

import com.github.ignacy123.projectvocabulary.ui.Main;
import com.github.ignacy123.projectvocabulary.ui.domain.UserRepository;

/**
 * Created by ignacy on 02.03.16.
 */
public abstract class AbstractUserRepositoryController implements BaseController{
    protected Main main;
    @Override
    public void init(Main main) {
        this.main = main;
    }
    public UserRepository userRepository;
}
