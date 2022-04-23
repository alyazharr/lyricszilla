package id.ac.ui.cs.advprog.tkadpro.repository;

import id.ac.ui.cs.advprog.tkadpro.core.gametype.GameType;
import id.ac.ui.cs.advprog.tkadpro.core.gametype.TypeGame;

import java.util.List;

public interface GameTypeRepository {
    List<GameType> findAll();

    GameType findByType(TypeGame typeGame);

    void add(TypeGame typeGame, GameType gameType);
}
