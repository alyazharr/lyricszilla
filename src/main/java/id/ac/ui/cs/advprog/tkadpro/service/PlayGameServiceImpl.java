package id.ac.ui.cs.advprog.tkadpro.service;

import id.ac.ui.cs.advprog.tkadpro.core.GameLevel.PlayGame;
import id.ac.ui.cs.advprog.tkadpro.core.GameType.TypeGame;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PlayGameServiceImpl implements PlayGameService {
    @Autowired
    PlayGame playGame;


    @Override
    public String startGame(TypeGame typeGame) {
        playGame.setFinished(false);
        playGame.setCurrentState(playGame.easyLevelState);
        
        return generateQuestion();
    }

    @Override
    public String generateQuestion() {
        String question = "";
        if(!playGame.isFinished()){
            question = playGame.play();
        }
        else {

        }

        return question;
    }

    @Override
    public String checkAnswer(List<String> answer) {
        boolean isTrue = playGame.checkAnswer(answer);
        return null;
    }

//    private void chooseGameType(TypeGame typeGame){
//        if(typeGame == TypeGame.LYRICSPATH){
//
//        }
//    }

}
