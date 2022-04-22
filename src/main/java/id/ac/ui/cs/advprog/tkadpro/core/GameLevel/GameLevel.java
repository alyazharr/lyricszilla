package id.ac.ui.cs.advprog.tkadpro.core.GameLevel;

import lombok.Data;

import java.util.List;

@Data
public abstract class GameLevel {
    protected PlayGame playGame;

    protected GameLevel(PlayGame playGame){
        this.playGame = playGame;
    }

    public abstract String play();
    public abstract void changeState();
    public abstract boolean checkAnswer(List<String> answer);
    public abstract int getNumberOfAnswer();
//    public abstract String getAnswer();
//    public abstract String getQuestion();
}
