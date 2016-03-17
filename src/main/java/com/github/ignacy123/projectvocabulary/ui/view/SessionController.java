package com.github.ignacy123.projectvocabulary.ui.view;

import com.github.ignacy123.projectvocabulary.ui.Main;
import com.github.ignacy123.projectvocabulary.ui.dictionary.MultiDictionary;
import com.github.ignacy123.projectvocabulary.ui.domain.SessionWord;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ignacy on 03.02.16.
 */
public class SessionController extends AbstractBaseController {
    @FXML
    private Label wordLabel;
    @FXML
    private TextField translationField;

    private MultiDictionary dictionary;
    private List<SessionWord> sessionWords = new ArrayList<>();
    private Random random = new Random(System.currentTimeMillis());
    private int sessionWordIndex = 0;


    @Override
    public void init(Main main) {
        super.init(main);
        dictionary = main.getDictionary();
        prepareSessionWords();
        showCurrentWord();
    }

    private void showCurrentWord() {
        wordLabel.setText(sessionWords.get(sessionWordIndex).getWord());
    }

    private void prepareSessionWords() {
        int size = dictionary.getSize();
        for (int i = 0; i < 20; i++) {
            int keyIndex = random.nextInt();
            String word = dictionary.getWord(keyIndex);
            List<String> translations = dictionary.getTranslations(keyIndex);
            SessionWord sessionWord = new SessionWord(word, translations);
            sessionWords.add(sessionWord);
        }
    }

    @FXML
    public void checkTranslation() {
        String translation = translationField.getText();
        SessionWord currentSessionWord = sessionWords.get(sessionWordIndex);
        if (currentSessionWord.matches(translation)) {
            currentSessionWord.setGuessResult(true);
            sessionWordIndex++;
        } else {
        }
    }

    @FXML
    public void giveUpCurrentTranslation() {
        SessionWord currentSessionWord = sessionWords.get(sessionWordIndex);
        currentSessionWord.setGuessResult(false);
        sessionWordIndex++;
    }
}
