package id.ac.ui.cs.advprog.tkadpro.core.GameType;

import java.util.*;

public abstract class GameType {
    protected List<String> allSongs;

    public GameType(List<String> allSongs) {
        this.allSongs = allSongs;
    }

    public abstract List<String> getEasyQnA();
    public abstract List<String> getMediumQnA();
    public abstract List<String> getHardQnA();
}
