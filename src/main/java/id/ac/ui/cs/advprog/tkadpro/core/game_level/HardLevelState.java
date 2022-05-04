package id.ac.ui.cs.advprog.tkadpro.core.game_level;

import id.ac.ui.cs.advprog.tkadpro.core.game_type.GameType;
import id.ac.ui.cs.advprog.tkadpro.core.modifier.HardModifier;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HardLevelState extends GameLevel{
    private GameType gameType;

    protected HardLevelState(PlayGame playGame) {
        super(playGame, "HARD", 5);
        modifier = new HardModifier(10, 50, 20);
    }

    @Override
    public String play() {
        var hardQnA = gameType.getHardQnA();
        String question = hardQnA.get(0);
        answers = hardQnA.subList(1,hardQnA.size());
        createHintAnswer(gameType);

        return question;
    }

    @Override
    public void changeState() {
        if(playGame.getQuestionCounter()==20)
            playGame.setFinished(true);
    }

    @Override
    public void useHint(PlayGame playGame) {
        if (playGame.getHintCounter() == 1) {
            playGame.setPoints(playGame.getPoints() - 7);
        } else  if (playGame.getHintCounter() == 2) {
            playGame.setPoints(playGame.getPoints() - 10);
        } else  if (playGame.getHintCounter() == 3) {
            playGame.setPoints(playGame.getPoints() - 15);
        }

        gameType.useHint(this, playGame);
    }
}
