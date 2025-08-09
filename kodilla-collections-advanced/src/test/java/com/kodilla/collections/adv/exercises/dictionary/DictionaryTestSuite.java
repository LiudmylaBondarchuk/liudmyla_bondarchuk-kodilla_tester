package com.kodilla.collections.adv.exercises.dictionary;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DictionaryTestSuite {

    @Test
    public void testAddWord(){
        //given
        Dictionary dictionary = new Dictionary();
        String polishWord = "stos";
        EnglishWord englishWord = new EnglishWord("stack", PartOfSpeech.NOUN);
        //when
        dictionary.addWord(polishWord, englishWord);
        //then
    assertEquals(1, dictionary.size());

    }
    @Test
    public void testFindEnglishWords(){
        //given
        Dictionary dictionary = new Dictionary();
        dictionary.addWord("stos", new EnglishWord("stack", PartOfSpeech.NOUN));
        dictionary.addWord("gra", new EnglishWord("play", PartOfSpeech.NOUN));
        dictionary.addWord("gra", new EnglishWord("game", PartOfSpeech.NOUN));
        dictionary.addWord("grać", new EnglishWord("play", PartOfSpeech.VERB));
        //when
        List<EnglishWord> result = dictionary.findEnglishWords("gra");
        //then
        List<EnglishWord> expectedList = new ArrayList<>();
        expectedList.add(new EnglishWord("play", PartOfSpeech.NOUN));
        expectedList.add(new EnglishWord("game", PartOfSpeech.NOUN));
        assertEquals(expectedList, result);
    }

    @Test
    public void testFindEnglishWordsWithPartOfSpeech() {
        //given
        Dictionary dictionary = new Dictionary();
        dictionary.addWord("stos", new EnglishWord("stack", PartOfSpeech.NOUN));
        dictionary.addWord("brać", new EnglishWord("brotherhood", PartOfSpeech.NOUN));
        dictionary.addWord("brać", new EnglishWord("take", PartOfSpeech.VERB));
        dictionary.addWord("grać", new EnglishWord("play", PartOfSpeech.VERB));
        //when
        List<EnglishWord> result = dictionary.findEnglishWords("brać", PartOfSpeech.NOUN);
        //then
        List<EnglishWord> expectedList = new ArrayList<>();
        expectedList.add(new EnglishWord("brotherhood", PartOfSpeech.NOUN));
        assertEquals(expectedList, result);
    }
}