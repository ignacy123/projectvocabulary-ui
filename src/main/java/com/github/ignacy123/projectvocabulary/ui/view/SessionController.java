package com.github.ignacy123.projectvocabulary.ui.view;

import com.github.ignacy123.projectvocabulary.ui.Main;
import com.github.ignacy123.projectvocabulary.ui.dictionary.MultiDictionary;
import com.github.ignacy123.projectvocabulary.ui.domain.SessionWord;
import com.github.ignacy123.projectvocabulary.ui.dto.SessionRequest;
import com.github.ignacy123.projectvocabulary.ui.dto.SessionWordDto;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by ignacy on 03.02.16.
 */
public class SessionController extends AbstractBaseController {
    @FXML
    private Label wordLabel;
    @FXML
    private Label errorLabel;
    @FXML
    private TextField translationField;
    @FXML
    private Button backButton;

    private MultiDictionary dictionary;
    private List<SessionWord> sessionWords = new ArrayList<>();
    private Random random = new Random(System.currentTimeMillis());
    private int sessionWordIndex = 0;

    @FXML
    public void back() {
        main.switchToRootScene();
    }

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

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        SessionRequest sessionRequest = new SessionRequest();
        sessionRequest.setSize(20);

        ResponseEntity<SessionWordDto[]> resultResponseEntity = restTemplate.postForEntity(
                "http://localhost:8080/dictionary/session",
                sessionRequest,
                SessionWordDto[].class);
        SessionWordDto[] body = resultResponseEntity.getBody();
        sessionWords.addAll(SessionWordDto.convertToSessionWords(body));

    }

    @FXML
    public void checkTranslation() {
        String translation = translationField.getText();
        SessionWord currentSessionWord = sessionWords.get(sessionWordIndex);
        if (currentSessionWord.matches(translation)) {
            showNextWord(currentSessionWord, true);
        } else {
            errorLabel.setText("wrong translation");
        }
    }

    @FXML
    public void giveUpCurrentTranslation() {
        SessionWord currentSessionWord = sessionWords.get(sessionWordIndex);
        showNextWord(currentSessionWord, false);
    }

    private void showNextWord(SessionWord currentSessionWord, boolean guessResult) {
        currentSessionWord.setGuessResult(guessResult);
        sessionWordIndex++;
        wordLabel.setText(sessionWords.get(sessionWordIndex).getWord());
    }
}
