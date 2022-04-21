package id.ac.ui.cs.advprog.tkadpro.core.GameLevel;

import id.ac.ui.cs.advprog.tkadpro.core.GameType.GameType;
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
    }

    @Override
    public String play() {
        var EasyQnA = gameType.getEasyQnA();
        question = EasyQnA.get(0);
        answer = EasyQnA.get(1);

        return question;
    }

    @Override
    public boolean checkAnswer(List<String> playerAnswer){
        boolean feedback = false;

        if(answer.equals(playerAnswer.get(0))){
            feedback = true;
            playGame.setPoints(playGame.getPoints()+10);
        }
        else {
            playGame.setPoints(playGame.getPoints()-3);
            playGame.setHp(playGame.getHp()-10);
        }

        return feedback;
    }

    @Override
    public void changeState() {
        if(playGame.getQuestionCounter()==3){
            playGame.setCurrentState(playGame.mediumLevelState);
        }
    }
}
