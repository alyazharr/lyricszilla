package id.ac.ui.cs.advprog.tkadpro.core.game_level;

import id.ac.ui.cs.advprog.tkadpro.core.game_type.GameType;
import id.ac.ui.cs.advprog.tkadpro.model.HintInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class PlayGame {
    private EasyLevelState easyLevelState = new EasyLevelState(this);
    private MediumLevelState mediumLevelState = new MediumLevelState(this);
    private HardLevelState hardLevelState = new HardLevelState(this);
    private GameLevel currentState;
    private int questionCounter = 0;
    private int hintCounter = 0;
    private int points = 0;
    private int hp = 100;
    private boolean isFinished;

    public String play() {
        questionCounter++;
        hintCounter = 0;
        changeState();
        return currentState.play();
    }

    public boolean checkAnswer(List<String> playerAnswer){
        return currentState.checkAnswer(playerAnswer);
    }

    public void changeState() {
        currentState.changeState();
    }

    public HintInfo useHint() {
        hintCounter++;
        currentState.useHint(this);

        return new HintInfo(currentState.getHintAnswers(), hintCounter, points);
    }

    public void setGameType(GameType gameType){
        easyLevelState.setGameType(gameType);
        mediumLevelState.setGameType(gameType);
        hardLevelState.setGameType(gameType);
    }

    public int getNumberOfAnswer(){
        return currentState.getNumberOfAnswer();
    }
}
