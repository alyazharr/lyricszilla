package id.ac.ui.cs.advprog.tkadpro.core.game_level;

import id.ac.ui.cs.advprog.tkadpro.core.game_type.GameType;
import id.ac.ui.cs.advprog.tkadpro.core.modifier.Modifier;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class GameLevel {
    protected PlayGame playGame;
    protected Modifier modifier;
    protected List<String> answers;
    protected List<String> hintAnswers;
    protected String level;
    protected int numOfAnswer;

    protected GameLevel(PlayGame playGame, String level, int numOfAnswer){
        this.playGame = playGame;
        this.level = level;
        this.numOfAnswer = numOfAnswer;
        hintAnswers = new ArrayList<>();
    }

    public abstract String play();
    public abstract void changeState();

    public boolean checkAnswer(List<String> playerAnswer){
        var feedback = true;

        for(var i = 0;i<answers.size() && feedback;i++){
            if(!answers.get(i).equals(playerAnswer.get(i)))
                feedback = false;
        }

        if(feedback){
            playGame.setPoints(playGame.getPoints() + modifier.getIncrementPoint());
        }
        else {
            playGame.setPoints(playGame.getPoints() - modifier.getDecrementPoint());
            playGame.setHp(playGame.getHp() - modifier.getDecrementHP());
        }

        return feedback;
    }

    public void createHintAnswer(GameType gameType) {
        List<String> tempHintAns = new ArrayList<>();
        if (gameType.toString().equals("Wordsblank")) {
            System.out.println("MASUK IF");
            for (String ans : answers) if (ans.length() > 0) tempHintAns.add(ans.substring(0, 1));

            hintAnswers = tempHintAns;

        } else if (gameType.toString().equals("Lyricspatch")) {
            System.out.println("MASUK ELSE IF");
            for (String ans : answers) tempHintAns.add(String.valueOf(ans.split(" ")[0]));

            hintAnswers = tempHintAns;
        }
    }

    public abstract void useHint(PlayGame playGame);

    public int getNumberOfAnswer() {
        return numOfAnswer;
    }

    @Override
    public String toString() {
        return level;
    }
}