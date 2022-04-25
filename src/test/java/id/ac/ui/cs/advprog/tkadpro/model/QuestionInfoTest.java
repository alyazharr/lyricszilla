package id.ac.ui.cs.advprog.tkadpro.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class QuestionInfoTest {
    private QuestionInfo questionInfo;

    @Test
    public void constructorTest(){
        questionInfo = new QuestionInfo(2,50,3,
                "MEDIUM","Test",80);

        assertEquals(2,questionInfo.getQuestionNumber());
        assertEquals(50, questionInfo.getScore());
        assertEquals(3, questionInfo.getNumberOfAnswer());
        assertEquals("MEDIUM", questionInfo.getLevel());
        assertEquals("Test", questionInfo.getQuestion());
        assertEquals(80, questionInfo.getHp());
        assertEquals(QuestionInfo.class, questionInfo.getClass());
    }
}
