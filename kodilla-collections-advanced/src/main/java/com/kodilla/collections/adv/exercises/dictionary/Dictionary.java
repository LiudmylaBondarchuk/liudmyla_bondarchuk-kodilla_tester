package com.kodilla.collections.adv.exercises.dictionary;
import java.util.*;


public class Dictionary {
    Map<String, List<EnglishWord>> dictionary = new HashMap<>();

    public void addWord(String polishWord, EnglishWord englishWord) {
        List<EnglishWord> englishWords = dictionary.getOrDefault(polishWord, new ArrayList<>());
        englishWords.add(englishWord);
        dictionary.put(polishWord, englishWords);
    }

    public List<EnglishWord> findEnglishWords(String polishWord) {
        return dictionary.getOrDefault(polishWord, Collections.emptyList());
    }

    public List<EnglishWord> findEnglishWords(String polishWord, PartOfSpeech partOfSpeech) {
        List<EnglishWord> result = new ArrayList<>();
        for (EnglishWord word : dictionary.getOrDefault(polishWord, Collections.emptyList())) {
            if (word.getPartOfSpeech().equals(partOfSpeech)) {
                result.add(word);
            }
        }
        return result;
    }

    public int size () {

        return dictionary.size();
    }
}


