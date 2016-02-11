package com.github.ignacy123.projectvocabulary.ui.view;

import com.github.ignacy123.projectvocabulary.ui.Main;

/**
 * Created by ignacy on 11.02.16.
 */
public abstract class AbstractBaseController implements BaseController{
    protected Main main;
    @Override
    public void init(Main main) {
        this.main = main;
    }
}
