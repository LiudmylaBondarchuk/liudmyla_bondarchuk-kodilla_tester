package com.kodilla.collections.adv.exercises.dictionary;

import java.util.Objects;

public class EnglishWord {
    private String word;
    private PartOfSpeech partOfSpeech;
    public EnglishWord(String word, PartOfSpeech partOfSpeech) {
        this.word = word;
        this.partOfSpeech = partOfSpeech;
    }
    public String getWord() {
        return word;
    }
    public PartOfSpeech getPartOfSpeech() {
        return partOfSpeech;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EnglishWord that = (EnglishWord) o;
        return Objects.equals(word, that.word) && partOfSpeech == that.partOfSpeech;
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, partOfSpeech);
    }
}
