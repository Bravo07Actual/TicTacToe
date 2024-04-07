package org.gc.sd.strategies.winningStrategies;

import org.gc.sd.models.Board;
import org.gc.sd.models.Move;

public interface WinningStrategy {

    boolean checkWinner(Move move, Board board);
}
