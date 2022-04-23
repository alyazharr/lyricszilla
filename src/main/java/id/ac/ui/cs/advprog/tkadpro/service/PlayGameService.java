package id.ac.ui.cs.advprog.tkadpro.service;

import id.ac.ui.cs.advprog.tkadpro.core.gametype.TypeGame;
import id.ac.ui.cs.advprog.tkadpro.model.QuestionInfo;

import java.util.List;

public interface PlayGameService {
    public QuestionInfo startGame(TypeGame typeGame);
    public QuestionInfo generateQuestion();
    public boolean checkAnswer(List<String> answer);
    public List<String> finishGame();
}
