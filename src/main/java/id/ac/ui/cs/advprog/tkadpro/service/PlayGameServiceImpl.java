package id.ac.ui.cs.advprog.tkadpro.service;

import id.ac.ui.cs.advprog.tkadpro.core.game_level.PlayGame;
import id.ac.ui.cs.advprog.tkadpro.core.game_type.TypeGame;
import id.ac.ui.cs.advprog.tkadpro.model.HintInfo;
import id.ac.ui.cs.advprog.tkadpro.model.QuestionInfo;
import id.ac.ui.cs.advprog.tkadpro.repository.GameTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayGameServiceImpl implements PlayGameService {
    private final PlayGame playGame;

    @Autowired
    private GameTypeRepository gameTypeRepository;

    public PlayGameServiceImpl() {
        playGame = new PlayGame();
    }

    @Override
    public QuestionInfo startGame(TypeGame typeGame) {
        playGame.setFinished(false);
        playGame.setCurrentState(playGame.getEasyLevelState());
        playGame.setGameType(gameTypeRepository.findByType(typeGame));

        return generateQuestion();
    }

    @Override
    public QuestionInfo generateQuestion() {
        String question = null;
        if (!playGame.isFinished()) question = playGame.play();

        return new QuestionInfo(playGame.getQuestionCounter(), playGame.getPoints(),
                playGame.getNumberOfAnswer(), playGame.getCurrentState().toString(), question, playGame.getHp());
    }

    @Override
    public String checkAnswer(List<String> answer) {
        boolean isTrue = playGame.checkAnswer(answer);
        if (isTrue) return "CORRECT";

        return "WRONG";
    }

    @Override
    public List<String> finishGame() {
        List<String> playerAchievements = new ArrayList<>();
        playerAchievements.add(Integer.toString(playGame.getPoints()));
        return playerAchievements;
    }

    @Override
    public HintInfo useHint() { return playGame.useHint(); }

    @Override
    public PlayGame getPlayGame() { return playGame; }
}