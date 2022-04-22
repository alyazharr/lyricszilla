package id.ac.ui.cs.advprog.tkadpro.service;

import id.ac.ui.cs.advprog.tkadpro.core.GameType.TypeGame;

import java.util.List;

public interface PlayGameService {
    public String startGame(TypeGame typeGame);
    public String generateQuestion();
    public boolean checkAnswer(List<String> answer);
    public List<String> finishGame();
}
