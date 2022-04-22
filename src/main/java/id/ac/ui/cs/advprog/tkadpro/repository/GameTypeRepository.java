package id.ac.ui.cs.advprog.tkadpro.repository;

import id.ac.ui.cs.advprog.tkadpro.core.GameType.GameType;
import id.ac.ui.cs.advprog.tkadpro.core.GameType.TypeGame;

import java.util.List;

public interface GameTypeRepository {
    List<GameType> findAll();

    GameType findByType(String type);

    void add(TypeGame typeGame, GameType gameType);
}
