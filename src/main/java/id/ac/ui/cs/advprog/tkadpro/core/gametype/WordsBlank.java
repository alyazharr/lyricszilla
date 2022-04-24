package id.ac.ui.cs.advprog.tkadpro.core.GameType;

import id.ac.ui.cs.advprog.tkadpro.core.Level;
import id.ac.ui.cs.advprog.tkadpro.core.tools.BlankFeature;
import id.ac.ui.cs.advprog.tkadpro.core.tools.BlankFeatureImpl;
import id.ac.ui.cs.advprog.tkadpro.rest.SongDTO;

import java.util.*;

public class WordsBlank extends GameType {
    BlankFeature blankFeature;

    public WordsBlank(SongDTO[] allSongs) {
        super(allSongs);
        blankFeature = new BlankFeatureImpl();
    }

    @Override
    public List<String> getEasyQnA() {
        var song = allSongs[random.nextInt(allSongs.length)];
        return blankFeature.generateBlankLine(song, TypeGame.WORDSBLANK, Level.EASY);
    }

    @Override
    public List<String> getMediumQnA() {
        var song = allSongs[random.nextInt(allSongs.length)];
        return blankFeature.generateBlankLine(song, TypeGame.WORDSBLANK, Level.MEDIUM);
    }

    @Override
    public List<String> getHardQnA() {
        var song = allSongs[random.nextInt(allSongs.length)];
        return blankFeature.generateBlankLine(song, TypeGame.WORDSBLANK, Level.HARD);
    }
}
