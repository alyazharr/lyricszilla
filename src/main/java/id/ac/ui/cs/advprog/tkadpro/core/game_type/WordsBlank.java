package id.ac.ui.cs.advprog.tkadpro.core.game_type;

import id.ac.ui.cs.advprog.tkadpro.core.Level;
import id.ac.ui.cs.advprog.tkadpro.core.game_level.GameLevel;
import id.ac.ui.cs.advprog.tkadpro.core.game_level.PlayGame;
import id.ac.ui.cs.advprog.tkadpro.core.tools.BlankFeatureImpl;
import id.ac.ui.cs.advprog.tkadpro.rest.SongDTO;

import java.util.*;

public class WordsBlank extends GameType {
    public WordsBlank(SongDTO[] allSongs) {
        super(allSongs);
        blankFeature = new BlankFeatureImpl();
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

        if (playGame.getHintCounter() == 2) {
            for (int i = 0; i < listOfAns.size(); i++) {
                if (listOfAns.get(i).length() > 1) {
                    listOfHint.set(i, listOfAns.get(i).substring(0, 2));
                }
            }

        } else  if (playGame.getHintCounter() == 3) {
            for (int i = 0; i < listOfAns.size(); i++) {
                if (listOfAns.get(i).length() > 2) {
                    listOfHint.set(i, listOfAns.get(i).substring(0, 3));
                }
            }
        }
        currentState.setHintAnswers(listOfHint);
    }
}