package id.ac.ui.cs.advprog.tkadpro.service;

import id.ac.ui.cs.advprog.tkadpro.core.GameLevel.PlayGame;
import id.ac.ui.cs.advprog.tkadpro.core.GameType.TypeGame;
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
    public String startGame(TypeGame typeGame) {
        playGame.setFinished(false);
        playGame.setCurrentState(playGame.easyLevelState);
        playGame.setGameType(gameTypeRepository.findByType(typeGame));

        return generateQuestion();
    }

    @Override
    public String generateQuestion() {
        String question = null;
        if(!playGame.isFinished()){
            question = playGame.play();
        }
        else {
            question = "NO QUESTION LEFT";
        }

        return question;
    }

    @Override
    public boolean checkAnswer(List<String> answer) {
        boolean isTrue = playGame.checkAnswer(answer);
        return isTrue;
    }

    @Override
    public List<String> finishGame() {
        List<String> playerAchievements = new ArrayList<>();
        playerAchievements.add(Integer.toString(playGame.getPoints()));
        return playerAchievements;
    }
}