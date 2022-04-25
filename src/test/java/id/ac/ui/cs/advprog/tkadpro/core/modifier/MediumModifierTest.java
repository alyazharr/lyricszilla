package id.ac.ui.cs.advprog.tkadpro.core.modifier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class MediumModifierTest {
    private Class<?> mediumModifierClass;
    private Class<?> abstractModifierClass;

    @BeforeEach
    public void setUp() throws Exception {
        mediumModifierClass = Class.forName("id.ac.ui.cs.advprog.tkadpro.core.modifier.MediumModifier");
        abstractModifierClass = Class.forName("id.ac.ui.cs.advprog.tkadpro.core.modifier.AbstractModifier");
    }

    @Test
    public void testEasyModifierIsConcreteClass() {
        assertFalse(Modifier.isAbstract(mediumModifierClass.getModifiers()));
    }

    @Test
    public void testEasyModifierIsAExtendsFromAbstractModifier(){
        assertTrue(abstractModifierClass.isAssignableFrom(mediumModifierClass));
    }
}
