package id.ac.ui.cs.advprog.tkadpro.service;

import id.ac.ui.cs.advprog.tkadpro.core.game_level.PlayGame;
import id.ac.ui.cs.advprog.tkadpro.core.game_type.TypeGame;
import id.ac.ui.cs.advprog.tkadpro.model.HintInfo;
import id.ac.ui.cs.advprog.tkadpro.model.QuestionInfo;

import java.util.List;

public interface PlayGameService {
    public QuestionInfo startGame(TypeGame typeGame);
    public QuestionInfo generateQuestion();
    public String checkAnswer(List<String> answer);
    public List<String> finishGame();
    public HintInfo useHint();
    public PlayGame getPlayGame();
}
