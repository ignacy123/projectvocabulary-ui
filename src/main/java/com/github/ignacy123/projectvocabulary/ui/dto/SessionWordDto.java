package com.github.ignacy123.projectvocabulary.ui.dto;

import com.github.ignacy123.projectvocabulary.ui.domain.SessionWord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ignacy on 12.05.16.
 */
public class SessionWordDto {

    private String word;
    private List<String> translations;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<String> getTranslations() {
        return translations;
    }

    public void setTranslations(List<String> translations) {
        this.translations = translations;
    }

    public static List<SessionWord> convertToSessionWords(SessionWordDto[] dtos) {
        List<SessionWord> result = new ArrayList<>();
        for (SessionWordDto dto : dtos) {
            result.add(new SessionWord(dto.getWord(), dto.getTranslations()));
        }
        return result;
    }
}

