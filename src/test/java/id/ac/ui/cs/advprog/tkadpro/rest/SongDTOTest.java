package id.ac.ui.cs.advprog.tkadpro.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class SongDTOTest {
    private Class<?> songDTOClass;
    private SongDTO[] songDTO = new SongDTO[1];

    @BeforeEach
     void setUp() throws Exception {
        songDTOClass = Class.forName("id.ac.ui.cs.advprog.tkadpro.rest.SongDTO");
        songDTO[0] = new SongDTO("Let Her Go", "Passenger",
                "All the Little Lights", "Well, you only need the light when it's burning low\r\n" +
                "Only miss the sun when it starts to snow\r\n" +
                "Only know you love her when you let her go\r\n" +
                "Only know you've been high when you're feeling low\r\n" +
                "Only hate the road when you're missing home\r\n" +
                "Only know you love her when you let her go\r\n" +
                "And you let her go\r\n" +
                "Staring at the bottom of your glass\r\n" +
                "Hoping one day you'll make a dream last\r\n" +
                "But dreams come slow, and they go so fast\r\n" +
                "You see her when you close your eyes\r\n" +
                "Maybe one day, you'll understand why\r\n" +
                "Everything you touch surely dies\r\n" +
                "But you only need the light when it's burning low\r\n" +
                "Only miss the sun when it starts to snow\r\n" +
                "Only know you love her when you let her go\r\n" +
                "Only know you've been high when you're feeling low\r\n" +
                "Only hate the road when you're missing home\r\n" +
                "Only know you love her when you let her go");
    }

    @Test
    void testSongDTOIsNotAbstractClass() {
        assertFalse(Modifier.isAbstract(songDTOClass.getModifiers()));
    }

    @Test
    void testSongDTOIsPublic() {
        int classModifiers = songDTOClass.getModifiers();

        assertTrue(Modifier.isPublic(classModifiers));
    }

    @Test
    void testCorectlyReturn() {
        assertFalse(songDTO[0].isTaken());
        assertEquals("Let Her Go", songDTO[0].getJudul());
        assertEquals("Passenger", songDTO[0].getPenyanyi());
        assertEquals("All the Little Lights", songDTO[0].getAlbum());

        songDTO[0].setJudul("Heelo World");
        songDTO[0].setPenyanyi("Carnage");
        assertEquals("Heelo World", songDTO[0].getJudul());
        assertEquals("Carnage", songDTO[0].getPenyanyi());
    }
}