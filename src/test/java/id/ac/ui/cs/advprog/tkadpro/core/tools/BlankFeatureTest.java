package id.ac.ui.cs.advprog.tkadpro.core.tools;

import id.ac.ui.cs.advprog.tkadpro.core.Level;
import id.ac.ui.cs.advprog.tkadpro.core.game_type.TypeGame;
import id.ac.ui.cs.advprog.tkadpro.rest.SongDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;


public class BlankFeatureTest {
    private Class<?> blankFeatureClass;

    @BeforeEach
    public void setup() throws Exception {
        blankFeatureClass = Class.forName("id.ac.ui.cs.advprog.tkadpro.core.tools.BlankFeature");
    }

    @Test
    public void testBlankFeatureIsAPublicInterface() {
        int classModifiers = blankFeatureClass.getModifiers();

        assertTrue(Modifier.isPublic(classModifiers));
        assertTrue(Modifier.isInterface(classModifiers));
    }

    @Test
    public void testItemHasGenerateQnAAbstractMethod() throws Exception {
        Method getName = blankFeatureClass.getDeclaredMethod("generateQnA", SongDTO.class, TypeGame.class, Level.class);
        int methodModifiers = getName.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(3, getName.getParameterCount());
    }
}