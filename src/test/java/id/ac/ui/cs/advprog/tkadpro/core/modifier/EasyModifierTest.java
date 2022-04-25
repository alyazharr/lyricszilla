package id.ac.ui.cs.advprog.tkadpro.core.modifier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class EasyModifierTest {
    private Class<?> easyModifierClass;
    private Class<?> abstractModifierClass;

    @BeforeEach
    public void setUp() throws Exception {
        easyModifierClass = Class.forName("id.ac.ui.cs.advprog.tkadpro.core.modifier.EasyModifier");
        abstractModifierClass = Class.forName("id.ac.ui.cs.advprog.tkadpro.core.modifier.AbstractModifier");
    }

    @Test
    void testEasyModifierIsConcreteClass() {
        assertFalse(Modifier.isAbstract(easyModifierClass.getModifiers()));
    }

    @Test
    void testEasyModifierIsAExtendsFromAbstractModifier(){
        assertTrue(abstractModifierClass.isAssignableFrom(easyModifierClass));
    }
}
