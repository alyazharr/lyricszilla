package id.ac.ui.cs.advprog.tkadpro.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HintInfoTest {
    private Class<?> hintInfoClass;
    private HintInfo hintInfo;

    @BeforeEach
    void setUp() throws Exception {
        hintInfoClass = Class.forName("id.ac.ui.cs.advprog.tkadpro.model.HintInfo");
    }

    @Test
    void hintInfoClassIsConcreteClass() {
        assertFalse(Modifier.isAbstract(hintInfoClass.getModifiers()));
    }

    @Test
    void hintInfoClassShouldReturnCorrectly() {
        hintInfo = new HintInfo(Arrays.asList("World", "Hello"), 2, 90);

        assertEquals(90, hintInfo.getPoint());
        assertEquals(2, hintInfo.getNumHint());
        assertEquals(Arrays.asList("World", "Hello"), hintInfo.getHintAnswer());
    }

    @Test
    void hintInfoClassShouldReturnGetternSetterCorrectly() {
        hintInfo = new HintInfo(Arrays.asList("World", "Hello"), 2, 90);
        hintInfo.setPoint(50);
        hintInfo.setNumHint(1);
        hintInfo.setHintAnswer(List.of("World"));

        assertEquals(50, hintInfo.getPoint());
        assertEquals(1, hintInfo.getNumHint());
        assertEquals(List.of("World"), hintInfo.getHintAnswer());
    }
}
