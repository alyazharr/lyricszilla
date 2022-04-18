package id.ac.ui.cs.advprog.tkadpro.core.GameType;

import id.ac.ui.cs.advprog.tkadpro.core.Level;
import id.ac.ui.cs.advprog.tkadpro.core.util.BlankFeature;
import id.ac.ui.cs.advprog.tkadpro.rest.SongDTO;

import java.util.*;

public class WordsBlank extends GameType {

    public WordsBlank(SongDTO[] allSongs) {
        super(allSongs);
    }

    @Override
    public List<String> getEasyQnA() {
        SongDTO song = allSongs[random.nextInt(allSongs.length)];
        return BlankFeature.generateBlankLine(song, Level.EASY);
    }

    @Override
    public List<String> getMediumQnA() {
        SongDTO song = allSongs[random.nextInt(allSongs.length)];
        return BlankFeature.generateBlankLine(song, Level.MEDIUM);
    }

    @Override
    public List<String> getHardQnA() {
        SongDTO song = allSongs[random.nextInt(allSongs.length)];
        return BlankFeature.generateBlankLine(song, Level.HARD);
    }
}
