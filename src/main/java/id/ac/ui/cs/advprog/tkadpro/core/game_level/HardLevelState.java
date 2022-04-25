package id.ac.ui.cs.advprog.tkadpro.core.game_level;

import id.ac.ui.cs.advprog.tkadpro.core.game_type.GameType;
import id.ac.ui.cs.advprog.tkadpro.core.modifier.HardModifier;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

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
        answers = hardQnA.subList(1,hardQnA.size());

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HardLevelState that = (HardLevelState) o;
        return Objects.equals(gameType, that.gameType) && Objects.equals(question, that.question) && Objects.equals(answers, that.answers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gameType, question, answers);
    }
}
