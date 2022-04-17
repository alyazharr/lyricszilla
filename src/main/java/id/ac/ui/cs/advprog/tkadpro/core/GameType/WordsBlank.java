package id.ac.ui.cs.advprog.tkadpro.core.GameType;

import id.ac.ui.cs.advprog.tkadpro.rest.SongDTO;

import java.util.List;

public class WordsBlank extends GameType {
    public WordsBlank(SongDTO[] allSongs) {
        super(allSongs);
    }

    @Override
    public List<String> getEasyQnA() {
        return null;
    }

    @Override
    public List<String> getMediumQnA() {
        return null;
    }

    @Override
    public List<String> getHardQnA() {
        return null;
    }
}
