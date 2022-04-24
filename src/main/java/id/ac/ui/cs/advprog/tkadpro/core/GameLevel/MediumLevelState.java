package id.ac.ui.cs.advprog.tkadpro.core.GameLevel;

import id.ac.ui.cs.advprog.tkadpro.core.GameType.GameType;
import id.ac.ui.cs.advprog.tkadpro.core.Modifier.MediumModifier;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MediumLevelState extends GameLevel{
    private GameType gameType;
    private String question;
    private List<String> answers;

    public MediumLevelState(PlayGame playGame){
        super(playGame);
        modifier = new MediumModifier(5, 30, 15);
    }

    @Override
    public String play() {
        var mediumQnA = gameType.getMediumQnA();
        question = mediumQnA.get(0);
        answers = mediumQnA.subList(1,mediumQnA.size());

        return question;
    }

    @Override
    public void changeState() {
        if(playGame.getQuestionCounter() == 11){
            playGame.setCurrentState(playGame.getHardLevelState());
        }
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
        return 3;
    }

    @Override
    public String toString() {
        return "MEDIUM";
    }
}
