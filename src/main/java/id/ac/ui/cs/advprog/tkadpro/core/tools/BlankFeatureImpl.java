package id.ac.ui.cs.advprog.tkadpro.core.tools;

import id.ac.ui.cs.advprog.tkadpro.core.gametype.TypeGame;
import id.ac.ui.cs.advprog.tkadpro.core.Level;
import id.ac.ui.cs.advprog.tkadpro.rest.SongDTO;

import java.security.SecureRandom;
import java.util.*;

public class BlankFeatureImpl implements BlankFeature {
    private static final SecureRandom random = new SecureRandom();
    private static final int MAXSIZE = 15;
    private static final String NEWLINE = "\r\n";
    private static final String SPACE = " ";
    private Joiner lineJoiner;
    private Parser lineParser;
    private Joiner wordJoiner;
    private Parser wordParser;

    public BlankFeatureImpl(){
        lineJoiner = new Joiner(NEWLINE);
        lineParser = new Parser(NEWLINE);
        wordJoiner = new Joiner(SPACE);
        wordParser = new Parser(SPACE);
    }

    private List<String> getRealProcessLyric(SongDTO song) {
        String lyric = song.getLirik();
        List<String> rawLyric = lineParser.parseSentence(lyric);

        var startPresentLine = random.nextInt( Math.max( 1, rawLyric.size() - MAXSIZE));

        return rawLyric.subList(startPresentLine, startPresentLine + MAXSIZE);
    }

    @Override
    public List<String> generateQnA(SongDTO song, TypeGame typeGame, Level level) {
        Map<Integer, Boolean> traceLineLocation = new HashMap<>();
        List<String> realPresentLyric = getRealProcessLyric(song);

        int numLoop =  level.equals(Level.EASY) ? 1 : level.equals(Level.MEDIUM) ? 3 : 5;
        List<String> questionAnswer = new ArrayList<>(numLoop + 1);

        for (var i = 0; i < numLoop; i++) {
            int targetBlankLineLocation = getValidTargetBlankLineLocation(traceLineLocation,
                    realPresentLyric, level, realPresentLyric.size(), i);
            String targetBlankWord = realPresentLyric.get(targetBlankLineLocation);

            generateBlankLineForSpecificGameType(typeGame, realPresentLyric, questionAnswer, targetBlankWord, i, targetBlankLineLocation);
        }

        String question = lineJoiner.join(realPresentLyric);
        questionAnswer.add(0, question);

        return questionAnswer;
    }

    private List<String> generateBlankWordsAndAnswer(List<String> parserBlankWordResult, int i) {
        List<String> blankWordsAndAnswer = new ArrayList<>(2);
        var wordsBlankLocation = random.nextInt(parserBlankWordResult.size());
        String answer = parserBlankWordResult.get(wordsBlankLocation);
        parserBlankWordResult.set(wordsBlankLocation, String.format("(%d) _ _ _", i + 1));

        blankWordsAndAnswer.add(wordJoiner.join(parserBlankWordResult));
        blankWordsAndAnswer.add(answer);

        return blankWordsAndAnswer;
    }

    private int getValidTargetBlankLineLocation(
            Map<Integer, Boolean> traceLineLocation,
            List<String> realPresentLyric,
            Level level,
            int size,
            int i) {

        int intervalEnhancer;
        if (level.equals(Level.EASY)) {
            intervalEnhancer =  size;
        }

        intervalEnhancer = level.equals(Level.MEDIUM) ? 5 : 3;
        int blankLineLocation = random.nextInt(intervalEnhancer) + (i * intervalEnhancer);
        traceLineLocation.put(blankLineLocation, true);

        // handle get empty line before produce blank words in that line
        if (realPresentLyric.get(blankLineLocation).length() == 0) {
            blankLineLocation = random.nextInt(intervalEnhancer) + (i * intervalEnhancer);
            while (traceLineLocation.get(blankLineLocation) != null || realPresentLyric.get(blankLineLocation).length() == 0) {
                blankLineLocation = random.nextInt(intervalEnhancer) + (i * intervalEnhancer);
            }
        }

        return blankLineLocation;
    }

    private void generateBlankLineForSpecificGameType(
            TypeGame typeGame,
            List<String> lyrics,
            List<String> questionAnswer,
            String targetBlankWord,
            int  i,
            int targetBlankLocation) {

        if (typeGame.equals(TypeGame.WORDSBLANK)) {
            List<String> parserBlankLineResult = wordParser.parseSentence(targetBlankWord);
            List<String> blankWordsAndAnswerResult = generateBlankWordsAndAnswer(parserBlankLineResult, i);

            //* join with realPresentLyric
            lyrics.set(targetBlankLocation, blankWordsAndAnswerResult.get(0));
            questionAnswer.add(blankWordsAndAnswerResult.get(1));

        } else if (typeGame.equals(TypeGame.LYRICSPATCH)) {
            lyrics.set(targetBlankLocation, String.format("(%d) _ _ _ _ _ _ _ _", i + 1));
            questionAnswer.add(targetBlankWord);
        }
    }
}
