package id.ac.ui.cs.advprog.tkadpro.core.GameLevel;

import id.ac.ui.cs.advprog.tkadpro.core.GameType.GameType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class PlayGame {
    public EasyLevelState easyLevelState = new EasyLevelState(this);
    public MediumLevelState mediumLevelState = new MediumLevelState(this);
    public HardLevelState hardLevelState = new HardLevelState(this);
    public GameLevel currentState;
    private int questionCounter = 0;
    private int points = 0;
    private int hp = 100;
    private boolean isFinished;


    public String play() {
        questionCounter++;
        return currentState.play();
    }

    public boolean checkAnswer(List<String> playerAnswer){
        return currentState.checkAnswer(playerAnswer);
    }

    public void changeState() {
        currentState.changeState();
    }

    public void setGameType(GameType gameType){
        easyLevelState.setGameType(gameType);
        mediumLevelState.setGameType(gameType);
        hardLevelState.setGameType(gameType);
    }
}
