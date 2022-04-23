package id.ac.ui.cs.advprog.tkadpro.core.GameType;

import id.ac.ui.cs.advprog.tkadpro.rest.SongDTO;

import java.security.SecureRandom;
import java.util.*;

public abstract class GameType {
    protected SongDTO[] allSongs;
    protected SecureRandom random;

    protected GameType(SongDTO[] allSongs) {
        this.allSongs = allSongs;
        random = new SecureRandom();
    }

    public abstract List<String> getEasyQnA();
    public abstract List<String> getMediumQnA();
    public abstract List<String> getHardQnA();
}
