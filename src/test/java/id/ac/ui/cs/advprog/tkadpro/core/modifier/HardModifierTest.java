package id.ac.ui.cs.advprog.tkadpro.core.modifier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class HardModifierTest {
    private Class<?> hardModifierClass;
    private Class<?> abstractModifierClass;

    @BeforeEach
    public void setUp() throws Exception {
        hardModifierClass = Class.forName("id.ac.ui.cs.advprog.tkadpro.core.modifier.HardModifier");
        abstractModifierClass = Class.forName("id.ac.ui.cs.advprog.tkadpro.core.modifier.AbstractModifier");
    }

    @Test
    public void testEasyModifierIsConcreteClass() {
        assertFalse(Modifier.isAbstract(hardModifierClass.getModifiers()));
    }

    @Test
    public void testEasyModifierIsAExtendsFromAbstractModifier(){
        assertTrue(abstractModifierClass.isAssignableFrom(hardModifierClass));
    }
}
