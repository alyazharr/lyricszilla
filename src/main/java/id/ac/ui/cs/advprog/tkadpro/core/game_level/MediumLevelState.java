package id.ac.ui.cs.advprog.tkadpro.core.game_level;

import id.ac.ui.cs.advprog.tkadpro.core.game_type.GameType;
import id.ac.ui.cs.advprog.tkadpro.core.modifier.MediumModifier;
import lombok.Getter;
import lombok.Setter;

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
        createHintAnswer(gameType);

        return question;
    }

    @Override
    public void changeState() {
        if(playGame.getQuestionCounter() == 11){
            playGame.setCurrentState(playGame.getHardLevelState());
        }
    }

    @Override
    public void useHint(PlayGame playGame) {
        if (playGame.getHintCounter() == 1) {
            playGame.setPoints(playGame.getPoints() - 5);
        } else  if (playGame.getHintCounter() == 2) {
            playGame.setPoints(playGame.getPoints() - 8);
        } else  if (playGame.getHintCounter() == 3) {
            playGame.setPoints(playGame.getPoints() - 12);
        }

        gameType.useHint(this, playGame);
    }
}
