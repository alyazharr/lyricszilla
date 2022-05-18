package id.ac.ui.cs.advprog.tkadpro.core.modifier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.*;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class AbstractModifierTest {
    private Class<?> abstractModifierClass;

    @BeforeEach
    public void setUp() throws Exception {
        abstractModifierClass = Class.forName("id.ac.ui.cs.advprog.tkadpro.core.modifier.AbstractModifier");
    }

    @Test
    void testAbstractModifierIsAbstractClass() {
        assertTrue(Modifier.isAbstract(abstractModifierClass.getModifiers()));
    }

    @Test
    void testAbstractModifierHasGetDecrementPointMethod() throws Exception {
        Method getDecrementPoint = abstractModifierClass.getDeclaredMethod("getDecrementPoint");
        int methodModifiers = getDecrementPoint.getModifiers();

        assertFalse(Modifier.isAbstract(methodModifiers));
        assertEquals(0, getDecrementPoint.getParameterCount());
    }

    @Test
    void testAbstractModifierHasGetIncrementPointMethod() throws Exception {
        Method getIncrementPoint = abstractModifierClass.getDeclaredMethod("getIncrementPoint");
        int methodModifiers = getIncrementPoint.getModifiers();

        assertFalse(Modifier.isAbstract(methodModifiers));
        assertEquals(0, getIncrementPoint.getParameterCount());
    }

    @Test
    void testAbstractModifierHasGetDecrementHPMethod() throws Exception {
        Method getDecrementHP = abstractModifierClass.getDeclaredMethod("getDecrementHP");
        int methodModifiers = getDecrementHP.getModifiers();

        assertFalse(Modifier.isAbstract(methodModifiers));
        assertEquals(0, getDecrementHP.getParameterCount());
    }

    @Test
    void testAbstractModifierIsAModifier(){
        Collection<Type> interfaces = Arrays.asList(abstractModifierClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tkadpro.core.modifier.Modifier")));
    }



}
