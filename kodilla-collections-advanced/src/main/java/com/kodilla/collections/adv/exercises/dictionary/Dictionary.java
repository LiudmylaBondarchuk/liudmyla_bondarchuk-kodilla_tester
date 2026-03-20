package com.kodilla.collections.adv.exercises.dictionary;
import java.util.*;


public class Dictionary {
    private final Map<String, List<EnglishWord>> dictionary = new HashMap<>();

    public void addWord(String polishWord, EnglishWord englishWord) {
        Objects.requireNonNull(polishWord, "polishWord must not be null");
        Objects.requireNonNull(englishWord, "englishWord must not be null");
        dictionary.computeIfAbsent(polishWord, k -> new ArrayList<>()).add(englishWord);
    }

    public List<EnglishWord> findEnglishWords(String polishWord) {
        Objects.requireNonNull(polishWord, "polishWord must not be null");
        return dictionary.getOrDefault(polishWord, Collections.emptyList());
    }

    public List<EnglishWord> findEnglishWords(String polishWord, PartOfSpeech partOfSpeech) {
        Objects.requireNonNull(polishWord, "polishWord must not be null");
        Objects.requireNonNull(partOfSpeech, "partOfSpeech must not be null");
        List<EnglishWord> result = new ArrayList<>();
        for (EnglishWord word : dictionary.getOrDefault(polishWord, Collections.emptyList())) {
            if (word.getPartOfSpeech().equals(partOfSpeech)) {
                result.add(word);
            }
        }
        return result;
    }

    public int size() {
        return dictionary.size();
    }
}
