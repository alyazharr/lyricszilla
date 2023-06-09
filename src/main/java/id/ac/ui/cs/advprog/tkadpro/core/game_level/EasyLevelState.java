package id.ac.ui.cs.advprog.tkadpro.core.game_level;

import id.ac.ui.cs.advprog.tkadpro.core.game_type.GameType;
import id.ac.ui.cs.advprog.tkadpro.core.modifier.EasyModifier;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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
        createHintAnswer(gameType);

        return question;
    }

    @Override
    public void changeState() {
        if (playGame.getQuestionCounter() == 4){
            playGame.setCurrentState(playGame.getMediumLevelState());
        }
    }

    @Override
    public void useHint(PlayGame playGame) {
        if (playGame.getHintCounter() == 1) playGame.setPoints(playGame.getPoints() - 3);
        else if (playGame.getHintCounter() == 2) playGame.setPoints(playGame.getPoints() - 5);
        else if (playGame.getHintCounter() == 3)  playGame.setPoints(playGame.getPoints() - 8);

        gameType.useHint(this, playGame);
    }
}
