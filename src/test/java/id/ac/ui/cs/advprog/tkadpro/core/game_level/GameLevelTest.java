package id.ac.ui.cs.advprog.tkadpro.core.game_level;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Modifier;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class GameLevelTest {
    private Class<?> GameLevelClass;

    @BeforeEach
    void setUp() throws Exception {
        GameLevelClass = Class.forName("id.ac.ui.cs.advprog.tkadpro.core.game_level.GameLevel");
    }

    @Test
    void testGameLevelIsAbstractClass() {
        assertTrue(Modifier.isAbstract(GameLevelClass.getModifiers()));
    }
}
