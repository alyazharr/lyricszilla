package id.ac.ui.cs.advprog.tkadpro.core.tools;

import id.ac.ui.cs.advprog.tkadpro.core.game_type.TypeGame;
import id.ac.ui.cs.advprog.tkadpro.core.Level;
import id.ac.ui.cs.advprog.tkadpro.rest.SongDTO;

import java.util.List;

public interface BlankFeature {
    List<String> generateBlankLine(SongDTO song, TypeGame typeGame, Level level);
}
