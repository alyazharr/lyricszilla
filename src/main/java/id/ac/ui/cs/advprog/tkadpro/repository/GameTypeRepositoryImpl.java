package id.ac.ui.cs.advprog.tkadpro.repository;

import id.ac.ui.cs.advprog.tkadpro.core.GameType.GameType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GameTypeRepositoryImpl implements GameTypeRepository{
    private Map<String,GameType> gameTypeData = new HashMap<>();

    @Override
    public List<GameType> findAll() {
        return new ArrayList<>(gameTypeData.values());
    }

    @Override
    public GameType findByType(String type) {
        return gameTypeData.get(type);
    }

    @Override
    public void add(String type, GameType gameType) {
        gameTypeData.put(type, gameType);
    }
}
