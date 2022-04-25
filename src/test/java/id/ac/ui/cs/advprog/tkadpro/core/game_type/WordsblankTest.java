package id.ac.ui.cs.advprog.tkadpro.core.game_type;

import id.ac.ui.cs.advprog.tkadpro.rest.SongDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordsblankTest {
    private SongDTO[] songDTO = new SongDTO[1];
    private Class<?> wordsblankClass;
    private WordsBlank wordsblank;

    @BeforeEach
    public void setUp() throws Exception {
        wordsblankClass = Class.forName("id.ac.ui.cs.advprog.tkadpro.core.game_type.WordsBlank");
        songDTO[0] = new SongDTO("Let Her Go", "Passenger",
                "All the Little Lights", "Well, you only need the light when it's burning low\r\n" +
                "Only miss the sun when it starts to snow\r\n" +
                "Only know you love her when you let her go\r\n" +
                "Only know you've been high when you're feeling low\r\n" +
                "Only hate the road when you're missing home\r\n" +
                "Only know you love her when you let her go\r\n" +
                "And you let her go\r\n" +
                "Staring at the bottom of your glass\r\n" +
                "Hoping one day you'll make a dream last\r\n" +
                "But dreams come slow, and they go so fast\r\n" +
                "You see her when you close your eyes\r\n" +
                "Maybe one day, you'll understand why\r\n" +
                "Everything you touch surely dies\r\n" +
                "But you only need the light when it's burning low\r\n" +
                "Only miss the sun when it starts to snow\r\n" +
                "Only know you love her when you let her go\r\n" +
                "Only know you've been high when you're feeling low\r\n" +
                "Only hate the road when you're missing home\r\n" +
                "Only know you love her when you let her go");
        wordsblank = new WordsBlank(songDTO);
    }

    @Test
    void testWordsBlankIsConcreteClass() {
        assertFalse(Modifier.isAbstract(wordsblankClass.getModifiers()));
    }

    @Test
    void testWordsBlankOverrideGetEasyQnAMethod() throws Exception {
        Method getEasyQnA = wordsblankClass.getDeclaredMethod("getEasyQnA");

        assertTrue(Modifier.isPublic(getEasyQnA.getModifiers()));
        assertEquals(0, getEasyQnA.getParameterCount());
    }

    @Test
    void testReturnTypeForGetEasyQnA() throws Exception {
        Method getEasyQnA = wordsblankClass.getDeclaredMethod("getEasyQnA");
        assertEquals(List.class, getEasyQnA.getReturnType());
    }

    @Test
    void testEqualsReturnStatementForGetEasyQnA() {
        List<String> questionAnswer = wordsblank.getEasyQnA();
        String question = questionAnswer.get(0);
        String answer = questionAnswer.get(1);

        assertEquals(String.class, answer.getClass());
        assertEquals(15, question.split("\r\n").length);
        assertEquals(1, questionAnswer.subList(1, questionAnswer.size()).size());
    }

    @Test
    void testWordsBlankOverrideGetMediumQnAMethod() throws Exception {
        Method getMediumQnA = wordsblankClass.getDeclaredMethod("getMediumQnA");

        assertTrue(Modifier.isPublic(getMediumQnA.getModifiers()));
        assertEquals(0, getMediumQnA.getParameterCount());
    }

    @Test
    void testReturnTypeForGetMediumQnA() throws Exception {
        Method getMediumQnA = wordsblankClass.getDeclaredMethod("getMediumQnA");
        assertEquals(List.class, getMediumQnA.getReturnType());
    }

    @Test
    void testEqualsReturnStatementForgetMediumQnA() {
        List<String> questionAnswer = wordsblank.getMediumQnA();
        String question = questionAnswer.get(0);

        assertEquals(15, question.split("\r\n").length);
        assertEquals(3, questionAnswer.subList(1, questionAnswer.size()).size());
    }

    @Test
    void testWordsBlankOverrideGetHardQnAMethod() throws Exception {
        Method getHardQnA = wordsblankClass.getDeclaredMethod("getHardQnA");

        assertTrue(Modifier.isPublic(getHardQnA.getModifiers()));
        assertEquals(0, getHardQnA.getParameterCount());
    }

    @Test
    void testReturnTypeForGetHardQnA() throws Exception {
        Method getHardQnA = wordsblankClass.getDeclaredMethod("getHardQnA");
        assertEquals(List.class, getHardQnA.getReturnType());
    }

    @Test
    void testEqualsReturnStatementForGetHardQnA() {
        List<String> questionAnswer = wordsblank.getHardQnA();
        String question = questionAnswer.get(0);

        assertEquals(15, question.split("\r\n").length);
        assertEquals(5, questionAnswer.subList(1, questionAnswer.size()).size());
    }
}