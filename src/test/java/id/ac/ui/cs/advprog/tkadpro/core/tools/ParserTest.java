package id.ac.ui.cs.advprog.tkadpro.core.tools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

 class ParserTest {
    private Class<?> parserClass;
    private Parser lineParser;
    private Parser wordParser;
    private String stringQuestion;
    private String stringAnswer;

    @BeforeEach
     public void setUp() throws Exception {
        parserClass = Class.forName("id.ac.ui.cs.advprog.tkadpro.core.tools.Parser");
        lineParser = new Parser("\r\n");
        wordParser = new Parser(" ");
    }

    @Test
     void testParserIsConcreteClass() {
        assertFalse(Modifier.isAbstract(parserClass.getModifiers()));
    }

    @Test
     void testReturnTypeForParseSentence() throws Exception {
        Method parseSentence = parserClass.getDeclaredMethod("parseSentence", String.class);
        assertEquals(List.class, parseSentence.getReturnType());
    }

    @Test
     void testJoinShouldReturnCorrectlyForQuestion() {
        stringQuestion = "Well, you only need the _ _ _ when it's burning low\r\n" +
                "Only _ _ _ the sun when it starts to snow";
        assertEquals(Arrays.asList(
                "Well, you only need the _ _ _ when it's burning low", "Only _ _ _ the sun when it starts to snow"),
                lineParser.parseSentence(stringQuestion)
        );
        assertEquals(2, lineParser.parseSentence(stringQuestion).size());
    }

    @Test
     void testJoinShouldReturnCorrectlyForAnswer() {
        stringAnswer = "Hello World!, This is Spring Boot";
        assertEquals(
                Arrays.asList("Hello", "World!,", "This", "is", "Spring", "Boot"),
                wordParser.parseSentence(stringAnswer));
        assertEquals(6, wordParser.parseSentence(stringAnswer).size());
    }
}