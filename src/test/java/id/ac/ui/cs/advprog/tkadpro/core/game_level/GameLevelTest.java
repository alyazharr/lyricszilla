package id.ac.ui.cs.advprog.tkadpro.core.game_level;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class GameLevelTest {
    private Class<?> GameLevelClass;

    @BeforeEach
    public void setUp() throws Exception {
        GameLevelClass = Class.forName("id.ac.ui.cs.advprog.tkadpro.core.game_level.GameLevel");
    }

    @Test
    void testGameLevelIsAbstractClass() {
        assertTrue(Modifier.isAbstract(GameLevelClass.getModifiers()));
    }
}
