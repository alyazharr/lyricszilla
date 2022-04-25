package id.ac.ui.cs.advprog.tkadpro.service;

import id.ac.ui.cs.advprog.tkadpro.core.game_type.TypeGame;
import id.ac.ui.cs.advprog.tkadpro.model.QuestionInfo;

import java.util.List;

public interface PlayGameService {
    public QuestionInfo startGame(TypeGame typeGame);
    public QuestionInfo generateQuestion();
    public String checkAnswer(List<String> answer);
    public List<String> finishGame();
}
