package id.ac.ui.cs.advprog.tkadpro.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class SongDTOTest {
    private Class<?> songDTOClass;
    @BeforeEach
    public void setUp() throws Exception {
        songDTOClass = Class.forName("id.ac.ui.cs.advprog.tkadpro.rest.SongDTO");
    }

    @Test
    public void testSongDTOIsNotAbstractClass() {
        assertFalse(Modifier.isAbstract(songDTOClass.getModifiers()));
    }

    @Test
    public void testSongDTOIsPublic() {
        int classModifiers = songDTOClass.getModifiers();

        assertTrue(Modifier.isPublic(classModifiers));
    }
}