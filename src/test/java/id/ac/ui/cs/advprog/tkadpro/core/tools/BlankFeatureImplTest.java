package id.ac.ui.cs.advprog.tkadpro.core.tools;

import id.ac.ui.cs.advprog.tkadpro.core.Level;
import id.ac.ui.cs.advprog.tkadpro.core.game_type.TypeGame;
import id.ac.ui.cs.advprog.tkadpro.rest.SongDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BlankFeatureImplTest {
    private Class<?> blankFeatureImplClass;
    private BlankFeature blankFeature;

    @BeforeEach
    public void setUp() throws Exception {
        blankFeatureImplClass = Class.forName("id.ac.ui.cs.advprog.tkadpro.core.tools.BlankFeatureImpl");
        blankFeature = new BlankFeatureImpl();
    }

    @Test
    void testBlankFeatureIsConcreteClass() {
        assertFalse(Modifier.isAbstract(blankFeatureImplClass.getModifiers()));
    }

    @Test
    void testBlankFeatureOverrideGenerateQnAMethod() throws Exception {
        Method generateQnA = blankFeatureImplClass.getDeclaredMethod("generateQnA", SongDTO.class, TypeGame.class, Level.class);

        assertTrue(Modifier.isPublic(generateQnA.getModifiers()));
        assertEquals(3, generateQnA.getParameterCount());
    }

    @Test
    void testReturnTypeForGenerateQnA() throws Exception {
        Method generateQnA = blankFeatureImplClass.getDeclaredMethod("generateQnA", SongDTO.class, TypeGame.class, Level.class);
        assertEquals(List.class, generateQnA.getReturnType());
    }

    @Test
    void testEqualsReturnStatementForGenerateQnA() {
        SongDTO[] songDTO = new SongDTO[1];
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
        List<String> questionAnswer = blankFeature.generateQnA(songDTO[0], TypeGame.WORDSBLANK, Level.HARD);
        String question = questionAnswer.get(0);

        assertEquals(15, question.split("\r\n").length);
        assertEquals(5, questionAnswer.subList(1, questionAnswer.size()).size());
    }
}
