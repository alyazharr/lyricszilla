package id.ac.ui.cs.advprog.tkadpro.core.game_level;

import id.ac.ui.cs.advprog.tkadpro.core.modifier.Modifier;
import lombok.Data;

import java.util.List;

@Data
public abstract class GameLevel {
    protected PlayGame playGame;
    protected Modifier modifier;
    protected List<String> answers;
    protected String level;
    protected int numOfAnswer;

    protected GameLevel(PlayGame playGame, String level, int numOfAnswer){
        this.playGame = playGame;
        this.level = level;
        this.numOfAnswer = numOfAnswer;
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

    public int getNumberOfAnswer() {
        return numOfAnswer;
    }

    @Override
    public String toString() {
        return level;
    }
}