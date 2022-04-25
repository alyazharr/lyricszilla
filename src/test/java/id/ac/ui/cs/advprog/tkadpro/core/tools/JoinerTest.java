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

public class JoinerTest {
    private Class<?> joinerClass;
    private Joiner lineJoiner;
    private Joiner wordJoiner;
    private List<String> stringQuestion;
    private List<String> stringAnswer;

    @BeforeEach
    public void setUp() throws Exception {
        joinerClass = Class.forName("id.ac.ui.cs.advprog.tkadpro.core.tools.Joiner");
        lineJoiner = new Joiner("\r\n");
        wordJoiner = new Joiner(" ");
        stringAnswer = new ArrayList<>();
        stringQuestion = new ArrayList<>();
    }

    @Test
    public void testJoinerIsConcreteClass() {
        assertFalse(Modifier.isAbstract(joinerClass.getModifiers()));
    }

    @Test
    public void testReturnTypeForJoin() throws Exception {
        Method join = joinerClass.getDeclaredMethod("join", List.class);
        assertEquals(String.class, join.getReturnType());
    }

    @Test
    public void testJoinShouldReturnCorrectlyForQuestion() {
        stringQuestion.addAll(
                Arrays.asList(
                        "Well, you only need the _ _ _ when it's burning low",
                        "Only _ _ _ the sun when it starts to snow"
                ));
        assertEquals(
                "Well, you only need the _ _ _ when it's burning low\r\nOnly _ _ _ the sun when it starts to snow",
                lineJoiner.join(stringQuestion)
                );
    }

    @Test
    public void testJoinShouldReturnCorrectlyForAnswer() {
        stringAnswer.addAll(
                Arrays.asList("Hello", "World!,", "This", "is", "Spring", "Boot"));
        assertEquals("Hello World!, This is Spring Boot", wordJoiner.join(stringAnswer));
    }
}