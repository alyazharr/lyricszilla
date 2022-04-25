package id.ac.ui.cs.advprog.tkadpro.core.game_type;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTypeTest {
    private Class<?> gameTypeClass;

    @BeforeEach
    public void setUp() throws Exception {
        gameTypeClass = Class.forName("id.ac.ui.cs.advprog.tkadpro.core.game_type.GameType");
    }

    @Test
    void testGameTypeIsAbstractClass() {
        assertTrue(Modifier.isAbstract(gameTypeClass.getModifiers()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"getEasyQnA", "getMediumQnA", "getHardQnA"})
    void testGameTypeHasGetQnAAbstractMethod(String argument) throws Exception {
        Method getEasyQnA = gameTypeClass.getDeclaredMethod(argument);
        int methodModifiers = getEasyQnA.getModifiers();

        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(0, getEasyQnA.getParameterCount());
    }
}
