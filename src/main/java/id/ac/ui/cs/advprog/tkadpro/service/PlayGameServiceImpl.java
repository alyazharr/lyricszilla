package id.ac.ui.cs.advprog.tkadpro.service;

import id.ac.ui.cs.advprog.tkadpro.core.GameLevel.PlayGame;
import id.ac.ui.cs.advprog.tkadpro.core.GameType.TypeGame;
import id.ac.ui.cs.advprog.tkadpro.model.QuestionInfo;
import id.ac.ui.cs.advprog.tkadpro.repository.GameTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayGameServiceImpl implements PlayGameService {
    private PlayGame playGame = new PlayGame();

    @Autowired
    private GameTypeRepository gameTypeRepository;

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
        if(!playGame.isFinished()){
            question = playGame.play();
        }

        return new QuestionInfo(playGame.getQuestionCounter(), playGame.getPoints(),
                playGame.getNumberOfAnswer(), playGame.getCurrentState().toString(), question, playGame.getHp());
    }

    @Override
    public String checkAnswer(List<String> answer) {
        boolean isTrue = playGame.checkAnswer(answer);
        if(isTrue)
            return "CORRECT";
        return "WRONG";
    }

    @Override
    public List<String> finishGame() {
        List<String> playerAchievements = new ArrayList<>();
        playerAchievements.add(Integer.toString(playGame.getPoints()));
        return playerAchievements;
    }
}