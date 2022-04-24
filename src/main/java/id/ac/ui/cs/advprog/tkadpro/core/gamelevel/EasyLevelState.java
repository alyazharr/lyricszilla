package id.ac.ui.cs.advprog.tkadpro.core.gamelevel;

import id.ac.ui.cs.advprog.tkadpro.core.gametype.GameType;
import id.ac.ui.cs.advprog.tkadpro.core.modifier.EasyModifier;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EasyLevelState extends GameLevel {
    private GameType gameType;
    private String question;
    private String answer;

    public EasyLevelState(PlayGame playGame){
        super(playGame);
        modifier = new EasyModifier(3, 10, 10);
    }

    @Override
    public String play() {
        var easyQnA = gameType.getEasyQnA();
        question = easyQnA.get(0);
        answer = easyQnA.get(1);

        return question;
    }

    @Override
    public boolean checkAnswer(List<String> playerAnswer){
        boolean feedback = false;

        if(answer.equals(playerAnswer.get(0))){
            feedback = true;
            playGame.setPoints(playGame.getPoints() + modifier.getIncrementPoint());
        }
        else {
            playGame.setPoints(playGame.getPoints() - modifier.getDecrementPoint());
            playGame.setHp(playGame.getHp() - modifier.getDecrementHP());
        }

        return feedback;
    }

    @Override
    public int getNumberOfAnswer() {
        return 1;
    }

    @Override
    public void changeState() {
        if(playGame.getQuestionCounter()==3){
            playGame.setCurrentState(playGame.getMediumLevelState());
        }
    }

    @Override
    public String toString() {
        return "EASY";
    }
}
