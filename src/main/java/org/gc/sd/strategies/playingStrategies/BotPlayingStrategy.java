package org.gc.sd.strategies.playingStrategies;

import org.gc.sd.models.Board;
import org.gc.sd.models.Move;

public interface BotPlayingStrategy {

    Move makeMove(Board board);

}
