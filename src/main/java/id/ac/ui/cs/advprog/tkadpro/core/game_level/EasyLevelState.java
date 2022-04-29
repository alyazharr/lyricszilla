package id.ac.ui.cs.advprog.tkadpro.core.game_level;

import id.ac.ui.cs.advprog.tkadpro.core.game_type.GameType;
import id.ac.ui.cs.advprog.tkadpro.core.modifier.EasyModifier;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class EasyLevelState extends GameLevel {
    private GameType gameType;

    public EasyLevelState(PlayGame playGame){
        super(playGame, "EASY", 1);
        modifier = new EasyModifier(3, 10, 10);
    }

    @Override
    public String play() {
        var easyQnA = gameType.getEasyQnA();
        String question = easyQnA.get(0);
        answers = easyQnA.subList(1, easyQnA.size());

        return question;
    }

    @Override
    public void changeState() {
        if(playGame.getQuestionCounter() == 4){
            playGame.setCurrentState(playGame.getMediumLevelState());
        }
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//        EasyLevelState that = (EasyLevelState) o;
//        return Objects.equals(gameType, that.gameType) && Objects.equals(question, that.question) && Objects.equals(answers, that.answers);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(super.hashCode(), gameType, question, answers);
//    }
}
