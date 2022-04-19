package id.ac.ui.cs.advprog.tkadpro.core.GameType;

import id.ac.ui.cs.advprog.tkadpro.rest.SongDTO;

import java.util.*;

public abstract class GameType {
    protected SongDTO[] allSongs;
    protected Random random;

    protected GameType(SongDTO[] allSongs) {
        this.allSongs = allSongs;
        random = new Random();
    }

    public abstract List<String> getEasyQnA();
    public abstract List<String> getMediumQnA();
    public abstract List<String> getHardQnA();
}
