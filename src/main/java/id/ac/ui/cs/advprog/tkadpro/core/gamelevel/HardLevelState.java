package id.ac.ui.cs.advprog.tkadpro.core.gamelevel;

import id.ac.ui.cs.advprog.tkadpro.core.gametype.GameType;
import id.ac.ui.cs.advprog.tkadpro.core.modifier.HardModifier;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HardLevelState extends GameLevel{
    private GameType gameType;
    private String question;

    protected HardLevelState(PlayGame playGame) {
        super(playGame);
        modifier = new HardModifier(10, 50, 20);
    }

    @Override
    public String play() {
        var hardQnA = gameType.getHardQnA();
        question = hardQnA.get(0);
        answers = hardQnA.subList(1,-1);

        return question;
    }

    @Override
    public void changeState() {
        if(playGame.getQuestionCounter()==20)
            playGame.setFinished(true);
    }

    @Override
    public int getNumberOfAnswer() {
        return 5;
    }

    @Override
    public String toString() {
        return "HARD";
    }
}
