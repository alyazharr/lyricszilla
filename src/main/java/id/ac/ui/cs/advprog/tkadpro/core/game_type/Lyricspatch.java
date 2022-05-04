package id.ac.ui.cs.advprog.tkadpro.core.game_type;

import id.ac.ui.cs.advprog.tkadpro.core.Level;
import id.ac.ui.cs.advprog.tkadpro.core.game_level.GameLevel;
import id.ac.ui.cs.advprog.tkadpro.core.game_level.PlayGame;
import id.ac.ui.cs.advprog.tkadpro.core.tools.BlankFeatureImpl;
import id.ac.ui.cs.advprog.tkadpro.rest.SongDTO;

import java.util.*;

public class Lyricspatch extends GameType {
    public Lyricspatch(SongDTO[] allSongs) {
        super(allSongs);
        blankFeature = new BlankFeatureImpl();
    }

    @Override
    public List<String> getEasyQnA() {
        var song = allSongs[random.nextInt(allSongs.length)];
        return blankFeature.generateQnA(song, TypeGame.LYRICSPATCH, Level.EASY);
    }

    @Override
    public List<String> getMediumQnA() {
        var song = allSongs[random.nextInt(allSongs.length)];
        return blankFeature.generateQnA(song, TypeGame.LYRICSPATCH, Level.MEDIUM);
    }

    @Override
    public List<String> getHardQnA() {
        var song = allSongs[random.nextInt(allSongs.length)];
        return blankFeature.generateQnA(song, TypeGame.LYRICSPATCH, Level.HARD);
    }

    @Override
    public String toString() {
        return "Lyricspatch";
    }

    @Override
    public void useHint(GameLevel currentState, PlayGame playGame) {
        List<String> listOfAns = currentState.getAnswers();
        List<String> listOfHint = currentState.getHintAnswers();
        List<String> tempHint;

        if (playGame.getHintCounter() == 2) {
            for (int i = 0; i < listOfAns.size(); i++) {
                if (listOfAns.get(i).length() > 1) {
                    tempHint = Arrays.asList(listOfAns.get(i).split(" "));
                    listOfHint.set(i, String.join(" ", tempHint.subList(0, 2)));
                }
            }

        } else  if (playGame.getHintCounter() == 3) {
            for (int i = 0; i < listOfAns.size(); i++) {
                if (listOfAns.get(i).length() > 2) {
                    tempHint = Arrays.asList(listOfAns.get(i).split(" "));
                    listOfHint.set(i, String.join(" ", tempHint.subList(0, 3)));
                }
            }
        }
        currentState.setHintAnswers(listOfHint);
    }
}