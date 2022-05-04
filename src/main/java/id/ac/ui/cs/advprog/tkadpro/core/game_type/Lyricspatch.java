package id.ac.ui.cs.advprog.tkadpro.core.game_type;

import id.ac.ui.cs.advprog.tkadpro.core.Level;
import id.ac.ui.cs.advprog.tkadpro.core.game_level.GameLevel;
import id.ac.ui.cs.advprog.tkadpro.core.game_level.PlayGame;
import id.ac.ui.cs.advprog.tkadpro.core.tools.Joiner;
import id.ac.ui.cs.advprog.tkadpro.core.tools.Parser;
import id.ac.ui.cs.advprog.tkadpro.rest.SongDTO;

import java.util.*;

public class Lyricspatch extends GameType {
    private static final String SPACE = " ";
    private final Joiner wordJoiner;
    private final Parser wordParser;

    public Lyricspatch(SongDTO[] allSongs) {
        super(allSongs);
        wordJoiner = new Joiner(SPACE);
        wordParser = new Parser(SPACE);
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

        if (playGame.getHintCounter() > 1) {
            for (var i = 0; i < listOfAns.size(); i++) {
                if (listOfAns.get(i).length() >= playGame.getHintCounter()) {
                    tempHint = wordParser.parseSentence(listOfAns.get(i));
                    listOfHint.set(i, wordJoiner.join(tempHint.subList(0, playGame.getHintCounter())));
                }
            }
        }
    }
}