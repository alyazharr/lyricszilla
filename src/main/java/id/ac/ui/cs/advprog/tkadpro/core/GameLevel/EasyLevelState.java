package id.ac.ui.cs.advprog.tkadpro.core.GameLevel;

import id.ac.ui.cs.advprog.tkadpro.core.GameType.GameType;
import id.ac.ui.cs.advprog.tkadpro.core.Modifier.EasyModifier;
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
        var EasyQnA = gameType.getEasyQnA();
        question = EasyQnA.get(0);
        answer = EasyQnA.get(1);
        System.out.println("question " + question);
        System.out.println("answer [" + answer + "]");

        return question;
    }

    @Override
    public boolean checkAnswer(List<String> playerAnswer){
//        System.out.println("ANS USER: " + playerAnswer.get(0));
//        System.out.println("ANS ASLI: " + answer);
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
        if(playGame.getQuestionCounter() == 4){
            playGame.setCurrentState(playGame.mediumLevelState);
        }
    }

    @Override
    public String toString() {
        return "EASY";
    }
}
