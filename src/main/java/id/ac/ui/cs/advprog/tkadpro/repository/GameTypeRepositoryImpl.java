package id.ac.ui.cs.advprog.tkadpro.repository;

import id.ac.ui.cs.advprog.tkadpro.core.gametype.GameType;
import id.ac.ui.cs.advprog.tkadpro.core.gametype.TypeGame;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class GameTypeRepositoryImpl implements GameTypeRepository{
    private final Map<TypeGame,GameType> gameTypeData = new EnumMap<>(TypeGame.class);

    @Override
    public List<GameType> findAll() {
        return new ArrayList<>(gameTypeData.values());
    }

    @Override
    public GameType findByType(TypeGame typeGame) {
        return gameTypeData.get(typeGame);
    }

    @Override
    public void add(TypeGame typeGame, GameType gameType) {
        gameTypeData.put(typeGame, gameType);
    }
}
