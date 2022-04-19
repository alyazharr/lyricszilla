package id.ac.ui.cs.advprog.tkadpro.core.util;

import id.ac.ui.cs.advprog.tkadpro.core.Level;
import id.ac.ui.cs.advprog.tkadpro.rest.SongDTO;

import java.util.*;

public class BlankFeature {
    private static final Random random = new Random();
    private static final int MAXSIZE = 15;

    private static List<String> getRealProcessLyric(SongDTO song) {
        String lyric = song.getLirik();
        List<String> rawLyric = Arrays.asList(lyric.split("\r\n"));
        int startPresentLine = random.nextInt(rawLyric.size() - MAXSIZE);
        return rawLyric.subList(startPresentLine, startPresentLine + MAXSIZE);
    }

    public static List<String> generateBlankLine(SongDTO song, Level level) {
        Map<Integer, Boolean> traceLineLocation = new HashMap<>();
        List<String> realPresentLyric = getRealProcessLyric(song);
        int numLoop =  level.equals(Level.EASY) ? 1 : level.equals(Level.MEDIUM) ? 3 : 5;
        List<String> QnA = new ArrayList<>(numLoop + 1);

        for (int i = 0; i < numLoop; i++) {
            int blankLineLocation = getValidTargetBlankLineLocation(traceLineLocation, realPresentLyric, level, realPresentLyric.size(), i);

            String targetBlankLineLyric = realPresentLyric.get(blankLineLocation);
            List<String> parserBlankLineResult = Arrays.asList(targetBlankLineLyric.split(" "));
            List<String> blankWordsAndAnswerResult = generateBlankWordsAndAnswer(parserBlankLineResult, i);

            //* join with realPresentLyric
            realPresentLyric.set(blankLineLocation, blankWordsAndAnswerResult.get(0));
            QnA.add(blankWordsAndAnswerResult.get(1));
        }

        String question = String.join("\r\n", realPresentLyric);
        QnA.add(0, question);
        return QnA;
    }

    private static List<String> generateBlankWordsAndAnswer(List<String> parserBlankLineResult, int i) {
        List<String> blankWordsAndAnswer = new ArrayList<>(2);
        int wordsBlankLocation = random.nextInt(parserBlankLineResult.size());
        String answer = parserBlankLineResult.get(wordsBlankLocation);
        parserBlankLineResult.set(wordsBlankLocation, String.format("(%d)_ _ _", i + 1));

        blankWordsAndAnswer.add(String.join(" ", parserBlankLineResult));
        blankWordsAndAnswer.add(answer);
        return blankWordsAndAnswer;
    }

    private static int getValidTargetBlankLineLocation(
            Map<Integer, Boolean> traceLineLocation,
            List<String> realPresentLyric,
            Level level,
            int size,
            int i) {

        int intervalEnhancer = level.equals(Level.EASY) ? size : level.equals(Level.MEDIUM) ? 5 : 3;
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
}
