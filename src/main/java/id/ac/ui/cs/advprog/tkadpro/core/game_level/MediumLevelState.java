package id.ac.ui.cs.advprog.tkadpro.core.game_level;

import id.ac.ui.cs.advprog.tkadpro.core.game_type.GameType;
import id.ac.ui.cs.advprog.tkadpro.core.modifier.MediumModifier;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class MediumLevelState extends GameLevel{
    private GameType gameType;

    public MediumLevelState(PlayGame playGame){
        super(playGame, "MEDIUM", 3);
        modifier = new MediumModifier(5, 30, 15);
    }

    @Override
    public String play() {
        var mediumQnA = gameType.getMediumQnA();
        String question = mediumQnA.get(0);
        answers = mediumQnA.subList(1,mediumQnA.size());

        return question;
    }

    @Override
    public void changeState() {
        if(playGame.getQuestionCounter() == 11){
            playGame.setCurrentState(playGame.getHardLevelState());
        }
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//        MediumLevelState that = (MediumLevelState) o;
//        return Objects.equals(gameType, that.gameType) && Objects.equals(question, that.question) && Objects.equals(answers, that.answers);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(super.hashCode(), gameType, question, answers);
//    }
}
