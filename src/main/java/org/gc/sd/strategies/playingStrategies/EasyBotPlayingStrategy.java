package org.gc.sd.strategies.playingStrategies;

import org.gc.sd.models.Board;
import org.gc.sd.models.Cell;
import org.gc.sd.models.CellState;
import org.gc.sd.models.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Move makeMove(Board board) {
        // In easy bot playing strategy, bot will make a move at firs
        for(List<Cell> row: board.getBoard()) {
            for(Cell cell: row) {
                if(cell.getCellState().equals(CellState.EMPTY)) {
                    // Bot can make a move at this cell.
                    return new Move(cell, null);
                }
            }
        }

//for(int i=0;i<board.getDimension();i++) {
//    for(int j=0;j<board.getDimension();j++) {
//       Cell cell = board.getBoard().get(i).get(j);
//        if(cell.getCellState().equals(CellState.EMPTY)) {
//            // Make a Move.
//        }
//    }
//}
        return null;
    }
}
