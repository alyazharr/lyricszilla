package id.ac.ui.cs.advprog.tkadpro.core.GameLevel;

import id.ac.ui.cs.advprog.tkadpro.core.GameType.GameType;
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
    }


    @Override
    public String play() {
        var mediumQnA = gameType.getMediumQnA();
        question = mediumQnA.get(0);
        answers = mediumQnA.subList(1,-1);

        return question;
    }

    @Override
    public void changeState() {
        if(playGame.getQuestionCounter()==10){
            playGame.setCurrentState(playGame.hardLevelState);
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
            playGame.setPoints(playGame.getPoints()+30);
        }
        else {
            playGame.setPoints(playGame.getPoints()-5);
            playGame.setHp(playGame.getHp()-15);
        }

        return feedback;
    }

    @Override
    public String toString() {
        return "MEDIUM";
    }
}
