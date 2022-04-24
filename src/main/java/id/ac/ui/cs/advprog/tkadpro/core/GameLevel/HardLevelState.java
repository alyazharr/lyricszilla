package id.ac.ui.cs.advprog.tkadpro.core.GameLevel;

import id.ac.ui.cs.advprog.tkadpro.core.GameType.GameType;
import id.ac.ui.cs.advprog.tkadpro.core.Modifier.HardModifier;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HardLevelState extends GameLevel{
    private GameType gameType;
    private String question;
    private List<String> answers;

    protected HardLevelState(PlayGame playGame) {
        super(playGame);
        modifier = new HardModifier(10, 50, 20);
    }

    @Override
    public String play() {
        var hardQnA = gameType.getHardQnA();
        question = hardQnA.get(0);
        answers = hardQnA.subList(1,hardQnA.size());

        return question;
    }

    @Override
    public void changeState() {
        if(playGame.getQuestionCounter()==20)
            playGame.setFinished(true);
    }

    @Override
    public boolean checkAnswer(List<String> playerAnswer) {
        boolean feedback = true;

        for(int i = 0;i<answers.size() && feedback;i++){
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

    @Override
    public int getNumberOfAnswer() {
        return 5;
    }

    @Override
    public String toString() {
        return "HARD";
    }
}
