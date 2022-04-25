package id.ac.ui.cs.advprog.tkadpro.core.game_type;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTypeTest {
    private Class<?> gameTypeClass;

    @BeforeEach
    public void setUp() throws Exception {
        gameTypeClass = Class.forName("id.ac.ui.cs.advprog.tkadpro.core.game_type.GameType");
    }

    @Test
    public void testGameTypeIsAbstractClass() {
        assertTrue(Modifier.isAbstract(gameTypeClass.getModifiers()));
    }

    @Test
    public void testGameTypeHasGetEasyQnAAbstractMethod() throws Exception {
        Method getEasyQnA = gameTypeClass.getDeclaredMethod("getEasyQnA");
        int methodModifiers = getEasyQnA.getModifiers();

        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(0, getEasyQnA.getParameterCount());
    }

    @Test
    public void testGameTypeHasGetMediumQnAAbstractMethod() throws Exception {
        Method getEasyQnA = gameTypeClass.getDeclaredMethod("getMediumQnA");
        int methodModifiers = getEasyQnA.getModifiers();

        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(0, getEasyQnA.getParameterCount());
    }

    @Test
    public void testGameTypeHasGetHardQnAAbstractMethod() throws Exception {
        Method getEasyQnA = gameTypeClass.getDeclaredMethod("getHardQnA");
        int methodModifiers = getEasyQnA.getModifiers();

        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(0, getEasyQnA.getParameterCount());
    }
}
