package id.ac.ui.cs.advprog.tkadpro.core.gamelevel;

import id.ac.ui.cs.advprog.tkadpro.core.gametype.GameType;
import id.ac.ui.cs.advprog.tkadpro.core.modifier.MediumModifier;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MediumLevelState extends GameLevel{
    private GameType gameType;
    private String question;

    public MediumLevelState(PlayGame playGame){
        super(playGame);
        modifier = new MediumModifier(5, 30, 15);
    }

    @Override    public String play() {
        var mediumQnA = gameType.getMediumQnA();
        question = mediumQnA.get(0);
        answers = mediumQnA.subList(1,-1);

        return question;
    }

    @Override
    public void changeState() {
        if(playGame.getQuestionCounter()==10){
            playGame.setCurrentState(playGame.getHardLevelState());
        }
    }

    @Override
    public int getNumberOfAnswer() {
        return 3;
    }

    @Override
    public String toString() {
        return "MEDIUM";
    }
}
