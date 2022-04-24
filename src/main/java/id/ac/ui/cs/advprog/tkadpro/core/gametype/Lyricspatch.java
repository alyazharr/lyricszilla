package id.ac.ui.cs.advprog.tkadpro.core.GameType;

import id.ac.ui.cs.advprog.tkadpro.core.Level;
import id.ac.ui.cs.advprog.tkadpro.core.tools.BlankFeature;
import id.ac.ui.cs.advprog.tkadpro.core.tools.BlankFeatureImpl;
import id.ac.ui.cs.advprog.tkadpro.rest.SongDTO;

import java.util.*;

public class Lyricspatch extends GameType {
    BlankFeature blankFeature;

    public Lyricspatch(SongDTO[] allSongs) {
        super(allSongs);
        blankFeature = new BlankFeatureImpl();
    }

    @Override
    public List<String> getEasyQnA() {
        var song = allSongs[random.nextInt(allSongs.length)];
        return blankFeature.generateBlankLine(song, TypeGame.LYRICSPATCH, Level.EASY);
    }

    @Override
    public List<String> getMediumQnA() {
        var song = allSongs[random.nextInt(allSongs.length)];
        return blankFeature.generateBlankLine(song, TypeGame.LYRICSPATCH, Level.MEDIUM);
    }

    @Override
    public List<String> getHardQnA() {
        var song = allSongs[random.nextInt(allSongs.length)];
        return blankFeature.generateBlankLine(song, TypeGame.LYRICSPATCH, Level.HARD);
    }
}