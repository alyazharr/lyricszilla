package id.ac.ui.cs.advprog.tkadpro.repository;

import id.ac.ui.cs.advprog.tkadpro.core.GameType.GameType;
import id.ac.ui.cs.advprog.tkadpro.core.GameType.TypeGame;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GameTypeRepositoryImpl implements GameTypeRepository{
    private Map<TypeGame,GameType> gameTypeData = new HashMap<>();

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
