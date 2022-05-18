package id.ac.ui.cs.advprog.tkadpro.core.game_type;

import id.ac.ui.cs.advprog.tkadpro.core.Level;
import id.ac.ui.cs.advprog.tkadpro.core.game_level.GameLevel;
import id.ac.ui.cs.advprog.tkadpro.core.game_level.PlayGame;
import id.ac.ui.cs.advprog.tkadpro.rest.SongDTO;

import java.util.*;

public class WordsBlank extends GameType {
    public WordsBlank(SongDTO[] allSongs) {
        super(allSongs);
    }

    @Override
    public List<String> getEasyQnA() {
        var song = allSongs[random.nextInt(allSongs.length)];
        return blankFeature.generateQnA(song, TypeGame.WORDSBLANK, Level.EASY);
    }

    @Override
    public List<String> getMediumQnA() {
        var song = allSongs[random.nextInt(allSongs.length)];
        return blankFeature.generateQnA(song, TypeGame.WORDSBLANK, Level.MEDIUM);
    }

    @Override
    public List<String> getHardQnA() {
        var song = allSongs[random.nextInt(allSongs.length)];
        return blankFeature.generateQnA(song, TypeGame.WORDSBLANK, Level.HARD);
    }

    @Override
    public String toString() {
        return "Wordsblank";
    }

    @Override
    public void useHint(GameLevel currentState, PlayGame playGame) {
        List<String> listOfAns = currentState.getAnswers();
        List<String> listOfHint = currentState.getHintAnswers();

        if (playGame.getHintCounter() > 1) {
            for (var i = 0; i < listOfAns.size(); i++) {
                if (listOfAns.get(i).length() >= playGame.getHintCounter()) {
                    listOfHint.set(i, listOfAns.get(i).substring(0, playGame.getHintCounter()));
                }
            }
        }
        currentState.setHintAnswers(listOfHint);
    }
}