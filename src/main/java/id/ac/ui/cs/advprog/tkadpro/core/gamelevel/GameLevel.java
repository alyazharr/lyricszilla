package id.ac.ui.cs.advprog.tkadpro.core.gamelevel;

import id.ac.ui.cs.advprog.tkadpro.core.modifier.Modifier;
import lombok.Data;

import java.util.List;

@Data
public abstract class GameLevel {
    protected PlayGame playGame;
    protected Modifier modifier;
    protected List<String> answers;

    protected GameLevel(PlayGame playGame){
        this.playGame = playGame;
    }

    public abstract String play();
    public abstract void changeState();
    public abstract int getNumberOfAnswer();

    public boolean checkAnswer(List<String> playerAnswer) {
        var feedback = true;

        for(var i = 0;i<answers.size() && feedback;i++){
            if (!answers.get(i).equals(playerAnswer.get(i)))
                feedback = false;
        }

        if(feedback){
            playGame.setPoints(playGame.getPoints() + modifier.getIncrementPoint());
        } else {
            playGame.setPoints(playGame.getPoints() - modifier.getDecrementPoint());
            playGame.setHp(playGame.getHp() - modifier.getDecrementHP());
        }

        return feedback;
    }
}
