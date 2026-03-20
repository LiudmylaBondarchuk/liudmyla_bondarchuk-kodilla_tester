package com.kodilla.collections.adv.exercises.dictionary;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("EnglishWord test suite")
class EnglishWordTestSuite {

    @Test
    @DisplayName("should create word with valid fields")
    void testCreateEnglishWord() {
        //given & when
        EnglishWord word = new EnglishWord("stack", PartOfSpeech.NOUN);

        //then
        assertEquals("stack", word.getWord());
        assertEquals(PartOfSpeech.NOUN, word.getPartOfSpeech());
    }

    @Test
    @DisplayName("should throw NullPointerException when word is null")
    void testNullWord() {
        //given & when & then
        assertThrows(NullPointerException.class, () -> new EnglishWord(null, PartOfSpeech.NOUN));
    }

    @Test
    @DisplayName("should throw NullPointerException when part of speech is null")
    void testNullPartOfSpeech() {
        //given & when & then
        assertThrows(NullPointerException.class, () -> new EnglishWord("stack", null));
    }

    @Test
    @DisplayName("should be equal when word and part of speech match")
    void testEqualWords() {
        //given
        EnglishWord word1 = new EnglishWord("stack", PartOfSpeech.NOUN);
        EnglishWord word2 = new EnglishWord("stack", PartOfSpeech.NOUN);

        //when & then
        assertEquals(word1, word2);
        assertEquals(word1.hashCode(), word2.hashCode());
    }

    @Test
    @DisplayName("should not be equal when word text differs")
    void testNotEqualDifferentWord() {
        //given
        EnglishWord word1 = new EnglishWord("stack", PartOfSpeech.NOUN);
        EnglishWord word2 = new EnglishWord("heap", PartOfSpeech.NOUN);

        //when & then
        assertNotEquals(word1, word2);
    }

    @Test
    @DisplayName("should not be equal when part of speech differs")
    void testNotEqualDifferentPartOfSpeech() {
        //given
        EnglishWord word1 = new EnglishWord("play", PartOfSpeech.NOUN);
        EnglishWord word2 = new EnglishWord("play", PartOfSpeech.VERB);

        //when & then
        assertNotEquals(word1, word2);
    }

    @Test
    @DisplayName("should return readable toString")
    void testToString() {
        //given
        EnglishWord word = new EnglishWord("stack", PartOfSpeech.NOUN);

        //when
        String result = word.toString();

        //then
        assertTrue(result.contains("stack"));
        assertTrue(result.contains("NOUN"));
    }
}
